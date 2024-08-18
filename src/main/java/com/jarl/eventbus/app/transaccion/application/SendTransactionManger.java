package com.jarl.eventbus.app.transaccion.application;

import com.jarl.eventbus.app.account.application.UpdateBalanceManager;
import com.jarl.eventbus.app.events.BalanceUpdatedEvent;
import com.jarl.eventbus.app.transaccion.domain.TransactionEntity;
import com.jarl.eventbus.app.transaccion.domain.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SendTransactionManger {

    private final TransactionRepository transactionRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void sendTransaction(SendTransactionCommand command) {
        final TransactionEntity transactionEntity = TransactionEntity.builder()
                .amount(command.getAmount())
                .description(command.getDescription())
                .destinationAccountNumber(command.getDestinationAccountNumber())
                .build();

        transactionRepository.save(transactionEntity);

        // Actualiza el balance de la cuenta
        BalanceUpdatedEvent balanceUpdatedEvent = new BalanceUpdatedEvent(this,
                transactionEntity.getDestinationAccountNumber(),
                command.getAmount());
        eventPublisher.publishEvent(balanceUpdatedEvent);

        System.out.printf("Transaction sent destination account number: %s\n ", command.getDestinationAccountNumber() );
    }
}
