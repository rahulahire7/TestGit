package com.controller.shopping;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.shopping.CustomerDao;
import com.model.shopping.Product;


@Controller
/**
* The ProductController program implements an application that
* controls all Products Related Information
*/
public class ProductController 
{
	@Autowired
	CustomerDao cdao;
	/*@Autowired
	DocumentUpload d;*/
	
	@RequestMapping(value="/savefile1")
	public ModelAndView saveimage1(@RequestParam CommonsMultipartFile file,HttpSession session)
	{
		try
		{
			String path="uploads/"+file.getOriginalFilename();
			
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File("D:\\NewProject\\Flipzone5\\WebContent\\uploads\\"+file.getOriginalFilename())));
			stream.write(bytes);
			stream.flush();
			stream.close();
			
			int updateImage = cdao.updateImage1(path, session);
			if(updateImage>0)
				return new ModelAndView("Image2");

			return new ModelAndView("test","message","Image not Updated, Please Try again!!");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	@RequestMapping(value="/savefile2")
	public ModelAndView saveimage2(@RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
		try
		{
			 	String path="uploads/"+file.getOriginalFilename();
			   byte[] bytes = file.getBytes();
				BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File("D:\\NewProject\\Flipzone5\\WebContent\\uploads\\"+file.getOriginalFilename())));
				stream.write(bytes);
				stream.flush();
				stream.close();
				

				int updateImage = cdao.updateImage2(path, session);
				if(updateImage>0)
					return new ModelAndView("Image3");

				return new ModelAndView("Error","message","Image not Updated, Please Try again!!");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	@RequestMapping(value="/savefile3")
	public ModelAndView saveimage3(@RequestParam CommonsMultipartFile file,HttpSession session)
	{
		try
		{
			String path="uploads/"+file.getOriginalFilename();
			
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File("D:\\NewProject\\Flipzone5\\WebContent\\uploads\\"+file.getOriginalFilename())));
			stream.write(bytes);
			stream.flush();
			stream.close();
			

			int updateImage = cdao.updateImage3(path, session);
			if(updateImage>0)
				return new ModelAndView("AddProduct");

			return new ModelAndView("Error","message","Image not Updated, Please Try again!!");
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}

	@RequestMapping("/insertproduct")
	public ModelAndView productInsert(@ModelAttribute Product p,HttpSession session)
	{
		try
		{
			int status=cdao.saveProduct(p);
			if(status>0)
			{
				List<Product> lst = cdao.retrieveAllProduct();
				int lstSize = lst.size();

				int tempId = lst.get(lstSize-1).getPid();
				session.setAttribute("tempId", tempId);
			
				return new ModelAndView("Image1");
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
	@RequestMapping("/search")
	public ModelAndView productSearch(@ModelAttribute Product p)
	{
		try
		{
			List<Product> lst=cdao.searchProduct(p);
			
			for(int i=0;i<lst.size();i++)
			{
				@SuppressWarnings("unused")
				Product p1=lst.get(i);
				
			}
			
			return new ModelAndView("product","Product",lst);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	@RequestMapping("/search1")
	public ModelAndView productSearch1(@ModelAttribute Product p)
	{
		try
		{
			List<Product> lst=cdao.searchAllProduct();
			
			for(int i=0;i<lst.size();i++)
			{
				@SuppressWarnings("unused")
				Product p1=lst.get(i);
				
			}
			return new ModelAndView("product","Product",lst);
		}catch(java.lang.IllegalStateException e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}catch(Exception e)
		{
			return new ModelAndView("Error","exception",e.getMessage());
		}
	}
	
	
	
}
