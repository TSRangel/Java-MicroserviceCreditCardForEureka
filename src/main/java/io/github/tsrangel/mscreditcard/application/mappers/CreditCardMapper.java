package io.github.tsrangel.mscreditcard.application.mappers;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.CreditCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.CreditCardResponseDTO;
import io.github.tsrangel.mscreditcard.domain.entities.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
    CreditCardResponseDTO toDTO(CreditCard card);
    CreditCard toDomain(CreditCardRequestDTO dto);
}
