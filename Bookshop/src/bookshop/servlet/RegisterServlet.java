package bookshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.controllers.CustomerController;
import bookshop.entities.Address;
import bookshop.entities.Customer;
import bookshop.helpers.UserInputCheckHelper;

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
		String message = "";

		if (!UserInputCheckHelper.attributesOrAttributeEmpty(lastName, firstName, street, zipCode, city, email, pwd,
				kindOfCustomer)) {
			String generatedId = "";
			String name = firstName.trim() + " " + lastName.trim();
			boolean userExists = customerController.lookupUser(name).isPresent();
			
			if(userExists) {
				message="Benutzer "+name+" bereits registriert";
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
			else
			{
				int randomId = (int) (Math.random() * (10000 - 1)) + 1;

				if (kindOfCustomer.equals("Privatkunde")) {
					generatedId = "PRV" + randomId;
				} else {
					generatedId = "GEK" + randomId;
				}

				
				Customer customer = new Customer(generatedId, name, email);
				Address address = new Address(street, zipCode, city);
				customer.getAdresses().add(address);

				boolean created = customerController.register(customer, pwd);

				if (!created) {
					message = "Benutzer wurde nicht registriert, etwas schiefgelaufen...";
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("customerId", generatedId);

					getServletContext().getRequestDispatcher("/afterRegisterLogin.jsp").forward(request, response);
				}
			}
			
		} 
		else {
			message = "Eingabe war nicht vollst&aumlndig, bitte alle Felder ausf&uuml;llen...";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
