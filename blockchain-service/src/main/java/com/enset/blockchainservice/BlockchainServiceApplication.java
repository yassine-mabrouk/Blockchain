package com.enset.blockchainservice;

import com.enset.blockchainservice.entities.Block;
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
    BlockService blockService;

    public static void main(String[] args) {
        SpringApplication.run(BlockchainServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //LinkedList<Block> blockchain=new LinkedList();
    }
}
