package com.king.myapp.repository;

import com.king.myapp.domain.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the {@link Coin} entity.
 */
@Repository
public interface CoinRepository extends JpaRepository<Coin, String> {}
