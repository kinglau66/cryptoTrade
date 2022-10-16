package com.king.myapp.repository;

import com.king.myapp.domain.CoinPrice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the {@link CoinPrice} entity.
 */
@Repository
public interface CoinPriceRepository extends JpaRepository<CoinPrice, Long> {
    @Query("select cp from CoinPrice cp where cp.id in (select max(cp2.id) from CoinPrice cp2 group by cp2.symbol)")
    public List<CoinPrice> findByUniqueSymbol();

    @Query("select cp from CoinPrice cp where cp.id in (select max(cp2.id) from CoinPrice cp2 where symbol = ?1 group by cp2.symbol)")
    public List<CoinPrice> findBestPriceBySymbol(String symbol);
}
