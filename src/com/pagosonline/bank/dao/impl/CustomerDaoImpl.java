package com.pagosonline.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.pagosonline.bank.dao.CustomerDao;
import com.pagosonline.bank.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer, String> implements CustomerDao {

}
