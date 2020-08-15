package com.dummy.paymentdummy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.paymentdummy.entity.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer> {

}
