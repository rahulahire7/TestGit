package com.dao.shopping;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.model.shopping.Address;
import com.model.shopping.Cart;
import com.model.shopping.Customer;
import com.model.shopping.Feedback;
import com.model.shopping.ForgotPassword;
import com.model.shopping.Login;
import com.model.shopping.Orders;
import com.model.shopping.Product;
import com.model.shopping.Wishlist;



public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	static String Password;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//Encrypt the Password 
	public static String Encrypt(String password) {
		char ch[]=password.toCharArray();
		String encrypt="";
		for(int i=0;i<password.length()-1;i=i+2)
		{
			char temp=ch[i];
			ch[i]=ch[i+1];
			ch[i+1]=temp;
		}
		for (int i = 0; i < password.length(); i=i+1) {

			encrypt=encrypt+ch[i];
		}

		return "#$!sew^@"+encrypt+"%4!@";

	}

	//Decrypt the Password
	public static String Decrypt(String password) {
		char ch[]=password.toCharArray();
		String decrypt="";
		for(int i=0;i<password.length()-1;i=i+2)
		{
			char temp=ch[i];
			ch[i]=ch[i+1];
			ch[i+1]=temp;
		}
		for (int i = 0; i < password.length(); i=i+1) {

			decrypt=decrypt+ch[i];
		}

		return "#$!sew^@"+decrypt+"%4!@";

	}
	//save customer details in database
	public int saveCustomer(Customer c) {

		String query = "insert into Customers values"+"(seq_cid.nextval,'"+c.getCname()+"','"+c.getCemail()+"','"+c.getCmobile()+"','"+Encrypt(c.getCpass())+"','"+c.getQuestions()+"','"+c.getAnswer()+"')"; 
		return jdbcTemplate.update(query);
	}
	//save login details to database
	public int loginStatus(int cid,Login l)
	{
		String query="insert into Login values"+"(seq_loginid.nextval,'"+l.getLoginstatus()+"','"+cid+"')";
		return jdbcTemplate.update(query);

	}
	public Customer validate(String username)
	{

		String qry="Select * from Customers where cemail=?";

		return jdbcTemplate.queryForObject(qry,new Object[]{username},
				new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	public List<ForgotPassword> forgotPassword(ForgotPassword f)
	{
		String qry="Select * from Customers where cemail="+"('"+f.getEmail()+"')";
		List<ForgotPassword> l=jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<ForgotPassword>(ForgotPassword.class));
		return l;
	}
	public  int forgot(ForgotPassword f)
	{
		String qry="update Customers set cpass='"+f.getPassword()+"' where cemail ='"+f.getEmail()+"'";
		return jdbcTemplate.update(qry);
	}
	public int saveProduct(Product p) {

		String query = "insert into Product values"+"(seq_pid.nextval,'"+p.getPname()+"',"+p.getPprice()+",'"+p.getPcategory()+"','"+p.getPcolor()+"','"+p.getPbrand()+"','"+p.getProduct_size()+"',"+p.getStock_qty()+",'"+p.getPimage1()+"','"+p.getPimage2()+"','"+p.getPimage3()+"')"; 
		return jdbcTemplate.update(query);
	}

	public List<Product> searchProduct(Product p)
	{

		String qry="Select * from Product where pcategory like '%"+p.getPcategory()+"%'";
		List<Product> l=jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Product>(Product.class));


		return l;
	}

	public List<Product> retrieveAllProduct()
	{
		String query = "Select * from Product";
		List<Product> l=jdbcTemplate.query(query, new Object[] {},new BeanPropertyRowMapper<Product>(Product.class));
		return l;
	}

	public int updateImage1(String path,HttpSession session)
	{
		String query = "Update Product Set pimage1='"+path+"' where pid="+session.getAttribute("tempId");

		return jdbcTemplate.update(query);
	}

	public int updateImage2(String path,HttpSession session)
	{
		String query = "Update Product Set pimage2='"+path+"' where pid="+session.getAttribute("tempId");

		return jdbcTemplate.update(query);
	}

	public int updateImage3(String path,HttpSession session)
	{
		String query = "Update Product Set pimage3='"+path+"' where pid="+session.getAttribute("tempId");


		return jdbcTemplate.update(query);
	}
	public  int deleteProductFilters(int pid)
	{
		String qry="Delete from Products_Filters where pid ='"+pid+"'";
		return jdbcTemplate.update(qry);
	}
	public  int deleteProduct(int pid)
	{
		String qry="Delete from Product where pid ='"+pid+"'";
		return jdbcTemplate.update(qry);
	}

	public List<Product> retrieveProductById(int pid)
	{
		String query = "Select * from Product where pid='"+pid+"'";
		List<Product> l=jdbcTemplate.query(query, new Object[] {},new BeanPropertyRowMapper<Product>(Product.class));
		return l;
	}

	public int logout(int cid, int loginStatus) {
		String query = "Update Login Set loginstatus='"+loginStatus+"' where cid='"+cid+"'";
		return jdbcTemplate.update(query);
	}

	public int addToCart(Product p,int cid,Cart ct) 
	{
		String query = "insert into Cart values"+"(seq_cartid.nextval,'"+cid+"','"+p.getPimage1()+"','"+p.getPname()+"','"+p.getPprice()+"','"+ct.getCartquantity()+"','"+ct.getCartprice()+"')"; 
		return jdbcTemplate.update(query);
	}

	public List<Cart> cartDisplay(int cid) {
		String qry="Select * from Cart where cid="+cid;
		List<Cart> l=jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Cart>(Cart.class));

		return l;
	}

	public int deleteCartProduct(int cartid) {
		String qry="Delete from Cart where cartid ='"+cartid+"'";
		return jdbcTemplate.update(qry);
	}

	public int addToWishlist(Product p,int cid,Wishlist w) {
		String query = "insert into Wishlist values"+"(seq_wish_id.nextval,'"+p.getPid()+"','"+cid+"','"+p.getPimage1()+"','"+p.getPname()+"','"+p.getPprice()+"','"+p.getStock_qty()+"')"; 
		return jdbcTemplate.update(query);

	}
	public List<Wishlist> wishlistDisplay() {
		String qry="Select * from Wishlist";
		List<Wishlist> l=jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Wishlist>(Wishlist.class));

		return  l;
	}

	public List<Cart> checkCart(int cid)
	{
		String sql = "Select * from Cart where cid="+cid;
		List<Cart> lst = jdbcTemplate.query(sql, new Object[] {},new BeanPropertyRowMapper<Cart>(Cart.class));

		return lst;
	}

	public int updateCartQuant(Cart c)
	{
		String sql = "Update Cart set cartquantity="+c.getCartquantity()+",carttotal="+c.getCarttotal()+" where cid="+c.getCustid();
		return jdbcTemplate.update(sql);
	}

	public List dataForOrder(int cid)
	{
		String sql = "Select * from Customers c, Delivery_Address a";
		sql +=" where c.cid=a.cid AND c.cid="+cid;

		List lst = jdbcTemplate.queryForList(sql);

		return lst;
	}

	public List<Cart> cartCustomer(int cid)
	{
		String sql = "Select * from Cart where cid="+cid;
		List<Cart> l=jdbcTemplate.query(sql, new Object[] {},new BeanPropertyRowMapper<Cart>(Cart.class));
		return l;
	}
	public int confirmOrder(Orders ord)
	{
		String sql = "Insert into Orders values(seq_oid.nextval,"+ord.getCid()+","+ord.getCart_id()+","+ord.getAid()+","+ord.getOrdered_qty()+","+ord.getTotal_price()+",SYSDATE)";

		return jdbcTemplate.update(sql);
	}

	public int updateQuantity(int pid,int quant) 
	{
		String sql = "Update Product set stock_qty="+quant+" where pid="+pid;
		return jdbcTemplate.update(sql);
	}
	public List<Customer> userprofile(int cid)
	{
		String qry="Select * from Customers where cid="+cid;;
		List<Customer> l= jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Customer>(Customer.class));
		return l;
	}

	public List<Customer> getCustomers() {
		String qry="Select * from Customers ";
		List<Customer> l= jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Customer>(Customer.class));
		return l;

	}
	public List<Product> searchAllProduct()
	{

		String qry="Select * from Product";
		List<Product> l=jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Product>(Product.class));
		return l;
	}

	public int insertAddress(int cid,Address add) 
	{
		String sql = "Insert into Delivery_Address values(seq_aid.nextval,"+cid+",'"+add.getAddressline1()+"','"+add.getAddressline2()+"','"+add.getCity()+"',"+add.getPincode()+",'"+add.getState()+"','"+add.getCountry()+"')";
		return jdbcTemplate.update(sql);
	}

	public int saveCustomerFeedback(Feedback fd)
	{
		String query = "insert into Feedback values"+"(feedback_id.nextval,'"+fd.getCustomername()+"','"+fd.getReview()+"')"; 
		return jdbcTemplate.update(query);

	}
	public List<Feedback> getFeedback() {
		String qry="Select * from Feedback";
		List<Feedback> l= jdbcTemplate.query(qry, new Object[] {},new BeanPropertyRowMapper<Feedback>(Feedback.class));
		return l;

	}

}





