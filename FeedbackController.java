package com.controller.shopping;

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
import com.model.shopping.Feedback;

@SuppressWarnings("unused")
@Controller
/**
* The FeedbackController program implements an application that
* controls feedback of user
*/
public class FeedbackController {
	@Autowired
	CustomerDao cdao;
	
	@RequestMapping("/saveFeedback")
	public ModelAndView saveFeedbackToDatabase(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Feedback fd)
	{
		try
		{
			int feedback=cdao.saveCustomerFeedback(fd);
			
			return new ModelAndView("index");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
}
