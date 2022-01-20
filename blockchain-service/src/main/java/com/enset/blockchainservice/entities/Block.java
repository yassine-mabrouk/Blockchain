package com.enset.blockchainservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity(name = "blocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  long timeStamp ;
    private String hash;
    private String previousHach;
    private long nonce;
    private int indexBlock;
    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Transaction> transactions;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private BlockChain blockChain ;
    @Override
    public int hashCode() {
        return Objects.hash(getTransactions());
    }
    public String AllDataBlock(){
        return this.nonce+this.previousHach+this.hashCode()+this.timeStamp;
    }

}

