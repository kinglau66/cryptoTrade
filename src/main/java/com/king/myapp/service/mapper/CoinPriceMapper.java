package com.king.myapp.service.mapper;

import com.king.myapp.domain.Coin;
import com.king.myapp.domain.CoinPrice;
import com.king.myapp.service.CoinPriceService;
import com.king.myapp.service.dto.CoinBestPriceDTO;
import com.king.myapp.service.dto.CoinDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Coin} and its DTO called {@link CoinDTO}.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Mapper(componentModel = "spring")
public interface CoinPriceMapper {
    @Mapping(source = "bestAskprice", target = "askPrice")
    @Mapping(source = "bestBidprice", target = "bidPrice")
    CoinBestPriceDTO toBestPrice(CoinPrice coinPrice);

    List<CoinBestPriceDTO> toBestPrice(List<CoinPrice> coinPrice);
}
