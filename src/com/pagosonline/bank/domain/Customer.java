package com.pagosonline.bank.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	private String name;

	private String address;

	private String phone;

	@OneToMany(mappedBy = "customer", fetch=FetchType.EAGER)
	private Set<Account> accounts;

	public Customer() {

		this.id = "";
		this.name = "";
		this.address = "";
		this.phone = "";
		this.accounts = new HashSet<Account>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		
		if (account == null) {
			return;
		}
		this.accounts.add(account);
		if (account.getCustomer() != this) {
			account.setCustomer(this);
		}
	}

	@Override
	public String toString() {
		return id + " - " + name;
	}

}
