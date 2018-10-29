package com.controller.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.shopping.CustomerDao;
import com.model.shopping.Product;
import com.model.shopping.Wishlist;

@Controller
public class WishlistController {
	@Autowired
	CustomerDao cdao;
	@RequestMapping(value="/addToWishlist{listID}")
	public ModelAndView addToWishlist(@PathVariable("listID") int pid, HttpServletRequest request,@ModelAttribute Wishlist w )
	{	
		try
		{

			Product p1=null;

			List<Product> lst=cdao.retrieveProductById(pid);
			HttpSession session=request.getSession();
			int cid=(int) session.getAttribute("id");
			for(int i=0;i<lst.size();i++)
			{
				p1=lst.get(i);
				
			}

			int status=cdao.addToWishlist(p1, cid, w);

			if(status>0) {
				List<Wishlist> lst1=cdao.wishlistDisplay();

				return new ModelAndView("Wishlist","wish",lst1);
			}
			else {
				return new ModelAndView("index.jsp");
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
