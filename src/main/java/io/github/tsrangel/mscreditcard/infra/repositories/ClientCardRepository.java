package io.github.tsrangel.mscreditcard.infra.repositories;

import io.github.tsrangel.mscreditcard.domain.entities.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    Set<ClientCard> findByCpf(String cpf);
}
