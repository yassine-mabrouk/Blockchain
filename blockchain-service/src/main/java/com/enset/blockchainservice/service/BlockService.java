package com.enset.blockchainservice.service;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.repositories.BlockRepository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface BlockService {
    public Block createBlock(Block block) ;
    public String calculerHash(Block block) ;
    public void minerBock(int difficulty, Block block );
    public Block getBlockById (long id );
    public List<Block> getAllBlocks();


}
