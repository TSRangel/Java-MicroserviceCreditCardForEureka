package io.github.tsrangel.mscreditcard.application.services;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.ClientCardResponseDTO;
import io.github.tsrangel.mscreditcard.domain.entities.ClientCard;

import java.util.Set;

public interface ClientCardService {
    Set<ClientCardResponseDTO> findAllByClientCardCpf(String cpf);
}
