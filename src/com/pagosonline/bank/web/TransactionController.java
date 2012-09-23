package com.pagosonline.bank.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pagosonline.bank.dao.TransactionDao;
import com.pagosonline.bank.domain.Account;
import com.pagosonline.bank.domain.Transaction;
import com.pagosonline.bank.domain.TransactionType;
import com.pagosonline.bank.exception.InsufficientFundsException;
import com.pagosonline.bank.service.AccountService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Resource
	private AccountService accountService;

	@Resource
	private TransactionDao transactionDao;

	@RequestMapping("/add")
	public ModelAndView showAdd() {

		ModelAndView m = new ModelAndView("transaction/add");

		List<Account> accountsList = new ArrayList<Account>();
		accountsList = accountService.getAll();

		m.addObject("transaction", new Transaction());
		m.addObject("accounts", accountsList);
		m.addObject("types", TransactionType.values());

		return m;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveAction(
			@ModelAttribute("transaction") Transaction transaction,
			BindingResult result) {

		ModelAndView m = new ModelAndView();

		Long accountNumber = transaction.getAccount().getNumber();

		if (accountNumber == 0) {
			m.setViewName("redirect:/transaction/add?error=2");
			return m;
		}
		try {
			transaction = accountService.registerTransaction(accountNumber,
					transaction);

			m.setViewName("transaction/success");
			m.addObject("transaction", transaction.getId());

		} catch (InsufficientFundsException e) {

			m.setViewName("redirect:/transaction/add?error=1");
		}

		return m;
	}

	@RequestMapping("/show/{id}")
	public ModelAndView showEdit(@PathVariable Long id) {

		ModelAndView m = new ModelAndView("transaction/show");

		Transaction t = transactionDao.findByPK(id);
		m.addObject("transaction", t);

		return m;
	}

}
