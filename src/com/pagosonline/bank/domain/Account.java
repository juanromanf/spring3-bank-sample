package com.pagosonline.bank.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false, precision = 10)
	private Long number;

	private Double balance;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "account")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OrderBy("date")
	private Set<Transaction> transactions;

	public Account() {

		this.number = 0L;
		this.balance = 0D;
		this.customer = new Customer();
		this.transactions = new HashSet<Transaction>();
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {

		this.customer = customer;
		if (!customer.getAccounts().contains(this)) {
			customer.getAccounts().add(this);
		}
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void addTransaction(Transaction transaction) {

		if (transaction == null) {
			return;
		}

		this.transactions.add(transaction);
		if (transaction.getAccount() != this) {
			transaction.setAccount(this);
		}
	}

	@Override
	public String toString() {
		return "No. " + number + " - " + customer.getName();
	}

}
