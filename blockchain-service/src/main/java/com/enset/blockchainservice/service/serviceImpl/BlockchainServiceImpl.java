package com.enset.blockchainservice.service.serviceImpl;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.entities.BlockChain;
import com.enset.blockchainservice.entities.Transaction;
import com.enset.blockchainservice.repositories.BlockChainRepository;
import com.enset.blockchainservice.repositories.BlockRepository;
import com.enset.blockchainservice.repositories.TransactionRepository;
import com.enset.blockchainservice.service.BlockService;
import com.enset.blockchainservice.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockchainServiceImpl implements BlockchainService {
    @Autowired
    BlockService blockService;
    @Autowired
    BlockRepository blockRepository ;
    @Autowired
    BlockChainRepository blockChainRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    @Transactional
    public BlockChain createBlockchain(BlockChain blockChain) {
        Block GenisisBlock = blockService.createBlock(new Block());
       // GenisisBlock.setBlockChain(blockChain);
        blockService.minerBock(blockChain.getDifficulty(),GenisisBlock);
       // blockChain.getBlocks().add(GenisisBlock);
        GenisisBlock.setBlockChain(blockChain);
        GenisisBlock.setIndexBlock(0);
        blockRepository.save(GenisisBlock);
        blockChainRepository.save(blockChain);
        return blockChain;
    }





    @Override
    public Block getLastBlock(BlockChain blockChain) {
        return blockChain.getBlocks().get(blockChain.getBlocks().size()-1);
    }

    @Override
    public List<Block> getALLBlocks() {
        return blockRepository.findAll();
    }


    public  boolean isFirstBlockValid(BlockChain blockChain){
        Block firstBlock = blockChain.getBlocks().get(0);
       if (firstBlock.getIndexBlock()!=0) return false;
       if (firstBlock.getPreviousHach()!=null) return false;
        if (firstBlock.getHash()==null) return false;
       //if (firstBlock.getHash()==null || ! blockService.calculerHash(firstBlock).equals(firstBlock.getHash())) return false;
        return  true;
    }

    public boolean isValidBlock(Block currentBlock ,Block previousBlock) {
        if (currentBlock!=null && previousBlock !=null){
            if (previousBlock.getIndexBlock()+1!= currentBlock.getIndexBlock()){
                return false;
            }
        }
        if(currentBlock==null || ! blockService.calculerHash(currentBlock).equals(currentBlock.getHash())) return false;
        if(previousBlock==null || ! blockService.calculerHash(previousBlock).equals(previousBlock.getHash())) return false;
        return true;
    }


    @Override
    public boolean isValidBlockChain(long id ) {
        BlockChain blockChain =blockChainRepository.findById(id).get();

        if(!isFirstBlockValid(blockChain)){
            return false;
        }
        for (int i=1;i< blockChain.getBlocks().size();i++){
            Block currentBlock = blockChain.getBlocks().get(i);
            Block previousBlock = blockChain.getBlocks().get(i-1);
            if (!isValidBlock(currentBlock,previousBlock)) return false;
        }

        return true;

    }

    @Override
    public BlockChain getBlockChain(long id) {
        BlockChain blockChain= blockChainRepository.findById(id).get();
        return blockChain;
    }

    @Transactional
    @Override
    public void addBlock(long idMiner, long idBlockChain,List<Transaction> pendingTransactions) {
        Block block=blockService.createBlock(new Block());
        BlockChain blockChain =blockChainRepository.findById(idBlockChain).get();
        Block lastBlock =this.getLastBlock(blockChain);
        if(block!=null){
            block.setPreviousHach(lastBlock.getHash());
            block.setIndexBlock(lastBlock.getIndexBlock() + 1);
            blockService.minerBock(blockChain.getDifficulty(),block); // save
            pendingTransactions.forEach(pt-> {
                pt.setBlock(block);
            });
            transactionRepository.saveAll(pendingTransactions);

            block.setBlockChain(blockChain);
            blockChain.getBlocks().add(block);
        }
        blockChainRepository.save(blockChain);
    }

    @Override
    public double calculerSoldeAddress(long idBlockChain, String address) {
        BlockChain blockChain =blockChainRepository.findById(idBlockChain).get();

        double solde = 0;

        for (Block block : blockChain.getBlocks())
        {
            for (Transaction transaction : block.getTransactions())
            {
                if(transaction.getAddresseDestination().equals(address))
                    solde+=transaction.getMontant();
            }
        }
        return solde;
    }

    // helper



}
