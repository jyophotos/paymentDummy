package com.dummy.paymentdummy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.paymentdummy.entity.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, String> {

}
