package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,Integer> {

}
