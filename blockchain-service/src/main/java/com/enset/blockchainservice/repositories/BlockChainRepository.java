package com.enset.blockchainservice.repositories;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.entities.BlockChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BlockChainRepository extends JpaRepository<BlockChain,Long> {

}
