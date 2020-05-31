package model.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import bookshop.entities.Author;
import bookshop.entities.Book;
import bookshop.entities.Publisher;
import bookshop.entities.Address;

import bookshop.repositories.facade.RepositoriesFacade;

//import sun.jvm.hotspot.debugger.AddressException;
/*
 * Die Fassade stellt verschiedene Zugriffmethoden auf die Geschäftsobjekte bereit.
 * Weiter initialisiert die Fassade auch einen (transienten) Datenbestand, so dass
 * die Fassade sofort in die Web-Anwendung eingebaut werden kann.
 * 
 * Die Fassade ist als Singleton implememtiert!
 */
public class ModelFacade {
	private static class InstanceHolder {
		private static ModelFacade instance = new ModelFacade();
	}

	public static ModelFacade getInstance() {
		return InstanceHolder.instance;
	}

	private List<Autor> autorenContainer = new ArrayList<Autor>();
	private List<Buch> buchContainer = new ArrayList<Buch>();
	private List<CustomerView> customerContainer = new ArrayList<CustomerView>();
	private RepositoriesFacade facade = RepositoriesFacade.getInstance();

	private ModelFacade() {
		super();
		// this.initModel();
		this.mapEmtitiesAndViewModels();

	}

	public Collection<CustomerView> getAllCustomers(){
		mapCustomers();
		return this.customerContainer;
	}
	
	public CustomerView getCustomerById(String id) {
		mapCustomers();
		Optional<CustomerView> optionalCustomer = customerContainer.stream().filter(c->c.getCustomerId().equals(id)).findFirst();
		return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
	}
	
	// Liefert alle Bücher eines Autors.
	// Als Wildcard wird * akzeptiert
	public Collection<Buch> findBuecherFromAutor(String name) {
		mapBooks();
		mapAuthors();
		Set<Buch> result = new HashSet<Buch>();

		String[] names = name.split("\\*");

		for (Autor a : this.autorenContainer) {
			boolean found = true;
			for (String searchString : names) {
				if (a.getNachname().toLowerCase().contains(searchString.toLowerCase()) == true) {
					found &= true;
				} else {
					found &= false;
				}

			}
			if (found)
				result.addAll(a.getBuecher());
		}

		return result;
	}

	// Liefert ein Buch mit der geforderten ID
	public Buch findBuchById(long buchId) {
		mapBooks();
		Buch result = null;

		for (Buch b : this.buchContainer) {
			if (b.getId() == buchId) {
				result = b;
				break;
			}
		}

		return result;
	}

	public Collection<Buch> getAlleBuecher() {
		mapBooks();
		return new ArrayList<Buch>(this.buchContainer);
	}

	public Collection<Autor> getAlleAutoren() {
		mapAuthors();
		return new ArrayList<Autor>(this.autorenContainer);
	}

	
	private void mapEmtitiesAndViewModels() {
		mapBooks();
		mapAuthors();
		mapCustomers();
	}

	private void mapCustomers() {
		Set<bookshop.entities.Customer> customers = new HashSet<bookshop.entities.Customer>();
		customers = facade.getAllCustomers();
		for(bookshop.entities.Customer customer : customers) {
			CustomerView customerView = new CustomerView(customer.getId(), customer.getName(), customer.getEmail());
			customerView.setPassword(customer.getPassword());
			Collection<Book> customerBooks = new HashSet<Book>();
			customerBooks = customer.getBooks();
			for(Book book : customerBooks) {
				Buch buch = new Buch(
						Long.parseLong(book.getId()),
						book.getTitle(),
						book.getPublisher().getName(),
						book.getBookPrise().getPrise());
				customerView.addBuch(buch);
			}
			
			this.customerContainer.add(customerView);
		}
	}

	private void mapAuthors() {
		Set<Author> authors = new HashSet<Author>();
		authors = facade.getAllAuthors();
		for (Author author : authors) {
			Autor autor = new Autor(author.getId(), author.getFirstName(), author.getLastName());
			Set<Book> bookss = new HashSet<Book>();
			bookss= author.getBooks();
			for(Book book : bookss) {
				Buch buch = new Buch(
						Long.parseLong(book.getId()),
						book.getTitle(),
						book.getPublisher().getName(),
						book.getBookPrise().getPrise());
				autor.addBuch(buch);
				buch.addAutor(autor);
			}
			this.autorenContainer.add(autor);
		}
	}

	private void mapBooks() {
		Set<Book> books = new HashSet<Book>();
		books= facade.getAllBooks();
		for (Book book : books) {

			Buch buch = new Buch(Long.parseLong(book.getId()), book.getTitle(), book.getPublisher().getName(), 11);
			Set<Author> authors = new HashSet<Author>();
			authors = book.getAutors();
			for(Author author : authors) {
				Autor autor = new Autor(author.getId(),author.getFirstName(), author.getLastName());
				buch.addAutor(autor);
				autor.addBuch(buch);
			}
			this.buchContainer.add(buch);
		}
	}
}
