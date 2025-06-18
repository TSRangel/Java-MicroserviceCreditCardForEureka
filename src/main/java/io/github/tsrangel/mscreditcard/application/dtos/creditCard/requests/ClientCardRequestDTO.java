package io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests;

import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public record ClientCardRequestDTO(
        String name,
        CardBanner banner,
        BigDecimal income,
        BigDecimal availableLimit
) {
}
