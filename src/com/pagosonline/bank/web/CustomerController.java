package com.pagosonline.bank.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pagosonline.bank.dao.CustomerDao;
import com.pagosonline.bank.domain.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerDao customerDao;

	@RequestMapping("/add")
	public ModelAndView showAdd() {

		ModelAndView m = new ModelAndView("customer/add");
		m.addObject("customer", new Customer());
		return m;
	}

	@RequestMapping("/list")
	public ModelAndView showList() {

		ModelAndView m = new ModelAndView("customer/list");
		m.addObject("customers", customerDao.getAll("order by c.name"));
		return m;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEdit(@PathVariable String id) {

		ModelAndView m = new ModelAndView("customer/edit");
		m.addObject("customer", customerDao.findByPK(id));
		return m;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAction(@ModelAttribute("customer") Customer customer,
			BindingResult result) {
		
		if(customer.getId().isEmpty()) {
			return "redirect:/customer/add?error=1";
		}

		if (customerDao.findByPK(customer.getId()) == null) {
			customerDao.insert(customer);
		} else {
			customerDao.update(customer);
		}

		return "redirect:/customer/list";
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView showDelete(@PathVariable String id) {

		ModelAndView m = new ModelAndView("customer/delete");
		m.addObject("customer", customerDao.findByPK(id));
		return m;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteAction(@ModelAttribute("customer") Customer customer,
			BindingResult result) {

		customer = customerDao.findByPK(customer.getId());
		customerDao.delete(customer);

		return "redirect:/customer/list";
	}
}
