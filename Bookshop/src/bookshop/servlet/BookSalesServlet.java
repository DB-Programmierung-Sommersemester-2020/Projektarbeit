package bookshop.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.entities.Book;
import bookshop.entities.Customer;
import bookshop.repositories.facade.RepositoriesFacade;
import bookshop.viewmodels.*;

@WebServlet("/purchase")
public class BookSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepositoriesFacade repositoriesFacade = null;

	public BookSalesServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		repositoriesFacade = RepositoriesFacade.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		String message = "";

		if (!customerId.isBlank()) {

			Customer customer = repositoriesFacade.getCustomerById(customerId);
			Warenkorb warenkorb = (Warenkorb) session.getAttribute("warenkorb");

			Collection<Book> books = repositoriesFacade.getAllBooks();
			Collection<Buch> booksView = warenkorb.getInhalt();

			for (Buch buch : booksView) {
				String buchId = Long.toString(buch.getId());
				Optional<Book> book = books.stream()
						.filter(b -> b.getId().equals(buchId))
						.findFirst();
				if(book.isPresent()) {
					customer.getBooks().add(book.get());
				}
				else {
					message = "Buch wurde nicht gefunden";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
					break;
				}			
			}

			boolean isPurchased = repositoriesFacade.updateCustomer(customer);

			if (isPurchased) {
				
				Customer updatedCustomer = new Customer();
				updatedCustomer = repositoriesFacade.getCustomerById(customer.getId()); //refresh 
				request.setAttribute("purchases", updatedCustomer.getPurchases());
				
				getServletContext().getRequestDispatcher("/danke.jsp").forward(request, response);
			} else {
				message = "Einkauf ist fehlgeschlagen, bitte wenden Sie sich an unsere Support</br>&#9990;:1234 567890</br>&#9993;:support@email.de";
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
