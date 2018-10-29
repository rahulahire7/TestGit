package com.controller.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.shopping.CustomerDao;
import com.model.shopping.Customer;
import com.model.shopping.Product;
import com.model.shopping.Feedback;
@Controller
/**
 * The AdminController program implements an application that
 * controls all Admin side information
 */
public class AdminController
{

	@Autowired
	CustomerDao cdao;

	@RequestMapping("/list")
	/**
	 * 
	 * @param args used 
	 * @return ModelAndView
	 * see Exception
	 */
	public ModelAndView productSearch(@ModelAttribute Product p)
	{
		try
		{
			List<Product> lst = cdao.retrieveAllProduct();
			return new  ModelAndView("ProductList","Product",lst);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
		catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	@SuppressWarnings("unused")
	@RequestMapping("/delete{listID}")
	/**
	 * 
	 * @param pid
	 * @param p
	 * @return
	 */
	public ModelAndView deleteProduct(@PathVariable("listID") int pid,@ModelAttribute Product p)
	{
		try
		{
			int status1=cdao.deleteProduct(pid);
			return new  ModelAndView("Success","Product","hello");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	@RequestMapping("/customer")
	public ModelAndView customer(@ModelAttribute Customer c)
	{
		try
		{
			List<Customer> l=cdao.getCustomers();
			return new  ModelAndView("CustList","Cust",l);
		}
		catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	/**
	 * 
	 * @param fd
	 * @return 
	 */
	@RequestMapping("/feedbacklist1")
	public ModelAndView Feedback(@ModelAttribute Feedback fd)
	{
		try
		{
			List<Feedback> l=cdao.getFeedback();
			return new  ModelAndView("FeedbackList","feedback_list",l);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}

}
