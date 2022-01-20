package com.enset.blockchainservice.web;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blocks")
public class BlockController {
    private BlockService blockchainservice;

    public BlockController(BlockService blockchainservice) {
        this.blockchainservice = blockchainservice;
    }

    @GetMapping(path = "/{id}")
    public Block getBlock (@PathVariable long id ){
        return  blockchainservice.getBlockById(id);
    }
    @GetMapping
    public List<Block> getAllBlocks (){
        return  blockchainservice.getAllBlocks();
    }


}
