package com.jarl.eventbus.controller;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendTransactionDTO {
    private String description;
    private String destinationAccountNumber;
    private BigDecimal amount;
}
