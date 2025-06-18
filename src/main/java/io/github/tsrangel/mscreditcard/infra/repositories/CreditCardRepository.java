package io.github.tsrangel.mscreditcard.infra.repositories;

import io.github.tsrangel.mscreditcard.domain.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
