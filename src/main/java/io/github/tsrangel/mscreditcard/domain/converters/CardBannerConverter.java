package io.github.tsrangel.mscreditcard.domain.converters;

import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CardBannerConverter implements AttributeConverter<CardBanner, String> {

    @Override
    public String convertToDatabaseColumn(CardBanner cardBanner) {
        return cardBanner != null ? cardBanner.getDescription() : null;
    }

    @Override
    public CardBanner convertToEntityAttribute(String s) {
        return s != null ? CardBanner.fromDescription(s) : null;
    }
}
