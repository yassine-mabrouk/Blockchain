package com.enset.blockchainservice;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.entities.Miner;
import com.enset.blockchainservice.repositories.MinerRepository;
import com.enset.blockchainservice.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.LinkedList;

@SpringBootApplication
public class BlockchainServiceApplication implements CommandLineRunner {
    @Autowired
    MinerRepository minerRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlockchainServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //LinkedList<Block> blockchain=new LinkedList();
        Miner miner =new Miner();
        miner.setId(1);
        miner.setSolde(0);
        miner.setAddressCompte("yas12B12");
        minerRepository.save(miner);
    }
}
