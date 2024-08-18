package com.jarl.eventbus.app.events;

import com.jarl.eventbus.app.account.application.UpdateBalanceManager;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BalanceUpdatedListener {

    private final UpdateBalanceManager updateBalanceManager;

   //  @Async("taskExecutor") // Aquí especificas que este listener será asíncrono
    @EventListener
    public void handleBalanceUpdated(BalanceUpdatedEvent event) {
        updateBalanceManager.updateBalance(event.getAccountNumber(), event.getTransactionAmount());
    }
}
