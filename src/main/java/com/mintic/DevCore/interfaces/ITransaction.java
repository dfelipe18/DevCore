package com.mintic.DevCore.interfaces;

import com.mintic.DevCore.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransaction extends JpaRepository<Transaction, Long> {
}
