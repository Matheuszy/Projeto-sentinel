package com.matheuszy.Sentinel.domain.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    private Timestamp time;

    private Integer transaction_id;

    private Long merchantCategory;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getMerchantCategory() {
        return merchantCategory;
    }

    public void setMerchantCategory(Long merchantCategory) {
        this.merchantCategory = merchantCategory;
    }

    public Transaction() {}

    public Transaction(BigDecimal amount, Timestamp dateTime, Integer transaction_id, Long merchantCategory) {
        this.amount = amount;
        this.time = dateTime;
        this.transaction_id = transaction_id;
        this.merchantCategory = merchantCategory;
    }



}
