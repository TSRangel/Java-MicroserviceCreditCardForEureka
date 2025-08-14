package io.github.tsrangel.mscreditcard.application.mappers;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.CreditCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.CreditCardResponseDTO;
import io.github.tsrangel.mscreditcard.domain.entities.CreditCard;
import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
    @Mapping(source = "banner", target = "banner", qualifiedByName = "mapBannerToDescription")
    CreditCardResponseDTO toDTO(CreditCard card);
    CreditCard toDomain(CreditCardRequestDTO dto);

    @Named("mapBannerToDescription")
    static String mapBannerToDescription(CardBanner banner) {
        return banner != null ? banner.getDescription() : null;
    }
}
