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
import com.model.shopping.Address;
import com.model.shopping.Cart;
import com.model.shopping.Orders;
import com.model.shopping.Product;

@Controller
public class CartController {
	@Autowired
	CustomerDao cdao;
	@RequestMapping(value="/tocart")
	public ModelAndView addToCart(HttpServletRequest request,@ModelAttribute Cart ct )
	{	
		try
		{
			HttpSession session=request.getSession();
			int pid = Integer.parseInt(request.getParameter("pid"));
			int quant = Integer.parseInt(request.getParameter("num-product"));
			
			ModelAndView mav = new ModelAndView();
			
			
			int status=0;
			
			Product p1=null;
			Cart c1 = null;
			
			

			List<Product> lst=cdao.retrieveProductById(pid);
			
			session.setAttribute("pro", lst);
			int cid;
			try
			{
				cid=(int) session.getAttribute("id");
				
				List<Cart> crt = cdao.checkCart(cid);
				
				if(!(lst.isEmpty() && crt.isEmpty()))
				{
					for(int i=0;i<lst.size();i++)
					{
						p1=lst.get(i);
						
						ct.setCartquantity(quant);
						ct.setCartprice(p1.getPprice()*ct.getCartquantity());
						
						
						
						status=cdao.addToCart(p1,cid,ct);
					}
					if(status>0) 
					{
						
						List<Cart> lst1=cdao.cartDisplay(cid);
						
						mav.addObject("lss1", lst1);
						
						mav.setViewName("shoping-cart");
						return mav;
					}
				}
				
			}catch(NullPointerException e)
			{
				mav.setViewName("login");;
				return mav;
			}
			mav.setViewName("index");
			return mav;
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			
			return new ModelAndView("Error","exception",e.getMessage());
		}
		
	}
	@RequestMapping(value="/tocartProduct{lst}")
	public ModelAndView deletecartproduct(@PathVariable("lst") int cartid,@ModelAttribute Cart ct )
	{	
		try
		{
			int status1=cdao.deleteCartProduct(cartid);
			return new  ModelAndView("Success","Cart","hello");
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}

	
	
	@RequestMapping(value="/tocartpid{listID}")
	public ModelAndView tocartpid(@PathVariable("listID") int pid,@ModelAttribute Cart ct )
	{	
		try
		{
			Product p1=null;

			List<Product> lst=cdao.retrieveProductById(pid);
			
			for(int i=0;i<lst.size();i++)
			{
				p1=lst.get(i);
			}

			return new ModelAndView("product-detail","CartList",lst);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	@RequestMapping(value="/Product")
	public ModelAndView product(@ModelAttribute Cart ct )
	{	
		try
		{
			List<Product> lst = cdao.retrieveAllProduct();
			return new ModelAndView("product","Prod",lst);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	@RequestMapping(value="/confirmOrder")
	public ModelAndView confirmOrder(HttpServletRequest request,@ModelAttribute Orders ord,@ModelAttribute Address add1)
	{
		try
		{
			HttpSession session=request.getSession();
			int cid=(Integer) session.getAttribute("id"); 
			
			double sum = Double.parseDouble(request.getParameter("sum"));
			
			String addline1 = request.getParameter("addline1");
			add1.setAddressline1(addline1);
			
			String addline2 = request.getParameter("addline2");
			add1.setAddressline2(addline2);
			
			String city = request.getParameter("city");
			add1.setCity(city);
			
			String state = request.getParameter("state");
			add1.setState(state);
			
			long pincode = Long.parseLong(request.getParameter("pincode"));
			add1.setPincode(pincode);
			
			List<Cart> lst=cdao.cartCustomer(cid);
			int add_status = cdao.insertAddress(cid,add1);
			
			if(add_status>0)
			{
				for(Cart crt: lst)
				{
					ord.setCart_id(crt.getCartid());
					ord.setCid(cid);
					ord.setAid(add1.getAid());
					ord.setOrdered_qty(crt.getCartquantity());
					ord.setTotal_price(sum);
					
					List<Product> lstProd = (List<Product>)session.getAttribute("pro");
					Product p = lstProd.get(0);
					int finQuant=0;
					
					if(ord.getOrdered_qty()>p.getStock_qty())
					{
						return new ModelAndView("Error","exception","Ordered Quantity not in stock");
					}
					else
					{
						finQuant = p.getStock_qty()-ord.getOrdered_qty();
						if(finQuant<=0)
						{
							return new ModelAndView("Error","exception","Oops,Shortage in Quantity or Product out of stock!");
						}else
						{
							int status1 = cdao.updateQuantity(p.getPid(),finQuant);
							int status2 = cdao.confirmOrder(ord);
							
							if(status1>0 && status2>0)
							{
								int status3 = cdao.deleteCartProduct(crt.getCartid());
								if(status3>0)
									return new ModelAndView("Feedback","message","Order successfully placed!");
								else
									return new ModelAndView("Error","exception","Some problem occured..please try again!");
							}
							else
								break;
						}
						
					}
					
				}
			}
			
			return new ModelAndView("Error","exception","Order can't be placed!");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
}


