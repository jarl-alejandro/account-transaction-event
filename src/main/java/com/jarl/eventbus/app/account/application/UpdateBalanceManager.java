package com.jarl.eventbus.app.account.application;

import com.jarl.eventbus.app.account.domain.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@Component
public class UpdateBalanceManager {
    private final AccountRepository accountRepository;

    public void updateBalance(String accountNumber, BigDecimal transactionAmount) {
        accountRepository.findByAccountNumber(accountNumber)
                .ifPresent(account -> {
                    account.updateBalance(transactionAmount);
                    accountRepository.save(account);
                });
    }

}
