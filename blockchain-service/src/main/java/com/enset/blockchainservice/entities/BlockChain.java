package com.enset.blockchainservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "blockchains")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name ;
    private int difficulty;
    private double miningReward;
    @OneToMany(mappedBy = "blockChain",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Block> blocks=new ArrayList<>();

}

