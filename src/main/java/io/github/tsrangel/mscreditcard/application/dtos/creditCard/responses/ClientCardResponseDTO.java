package io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ClientCardResponseDTO(
        Long id,
        String cpf,
        BigDecimal income,
        Set<CreditCardResponseDTO> creditCards,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
        LocalDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
        LocalDateTime updatedAt
) {
}
