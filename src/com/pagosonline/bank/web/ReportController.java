package com.pagosonline.bank.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pagosonline.bank.dao.CustomerDao;
import com.pagosonline.bank.domain.Customer;
import com.pagosonline.bank.domain.CustomerAccountsReportParams;

@Controller
@RequestMapping("/report")
public class ReportController {

	private static Logger logger = LoggerFactory
			.getLogger(ReportController.class);

	@Resource
	private CustomerDao customerDao;

	@PersistenceContext
	protected EntityManager em;

	@InitBinder
	public void binder(WebDataBinder binder) {

		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
				} catch (ParseException e) {
					setValue(null);
				}
			}

			public String getAsText() {
				return new SimpleDateFormat("yyyy-MM-dd")
						.format((Date) getValue());
			}

		});
	}

	@RequestMapping("/customer-accounts")
	public ModelAndView showCustomerAccountsReportForm() {

		ModelAndView m = new ModelAndView("report/customer-accounts");

		List<Customer> customersList = new ArrayList<Customer>();
		customersList = customerDao.getAll("order by c.name");

		m.addObject("report", new CustomerAccountsReportParams());
		m.addObject("customers", customersList);

		return m;
	}

	@RequestMapping(value = "/customer-accounts", method = RequestMethod.POST)
	public ModelAndView showCustomerAccountsReport(
			@ModelAttribute("report") CustomerAccountsReportParams params,
			BindingResult result) {

		String customerId = params.getCustomer().getId();
		Date start = params.getStartDate();
		Date end = params.getEndDate();

		String sql = "SELECT a.customer_id, a.number, a.balance,"
				+ "(select sum(transactions.amount) from transactions where transactions.account_id = a.number and transactions.type = 'CREDIT') as credits,"
				+ "(select sum(transactions.amount) from transactions where transactions.account_id = a.number and transactions.type = 'DEBIT') as debits"
				+ " FROM accounts a LEFT JOIN transactions t ON a.number = t.account_id "
				+ " WHERE a.customer_id = ? AND t.date between ? AND ? "
				+ " GROUP BY a.number ORDER BY a.number";

		Query query = em.createNativeQuery(sql);
		query.setParameter(1, customerId);
		query.setParameter(2, start, TemporalType.DATE);
		query.setParameter(3, end, TemporalType.DATE);

		logger.info("Generating report for customer: {}   start: {}   end: {}",
				new Object[] { customerId, start, end });

		@SuppressWarnings("unchecked")
		List<Object[]> rowList = query.getResultList();

		Customer customer = customerDao.findByPK(params.getCustomer().getId());

		ModelAndView m = new ModelAndView("report/customer-accounts-result");
		m.addObject("result", rowList);
		m.addObject("customer", customer);

		return m;

	}
}
