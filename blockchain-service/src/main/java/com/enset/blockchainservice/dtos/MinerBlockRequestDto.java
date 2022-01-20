package com.enset.blockchainservice.dtos;

import com.enset.blockchainservice.entities.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class MinerBlockRequestDto {
    long idMiner;
    long idBlockchain;
    List<Transaction> pendingTransactions;
}
