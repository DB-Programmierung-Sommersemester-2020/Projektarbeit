package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.controllers.CustomerController;
import bookshop.entities.Address;
import bookshop.entities.Customer;
import bookshop.repositories.facade.RepositoriesFacade;
import model.shop.ModelFacade;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerController customerController = null;
	public RegisterServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.customerController = CustomerController.getInstance();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lastName = request.getParameter("nachname");
		String firstName = request.getParameter("vorname");
		String street = request.getParameter("street");
		String zipCode = request.getParameter("plz");
		String city = request.getParameter("vorname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("passwd");
		String kindOfCustomer = request.getParameter("kind");
		
		String generatedId ="";
		int randomId = (int) (Math.random() * (10000 - 1)) + 1;
		
		if(kindOfCustomer.equals("Privatkunde")) {			
			generatedId="PRV"+randomId;
		}else {
			generatedId="GEK"+randomId;
		}
		

		String name = firstName.trim()+" "+lastName.trim();
		Customer customer = new Customer(generatedId,name,email);
		Address address = new Address(street,zipCode,city);
		customer.getAdresses().add(address);
		
		customerController.register(customer, pwd);
		
		getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
