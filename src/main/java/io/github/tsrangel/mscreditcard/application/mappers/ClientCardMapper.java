package io.github.tsrangel.mscreditcard.application.mappers;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.ClientCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.ClientCardResponseDTO;
import io.github.tsrangel.mscreditcard.domain.entities.ClientCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientCardMapper {
    @Mapping(target = "name", source = "creditCard.name")
    @Mapping(target = "banner", source = "creditCard.banner.getDescription()")
    ClientCardResponseDTO toDTO(ClientCard clientCard);
    ClientCard toDomain(ClientCardRequestDTO dto);
}
