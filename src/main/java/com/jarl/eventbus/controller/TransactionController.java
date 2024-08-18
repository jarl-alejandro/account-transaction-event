package com.jarl.eventbus.controller;

import com.jarl.eventbus.app.transaccion.application.GetTransactionManager;
import com.jarl.eventbus.app.transaccion.application.SendTransactionCommand;
import com.jarl.eventbus.app.transaccion.application.SendTransactionManger;
import com.jarl.eventbus.app.transaccion.domain.TransactionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final GetTransactionManager getTransactionManager;
    private final SendTransactionManger sendTransactionManger;

    public TransactionController(GetTransactionManager getTransactionManager, SendTransactionManger sendTransactionManger) {
        this.getTransactionManager = getTransactionManager;
        this.sendTransactionManger = sendTransactionManger;
    }

    @PostMapping
    public ResponseEntity<Void> sendTransaction(@RequestBody SendTransactionDTO sendTransactionDTO) {
        final SendTransactionCommand command = SendTransactionCommand.builder()
                .destinationAccountNumber(sendTransactionDTO.getDestinationAccountNumber())
                .amount(sendTransactionDTO.getAmount())
                .description(sendTransactionDTO.getDescription())
                .build();

        sendTransactionManger.sendTransaction(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{destinationAccountNumber}")
    public ResponseEntity<List<TransactionEntity>> getTransaction(@PathVariable String destinationAccountNumber) {
        final List<TransactionEntity> transactionEntities = getTransactionManager.list(destinationAccountNumber);
        return ResponseEntity.ok(transactionEntities);
    }
}
