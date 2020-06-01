package bookshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.controllers.CustomerController;
import bookshop.helpers.UserInputCheckHelper;
import bookshop.viewmodels.CustomerView;
import bookshop.viewmodels.ViewModelFacade;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerController customerController = null;
	private ViewModelFacade viewModelFacade = null;

	public LoginServlet() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.customerController = CustomerController.getInstance();
		this.viewModelFacade = ViewModelFacade.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("user");
		String pwd = request.getParameter("passwd");
		String message ="";
		if (!UserInputCheckHelper.attributesOrAttributeEmpty(email,pwd)) {
			CustomerView customer = viewModelFacade.getAllCustomers()
					.stream()
					.filter(c->c.getEmail()
							.equals(email))
					.findFirst().get();

			if (customerController.checkPassword(customer, pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("customerId", customer.getCustomerId());
				
				getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
			}else {
				message="Login war nicht erfolgreich, Benutzername oder Kennwort ist falsch...";
				request.setAttribute("message", message );
				getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}else {
			message="Eingabe war nicht vollst&aumlndig, bitte alle Felder ausf&uuml;llen...";
			request.setAttribute("message", message );
			getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
