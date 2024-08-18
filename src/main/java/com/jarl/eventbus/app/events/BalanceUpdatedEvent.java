package com.jarl.eventbus.app.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

@Getter
public class BalanceUpdatedEvent extends ApplicationEvent {
    private final String accountNumber;
    private final BigDecimal transactionAmount;

    public BalanceUpdatedEvent(Object source, String accountNumber, BigDecimal transactionAmount) {
        super(source);
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
    }
}
