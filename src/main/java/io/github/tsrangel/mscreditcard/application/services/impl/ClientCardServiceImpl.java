package io.github.tsrangel.mscreditcard.application.services.impl;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.ClientCardResponseDTO;
import io.github.tsrangel.mscreditcard.application.mappers.ClientCardMapper;
import io.github.tsrangel.mscreditcard.application.services.ClientCardService;
import io.github.tsrangel.mscreditcard.domain.entities.ClientCard;
import io.github.tsrangel.mscreditcard.infra.repositories.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientCardServiceImpl implements ClientCardService {
    private final ClientCardMapper clientCardMapper;
    private final ClientCardRepository clientCardRepository;

    @Override
    public Set<ClientCardResponseDTO> findAllByClientCardCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf)
                .stream().map(clientCardMapper::toDTO)
                .collect(Collectors.toSet());
    }
}
