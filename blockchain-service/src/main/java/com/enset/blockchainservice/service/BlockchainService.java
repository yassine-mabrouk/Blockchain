package com.enset.blockchainservice.service;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.entities.BlockChain;
import com.enset.blockchainservice.entities.Transaction;

import java.util.List;

public interface BlockchainService {
    public BlockChain createBlockchain(BlockChain blockchainservice );
    public Block getLastBlock(BlockChain blockChain);
    public List<Block> getALLBlocks();
    public  boolean isValidBlockChain(long id );
    public BlockChain getBlockChain(long id );
    public void addBlock(long idMiner, long idBlockChain,List<Transaction> pendingTransactions);
    public double calculerSoldeAddress(long idBlockChain, String address);
}
