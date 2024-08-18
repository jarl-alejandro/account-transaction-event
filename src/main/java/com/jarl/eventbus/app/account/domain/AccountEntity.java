package com.jarl.eventbus.app.account.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String accountNumber;
    private BigDecimal balance;


    public void updateBalance(BigDecimal transactionAmount) {
        this.balance = this.balance.add(transactionAmount);
        System.out.println("Update Balance: " + this.balance);
    }
}
