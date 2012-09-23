package com.pagosonline.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.pagosonline.bank.dao.AccountDao;
import com.pagosonline.bank.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

}
