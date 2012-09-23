package com.pagosonline.bank.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pagosonline.bank.dao.AccountDao;
import com.pagosonline.bank.dao.TransactionDao;
import com.pagosonline.bank.domain.Account;
import com.pagosonline.bank.domain.Transaction;
import com.pagosonline.bank.domain.TransactionType;
import com.pagosonline.bank.exception.InsufficientFundsException;

@Service
public class AccountService {

	@Resource
	private AccountDao accountDao;

	@Resource
	private TransactionDao transactionDao;

	public List<Account> getAll() {

		return accountDao.getAll("order by c.number");
	}

	public Account findByNumber(Long number) {

		return accountDao.findByPK(number);
	}

	public Account registerAccount(Account account) {

		return accountDao.insert(account);
	}

	public Account updateAccount(Account account) {

		return accountDao.update(account);
	}

	public void deleteAccount(Account account) {

		accountDao.delete(account);
	}

	public Transaction registerTransaction(Long accountNumber,
			Transaction transaction) throws InsufficientFundsException {

		Account account = accountDao.findByPK(accountNumber);

		double balance = 0;

		if (TransactionType.CREDIT.equals(transaction.getType())) {

			if (transaction.getAmount() > account.getBalance()) {
				throw new InsufficientFundsException("");

			} else {
				balance = account.getBalance() - transaction.getAmount();
				account.setBalance(balance);
			}

		} else {

			balance = account.getBalance() + transaction.getAmount();
		}

		account.setBalance(balance);
		transaction.setAccount(account);
		transaction = transactionDao.insert(transaction);

		account.addTransaction(transaction);
		accountDao.update(account);

		return transaction;
	}

}
