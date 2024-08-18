package com.jarl.eventbus.app.account.application;

import com.jarl.eventbus.app.account.domain.AccountEntity;
import com.jarl.eventbus.app.account.domain.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class GetAccountManger {
    private final AccountRepository accountRepository;

    public List<AccountEntity> list() {
        return accountRepository.findAll();
    }

    public AccountEntity get(Long id) {
        return accountRepository.findById(id)
                .orElse(null);
    }
}
