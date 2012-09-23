package com.pagosonline.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.pagosonline.bank.dao.TransactionDao;
import com.pagosonline.bank.domain.Transaction;

@Repository("transactionDao")
public class TransactionDaoImpl extends GenericDaoImpl<Transaction, Long> implements TransactionDao {

}
