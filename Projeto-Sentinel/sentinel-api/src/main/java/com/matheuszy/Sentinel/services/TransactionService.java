package com.matheuszy.Sentinel.services;

import com.matheuszy.Sentinel.domain.dto.TransactionRequest;
import com.matheuszy.Sentinel.domain.entities.Transaction;
import com.matheuszy.Sentinel.repositories.TransactionRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction(
                transactionRequest.amount(),
                transactionRequest.timestamp(),
                transactionRequest.transaction_id(),
                transactionRequest.merchantCategory());
        transactionRepository.save(transaction);
        rabbitTemplate.convertAndSend("transaction.exchange", "transaction.routing.key", transaction);

        System.out.println("Transação salva e enviada para análise: " + transaction.getTransaction_id());

        return transaction;
    }



}
