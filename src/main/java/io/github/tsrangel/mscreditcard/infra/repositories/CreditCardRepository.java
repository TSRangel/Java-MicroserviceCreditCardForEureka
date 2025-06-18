package io.github.tsrangel.mscreditcard.infra.repositories;

import io.github.tsrangel.mscreditcard.domain.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByName(String name);
    Set<CreditCard> findByIncomeLessThanEqual(BigDecimal value);
}
