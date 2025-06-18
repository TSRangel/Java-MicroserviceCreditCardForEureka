package io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreditCardResponseDTO(
        Long id,
        String name,
        CardBanner banner,
        BigDecimal income,
        BigDecimal availableLimit,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
        LocalDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
        LocalDateTime updatedAt
) {
}
