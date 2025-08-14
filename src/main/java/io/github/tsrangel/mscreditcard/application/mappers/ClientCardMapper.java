package io.github.tsrangel.mscreditcard.application.mappers;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.ClientCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.ClientCardResponseDTO;
import io.github.tsrangel.mscreditcard.domain.entities.ClientCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CreditCardMapper.class)
public interface ClientCardMapper {
    ClientCardResponseDTO toDTO(ClientCard clientCard);
    ClientCard toDomain(ClientCardRequestDTO dto);
}
