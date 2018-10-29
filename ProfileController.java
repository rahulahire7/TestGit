package com.controller.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.shopping.CustomerDao;
import com.model.shopping.Customer;
import com.model.shopping.Product;

@Controller
/**
* The ProfileController program implements an application that
* shows the user details
*/
public class ProfileController {
	@Autowired
	CustomerDao cdao;
	@RequestMapping("/userprofile")
	public ModelAndView productSearch(HttpServletRequest request,@ModelAttribute Product p)
	{
		try
		{
			HttpSession session=request.getSession();
			int loginStatus=(int)session.getAttribute("loginid");
			if(loginStatus>0)
			{
			session.getAttribute("id");
			int cid=(int) session.getAttribute("id");
			List<Customer> lst=cdao.userprofile(cid);
			return new  ModelAndView("Myprofile","Cust",lst);
			}
			else
			{
			return new ModelAndView("login");
			}
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
		
	}
}
