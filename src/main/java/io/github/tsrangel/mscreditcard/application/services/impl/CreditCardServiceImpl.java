package io.github.tsrangel.mscreditcard.application.services.impl;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.CreditCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.CreditCardResponseDTO;
import io.github.tsrangel.mscreditcard.application.mappers.CreditCardMapper;
import io.github.tsrangel.mscreditcard.application.services.CreditCardService;
import io.github.tsrangel.mscreditcard.application.services.exceptions.ResourceAlreadyExistsException;
import io.github.tsrangel.mscreditcard.domain.entities.CreditCard;
import io.github.tsrangel.mscreditcard.infra.repositories.CreditCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardMapper creditCardMapper;
    private final CreditCardRepository creditCardRepository;

    @Transactional
    @Override
    public CreditCardResponseDTO create(CreditCardRequestDTO dto) {
        if (creditCardRepository.findByName(dto.name()).isPresent()) {
            throw new ResourceAlreadyExistsException("Já existe um cartão de crédito cadastrado com o nome " + dto.name() + ".");
        }

        CreditCard card = creditCardRepository.save(creditCardMapper.toDomain(dto));
        return creditCardMapper.toDTO(card);
    }

    @Override
    public Set<CreditCardResponseDTO> findCreditCardsByIncomeLessThanEqual(Long value) {
        BigDecimal income = BigDecimal.valueOf(value);
        return creditCardRepository.findByAvailableLimitLessThanEqual(income)
                .stream().map(creditCardMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public  Set<CreditCardResponseDTO> findAllByClientCardCpf(String cpf) {
        return creditCardRepository.findAllByClientCardCpf(cpf)
                .stream().map(creditCardMapper::toDTO)
                .collect(Collectors.toSet());
    }
}
