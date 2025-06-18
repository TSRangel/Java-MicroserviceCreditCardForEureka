package io.github.tsrangel.mscreditcard.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "client_card_tb")
public class ClientCard extends BaseEntity{
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
    private BigDecimal limit;
}
