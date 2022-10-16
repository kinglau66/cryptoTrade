package com.king.myapp.service;

import com.king.myapp.domain.CoinPrice;
import com.king.myapp.repository.CoinPriceRepository;
import com.king.myapp.service.dto.BinanceDTO;
import com.king.myapp.service.dto.CoinBestPriceDTO;
import com.king.myapp.service.dto.HuobiDatumDTO;
import com.king.myapp.service.dto.HuobiResDTO;
import com.king.myapp.service.mapper.CoinPriceMapper;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CoinPriceService {

    private final CoinPriceRepository coinPriceRepository;
    private final CoinPriceMapper coinPriceMapper;
    Log log = LogFactory.getLog(CoinPriceService.class);

    @Autowired
    public CoinPriceService(CoinPriceRepository coinPriceRepository, CoinPriceMapper coinPriceMapper) {
        this.coinPriceRepository = coinPriceRepository;
        this.coinPriceMapper = coinPriceMapper;
    }

    @Scheduled(fixedRate = 10000)
    @Transactional
    public Iterable<CoinPrice> aggregateprice() {
        WebClient client = WebClient
            .builder()
            .baseUrl("https://api.binance.com/api/v3/ticker/bookTicker")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
        List<BinanceDTO> binanceRes = client.get().retrieve().bodyToMono(new ParameterizedTypeReference<List<BinanceDTO>>() {}).block();
        client =
            WebClient
                .builder()
                .baseUrl("https://api.huobi.pro/market/tickers")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        HuobiResDTO huobiRes = client.get().retrieve().bodyToMono(HuobiResDTO.class).block();
        String btcusdt = ServiceConstants.BTCUSDT;
        String ethusdt = ServiceConstants.ETHUSDT;
        assert binanceRes != null;
        Map<String, BinanceDTO> binanceMap = binanceRes
            .parallelStream()
            .filter(item -> item.getSymbol().equalsIgnoreCase(btcusdt) || item.getSymbol().equalsIgnoreCase(ethusdt))
            .collect(Collectors.toMap(item -> item.getSymbol().toUpperCase(), Function.identity()));
        assert huobiRes != null;
        Map<String, HuobiDatumDTO> huobiMap = huobiRes
            .getData()
            .parallelStream()
            .filter(item -> item.getSymbol().equalsIgnoreCase(btcusdt) || item.getSymbol().equalsIgnoreCase(ethusdt))
            .collect(Collectors.toMap(item -> item.getSymbol().toUpperCase(), Function.identity()));
        List<CoinPrice> priceList = List.of(
            CoinPrice.CoinPriceBuilder
                .aCoinPrice()
                .withSymbol(btcusdt)
                .withFrCoinCode("BTC")
                .withToCoinCode("USD")
                .withBinanceAskPrice(
                    BigDecimal.valueOf(Optional.ofNullable(binanceMap.get(btcusdt)).map(BinanceDTO::getAskPriceDouble).orElse(0.0D))
                )
                .withBinanceBidPrice(
                    BigDecimal.valueOf(Optional.ofNullable(binanceMap.get(btcusdt)).map(BinanceDTO::getBidPriceDouble).orElse(0.0D))
                )
                .withHuobiAskPrice(BigDecimal.valueOf(Optional.ofNullable(huobiMap.get(btcusdt)).map(HuobiDatumDTO::getAsk).orElse(0.0D)))
                .withHuobiBidPrice(BigDecimal.valueOf(Optional.ofNullable(huobiMap.get(btcusdt)).map(HuobiDatumDTO::getBid).orElse(0.0D)))
                .withQueryTime(Instant.now())
                .build(),
            CoinPrice.CoinPriceBuilder
                .aCoinPrice()
                .withSymbol(ethusdt)
                .withFrCoinCode("ETH")
                .withToCoinCode("USD")
                .withBinanceAskPrice(
                    BigDecimal.valueOf(Optional.ofNullable(binanceMap.get(ethusdt)).map(BinanceDTO::getAskPriceDouble).orElse(0.0D))
                )
                .withBinanceBidPrice(
                    BigDecimal.valueOf(Optional.ofNullable(binanceMap.get(ethusdt)).map(BinanceDTO::getBidPriceDouble).orElse(0.0D))
                )
                .withHuobiAskPrice(BigDecimal.valueOf(Optional.ofNullable(huobiMap.get(ethusdt)).map(HuobiDatumDTO::getAsk).orElse(0.0D)))
                .withHuobiBidPrice(BigDecimal.valueOf(Optional.ofNullable(huobiMap.get(ethusdt)).map(HuobiDatumDTO::getBid).orElse(0.0D)))
                .withQueryTime(Instant.now())
                .build()
        );
        return coinPriceRepository.saveAll(priceList);
    }

    public List<CoinBestPriceDTO> getBestPrice() {
        return this.coinPriceMapper.toBestPrice(this.coinPriceRepository.findByUniqueSymbol());
    }
}
