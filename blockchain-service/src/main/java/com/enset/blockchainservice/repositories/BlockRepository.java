package com.enset.blockchainservice.repositories;

import com.enset.blockchainservice.entities.Block;
import com.enset.blockchainservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface BlockRepository extends JpaRepository<Block,Long> {

}