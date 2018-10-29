package com.controller.shopping;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dao.shopping.CustomerDao;
import com.model.shopping.Customer;
import com.model.shopping.ForgotPassword;
import com.model.shopping.Login;


@Controller

public class CustomerController {
	static int cid;
	@Autowired
	CustomerDao cdao;
	
//Registeration of customer
	@RequestMapping("/insert")
	public ModelAndView insertCustomer(@ModelAttribute Customer c)
	{
		try
		{
			int status=cdao.saveCustomer(c);
			if(status>0)
			{
				return new ModelAndView("login");
			}
			return new ModelAndView("Error","message","Insert unsuccessful");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	//validate the user
	@RequestMapping(value="/validate")
	public ModelAndView validateData(HttpServletRequest request,@ModelAttribute Login l)
	{
		try
		{
			if(l.getUsername().equals("admin@gmail.com") && l.getPassword().equals("admin@123ADMIN"))
			{
				return new ModelAndView("Admin");
			}
			else 
			{
				HttpSession session=request.getSession();
				Customer c=cdao.validate(l.getUsername());
				
				if(c.getCemail().equals(l.getUsername()) && c.getCpass().equals(cdao.Encrypt(l.getPassword())))
				{
					int loginstatus=1;
					l.setLoginstatus(loginstatus);
					session.setAttribute("loginid", loginstatus);
					int status=cdao.loginStatus(c.getCid(), l);
					session.setAttribute("id",c.getCid());
					return new ModelAndView("index");
				}
				else
				{
					return new ModelAndView("login");
				}
			}
			
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
//Forgot Password
	@RequestMapping(value="/forgotpassword")
	public ModelAndView forgotPassword(HttpServletRequest request,@ModelAttribute ForgotPassword f)
	{
		try
		{
			HttpSession session=request.getSession();
			List<ForgotPassword> lst= cdao.forgotPassword(f);
			
			for(int i=0;i<lst.size();i++)
			{
				ForgotPassword f1=new ForgotPassword();
				f1=lst.get(i);
				session.setAttribute("email",f.getEmail());
				if(f1.getAnswer().equalsIgnoreCase(f.getAnswer()))
					return new ModelAndView("ForgotPassword1","message",f);
				else
					return new ModelAndView("Error","message","incorrect");
					
			}
				return null;
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	//reset password
	@RequestMapping(value="/forgot")
	public ModelAndView forgot(HttpServletRequest request,@ModelAttribute ForgotPassword f)
	{
		try
		{
			HttpSession session=request.getSession();
			String email=(String) session.getAttribute("email");
			f.setEmail(email);
			int status=cdao.forgot(f);
			return new ModelAndView("index");
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	@RequestMapping("/logoutCustomer")
	public void logout(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Customer c)
	{
		try
		{
			HttpSession session=request.getSession();
			int cid=(int) session.getAttribute("loginid");
			
			int loginStatus=0;

			int status=cdao.logout(cid,loginStatus);
			if(status>0)
			{
				session.removeAttribute("loginid");
				session.invalidate();
				
				response.sendRedirect("index.jsp");
			}
			response.sendRedirect("index.jsp");
		}catch(java.lang.IllegalStateException e)
		{
			
		}catch(Exception e)
		{
			
		}
	}


}