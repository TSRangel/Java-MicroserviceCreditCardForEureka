package io.github.tsrangel.mscreditcard.domain.enums;

import java.util.Arrays;

public enum CardBanner {
    VISA("Visa"),
    MASTERCARD("Mastercard");

    private final String description;

    CardBanner(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static CardBanner fromDescription(String description) {
        return Arrays.stream(CardBanner.values())
                .filter(cd -> cd.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Descrição inválida: " + description));
    }
}
