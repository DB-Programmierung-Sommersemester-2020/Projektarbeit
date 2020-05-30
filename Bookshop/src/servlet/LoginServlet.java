package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.controllers.CustomerController;
import bookshop.helpers.UserInputCheckHelper;
import model.shop.CustomerView;
import model.shop.ModelFacade;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerController customerController = null;
	private ModelFacade viewModelFacade = null;

	public LoginServlet() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.customerController = CustomerController.getInstance();
		this.viewModelFacade = ModelFacade.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("user");
		String pwd = request.getParameter("passwd");
		String message ="";
		if (!UserInputCheckHelper.attributesOrAttributeEmpty(email,pwd)) {
			CustomerView customer = viewModelFacade.getCustomerById(email);

			if (customerController.checkPassword(customer, pwd)) {
				getServletContext().getRequestDispatcher("/kaufinformation.jsp").forward(request, response);
			}else {
				message="Login war nicht erfolgreich, Benutzername oder Kennwort ist falsch...";
			}
		}
		message="Eingabe war nicht vollst&aumlndig, bitte alle Felder ausf&uuml;llen...";
		request.setAttribute("message", message );
		getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
