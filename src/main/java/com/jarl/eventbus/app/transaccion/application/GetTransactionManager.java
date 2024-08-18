package com.jarl.eventbus.app.transaccion.application;

import com.jarl.eventbus.app.transaccion.domain.TransactionEntity;
import com.jarl.eventbus.app.transaccion.domain.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class GetTransactionManager {
    private final TransactionRepository transactionRepository;

    public List<TransactionEntity> list(String destinationAccountNumber) {
        if (Objects.isNull(destinationAccountNumber)) {
            return Collections.emptyList();
        }
        return transactionRepository.findByDestinationAccountNumber(destinationAccountNumber);
    }
}
