package io.github.tsrangel.mscreditcard.domain.entities;

import io.github.tsrangel.mscreditcard.domain.enums.CardBanner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "credit_card_tb")
public class CreditCard extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private CardBanner banner;
    @Column(nullable = false)
    private BigDecimal availableLimit;
    @ManyToOne
    @JoinColumn(name = "client_card_id", nullable = false, foreignKey = @ForeignKey(name= "fk_credit_card_client_card"))
    private ClientCard clientCard;
}
