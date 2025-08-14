package io.github.tsrangel.mscreditcard.application.services;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.CreditCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.CreditCardResponseDTO;

import java.util.Set;

public interface CreditCardService {
    CreditCardResponseDTO create(CreditCardRequestDTO dto);
    Set<CreditCardResponseDTO> findCreditCardsByIncomeLessThanEqual(Long value);
    Set<CreditCardResponseDTO> findAllByClientCardCpf(String cpf);
}
