package com.jarl.eventbus.app.account.application;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccountCommand {
    private String nameAccount;
    private String numberAccount;
}
