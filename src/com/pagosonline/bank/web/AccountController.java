package com.pagosonline.bank.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pagosonline.bank.dao.AccountDao;
import com.pagosonline.bank.dao.CustomerDao;
import com.pagosonline.bank.domain.Account;
import com.pagosonline.bank.domain.Customer;

@Controller
@RequestMapping("/account")
public class AccountController {

	private static Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@Resource
	private AccountDao accountDao;

	@Resource
	private CustomerDao customerDao;

	@RequestMapping("/add")
	public ModelAndView showAdd() {

		ModelAndView m = new ModelAndView("account/add");

		List<Customer> customersList = new ArrayList<Customer>();
		customersList = customerDao.getAll("order by c.name");

		m.addObject("account", new Account());
		m.addObject("customers", customersList);
		return m;
	}

	@RequestMapping("/list")
	public ModelAndView showList() {

		ModelAndView m = new ModelAndView("account/list");
		m.addObject("accounts", accountDao.getAll("order by c.number"));
		return m;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEdit(@PathVariable Long id) {

		ModelAndView m = new ModelAndView("account/edit");

		List<Customer> customersList = new ArrayList<Customer>();
		customersList = customerDao.getAll("order by c.name");

		m.addObject("customers", customersList);
		m.addObject("account", accountDao.findByPK(id));

		return m;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveAction(@ModelAttribute("account") Account account,
			BindingResult result) {

		ModelAndView m = new ModelAndView("account/success");

		if ("NONE".equalsIgnoreCase(account.getCustomer().getId())) {
			m.setViewName("redirect:/account/add?error=1");
			return m;
		}

		Customer customer = customerDao.findByPK(account.getCustomer().getId());
		account.setCustomer(customer);

		if (accountDao.findByPK(account.getNumber()) == null) {
			account = accountDao.insert(account);
			m.addObject("created", true);

		} else {
			account = accountDao.update(account);
		}

		m.addObject("account", account.getNumber());

		return m;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView showDelete(@PathVariable Long id) {

		ModelAndView m = new ModelAndView("account/delete");
		m.addObject("account", accountDao.findByPK(id));
		return m;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteAction(@ModelAttribute("account") Account account,
			BindingResult result) {

		account = accountDao.findByPK(account.getNumber());
		logger.info("Deleting account number: {}", account.getNumber());
		accountDao.delete(account);

		return "redirect:/account/list";
	}

	@RequestMapping("/transactions/{id}")
	public ModelAndView showTransactions(@PathVariable Long id) {

		ModelAndView m = new ModelAndView("account/transactions");

		Account account = accountDao.findByPK(id);

		m.addObject("account", account);
		m.addObject("transactions", account.getTransactions());

		return m;
	}

}
