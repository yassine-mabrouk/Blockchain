package com.enset.blockchainservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "miners")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Miner {
    @Id
    private long id ;
    private String addressCompte ;
    private double solde ;
    @OneToMany
    private List<Block> blocks ;
}
