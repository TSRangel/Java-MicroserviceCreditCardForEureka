package io.github.tsrangel.mscreditcard.application.controllers;

import io.github.tsrangel.mscreditcard.application.dtos.creditCard.requests.CreditCardRequestDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.ClientCardResponseDTO;
import io.github.tsrangel.mscreditcard.application.dtos.creditCard.responses.CreditCardResponseDTO;
import io.github.tsrangel.mscreditcard.application.services.ClientCardService;
import io.github.tsrangel.mscreditcard.application.services.CreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("cards")
@Slf4j
public class CreditCardController {
    private final CreditCardService creditCardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String index() {
        log.info("Obtendo o status do microserviço de cartões de crédito.");
        return "Welcome to the Credit Card Service API!";
    }

    @PostMapping
    public ResponseEntity<CreditCardResponseDTO> create(@RequestBody CreditCardRequestDTO dto) {
        CreditCardResponseDTO card = creditCardService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().query("name={name}")
                .buildAndExpand(card.name()).toUri();

        return ResponseEntity.created(location).body(card);
    }

    @GetMapping(params = "income")
    public ResponseEntity<Set<CreditCardResponseDTO>> findCardsByIncome(@RequestParam Long income) {
        return ResponseEntity.ok().body(creditCardService.findCreditCardsByIncomeLessThanEqual(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Set<ClientCardResponseDTO>> findCardsByClientCpf(@RequestParam String cpf) {
        return ResponseEntity.ok().body(clientCardService.findAllByClientCardCpf(cpf));
    }
}
