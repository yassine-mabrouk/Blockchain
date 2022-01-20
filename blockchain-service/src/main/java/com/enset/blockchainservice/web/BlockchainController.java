package com.enset.blockchainservice.web;


import com.enset.blockchainservice.dtos.MinerBlockRequestDto;
import com.enset.blockchainservice.dtos.SoldeAddressRequestDto;
import com.enset.blockchainservice.entities.BlockChain;
import com.enset.blockchainservice.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blockchains")
public class BlockchainController {
    @Autowired
    BlockchainService blockchainservice;
    @PostMapping
    public BlockChain createBlockchain (@RequestBody BlockChain blockchain){
      return  blockchainservice.createBlockchain(blockchain);
    }
    @GetMapping(path = "/{id}")
    public  BlockChain getBlockchainById(@PathVariable long id ){

        return  blockchainservice.getBlockChain(id);
    }


    @GetMapping(path = "/minerBlock")
    public void minerBlock(@RequestBody MinerBlockRequestDto request ){
        blockchainservice.addBlock(request.getIdMiner(),
                request.getIdBlockchain(),request.getPendingTransactions());
    }

    @GetMapping(path = "/isValid/{id}")
    public boolean isValid(@PathVariable long id ) {
        return blockchainservice.isValidBlockChain(id);
    }
    @GetMapping(path = "/calculerSoldeAddress")
    public double getSoldeAddress(@RequestBody SoldeAddressRequestDto request){
        return blockchainservice.calculerSoldeAddress(request.getIdBlockchain(),request.getAddress());
    }

}

