package com.jarl.eventbus.controller;

import com.jarl.eventbus.app.account.domain.AccountEntity;
import com.jarl.eventbus.app.account.application.CreateAccountCommand;
import com.jarl.eventbus.app.account.application.CreateAccountManager;
import com.jarl.eventbus.app.account.application.GetAccountManger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final GetAccountManger getAccountManger;
    private final CreateAccountManager createAccountManager;

    public AccountController(GetAccountManger getAccountManger, CreateAccountManager createAccountManager) {
        this.getAccountManger = getAccountManger;
        this.createAccountManager = createAccountManager;
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAccounts() {
        final List<AccountEntity> accountEntities = getAccountManger.list();
        return ResponseEntity
                .ok(accountEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccount(@PathVariable Long id) {
        final AccountEntity accountEntity = getAccountManger.get(id);
        return ResponseEntity.ok(accountEntity);
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody CreateAccountDTO createAccountDTO) {
        CreateAccountCommand accountCommand = CreateAccountCommand.builder()
                .nameAccount(createAccountDTO.getNameAccount())
                .numberAccount(createAccountDTO.getNumberAccount())
                .build();

        createAccountManager.create(accountCommand);
        return ResponseEntity.ok().build();
    }
}
