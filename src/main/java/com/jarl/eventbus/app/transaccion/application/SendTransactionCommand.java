package com.jarl.eventbus.app.transaccion.application;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class SendTransactionCommand {
    private String description;
    private String destinationAccountNumber;
    private BigDecimal amount;
}
