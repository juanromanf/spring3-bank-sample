package com.pagosonline.bank.domain;

import java.util.Date;

public class CustomerAccountsReportParams {

	private Customer customer;

	private Date startDate;

	private Date endDate;

	public CustomerAccountsReportParams() {

		this.customer = new Customer();
		this.startDate = new Date();
		this.endDate = new Date();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
