package com.jarl.eventbus.app.account.application;

import com.jarl.eventbus.app.account.domain.AccountEntity;
import com.jarl.eventbus.app.account.domain.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class CreateAccountManager {

    private final AccountRepository accountRepository;

    public void create(CreateAccountCommand command) {
        final AccountEntity accountEntity = AccountEntity.builder()
                .accountName(command.getNameAccount())
                .accountNumber(command.getNumberAccount())
                .balance(BigDecimal.ZERO)
                .build();

        accountRepository.save(accountEntity);
    }
}
