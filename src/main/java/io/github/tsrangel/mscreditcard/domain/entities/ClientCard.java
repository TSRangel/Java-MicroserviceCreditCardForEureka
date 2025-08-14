package io.github.tsrangel.mscreditcard.domain.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "client_card_tb")
public class ClientCard extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private BigDecimal income;
    @OneToMany(mappedBy="clientCard", cascade = CascadeType.REMOVE)
    private Set<CreditCard> creditCards;
}
