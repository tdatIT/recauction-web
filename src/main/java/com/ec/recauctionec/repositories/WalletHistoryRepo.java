package com.ec.recauctionec.repositories;

import com.ec.recauctionec.entity.WalletHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletHistoryRepo extends JpaRepository<WalletHistory, Integer> {
}
