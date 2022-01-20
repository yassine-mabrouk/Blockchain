package com.enset.blockchainservice.repositories;

import com.enset.blockchainservice.entities.Miner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinerRepository  extends JpaRepository<Miner,Long> {

}
