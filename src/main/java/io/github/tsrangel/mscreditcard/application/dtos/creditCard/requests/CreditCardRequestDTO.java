package io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests;

import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreditCardRequestDTO(
        @NotBlank(message = "Nome é um campo obrigatório.")
        String name,
        @NotNull(message = "Bandeira é um campo obrigatório.")
        CardBanner banner,
        @NotNull(message = "Renda é um campo obrigatório.")
        BigDecimal income,
        @NotNull(message = "Limite disponível é um campo obrigatório.")
        BigDecimal availableLimit
) {
}
