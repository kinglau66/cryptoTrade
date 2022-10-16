package com.king.myapp.service.mapper;

import com.king.myapp.domain.Coin;
import com.king.myapp.service.dto.CoinDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Coin} and its DTO called {@link CoinDTO}.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Mapper(componentModel = "spring")
public interface CoinMapper {
    CoinDTO toDTO(Coin coin);
    Coin toEntity(CoinDTO coin);
}
