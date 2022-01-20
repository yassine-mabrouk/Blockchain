package com.enset.blockchainservice.service.serviceImpl;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.repositories.BlockRepository;
import com.enset.blockchainservice.service.BlockService;
import com.enset.blockchainservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl  implements BlockService {
    @Autowired
    BlockRepository blockRepository;
    @Override
    public Block createBlock(Block block)  {
        block.setTimeStamp(System.currentTimeMillis());
        block.setHash(this.calculerHash(block));
        block.setNonce(0);
        blockRepository.save(block);
        return block;
    }

    @Override
    public String calculerHash( Block block)  {
        return Utils.sha256(block.AllDataBlock());
    }

    @Override
    public void minerBock (int difficulty,Block block){
        block.setNonce(0);
        while (!block.getHash().substring(0,difficulty).equals(Utils.zeros(difficulty))){
            block.setNonce(block.getNonce()+1);
            block.setHash(calculerHash(block));
            System.out.println(block.getHash());
        }
        blockRepository.save(block);
    }

    @Override
    public Block getBlockById(long id) {
        return blockRepository.findById(id).get();
    }

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

}
