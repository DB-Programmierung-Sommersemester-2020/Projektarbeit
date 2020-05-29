package bookshop.repositories.facade;

import java.util.Set;

import bookshop.entities.Address;
import bookshop.entities.Author;
import bookshop.entities.Book;
import bookshop.entities.Customer;
import bookshop.entities.Password;
import bookshop.entities.Publisher;
import bookshop.repositories.implementations.AddressRepository;
import bookshop.repositories.implementations.AuthorRepository;
import bookshop.repositories.implementations.BookRepository;
import bookshop.repositories.implementations.CustomerRepository;
import bookshop.repositories.implementations.PasswordRepository;
import bookshop.repositories.implementations.PublisherRepository;
import bookshop.repositories.implementations.RepositoriesContainer;
import bookshop.repositories.services.RepositoriesContainerService;

public class RepositoriesFacade {
	private RepositoriesContainerService repositories;
	private static RepositoriesFacade instance;
	
	private RepositoriesFacade() {
		this.repositories = new RepositoriesContainer(
				new AuthorRepository(), 
				new BookRepository(), 
				new AddressRepository(), 
				new PublisherRepository(), 
				new CustomerRepository(),
				new PasswordRepository());
	}
	
	public static RepositoriesFacade getInstance() {
		return (instance == null) ? new RepositoriesFacade() : instance;
	}
	
	public Author getAuthorById(int id) {
		return repositories.getAuthorRepository().getByKey(id);
	}
	
	public Set<Author> getAllAuthors(){
		return repositories.getAuthorRepository().getAll();
	}
	
	public boolean createAuthor(Author author) {
		return repositories.getAuthorRepository().create(author);
	}
	
	public boolean updateAuthor(Author author) {
		return repositories.getAuthorRepository().update(author);
	}
	
	public boolean deleteAuthor(Author author) {
		return repositories.getAuthorRepository().delete(author);
	}
	
	public Address getAddressById(int id) {
		return repositories.getAddressRepository().getByKey(id);
	}
	
	public Set<Address> getAllAddresses(){
		return repositories.getAddressRepository().getAll();
	}
	
	public boolean createAddress(Address address) {
		return repositories.getAddressRepository().create(address);
	}
	
	public boolean updateAddress(Address address) {
		return repositories.getAddressRepository().update(address);
	}
	
	public boolean deleteAddress(Address address) {
		return repositories.getAddressRepository().delete(address);
	}
	
	public Publisher getPublisherById(String id) { //id is a name of publisher
		return repositories.getPublisherRepository().getByKey(id);
	}
	
	public Set<Publisher> getAllPublishers(){
		return repositories.getPublisherRepository().getAll();
	}
	
	public boolean createPublisher(Publisher publisher) {
		return repositories.getPublisherRepository().create(publisher);
	}
	
	public boolean updatePublisher(Publisher publisher) {
		return repositories.getPublisherRepository().update(publisher);
	}
	
	public boolean deletePublisher(Publisher publisher) {
		return repositories.getPublisherRepository().delete(publisher);
	}
	
	public Customer getCustomerById(String id) {
		return repositories.getCustomerRepository().getByKey(id);
	}
	
	public Set<Customer> getAllCustomers(){
		return repositories.getCustomerRepository().getAll();
	}
	
	public boolean createCustomer(Customer customer) {
		return repositories.getCustomerRepository().create(customer);
	}
	
	public boolean updateCustomer(Customer customer) {
		return repositories.getCustomerRepository().update(customer);
	}
	
	public boolean deleteCustomer(Customer customer) {
		return repositories.getCustomerRepository().delete(customer);
	}
	
	public Book getBookById(String id) {
		return repositories.getBookRepository().getByKey(id);
	}
	
	public Set<Book> getAllBooks(){
		return repositories.getBookRepository().getAll();
	}
	
	public boolean createBook(Book book) {
		return repositories.getBookRepository().create(book);
	}
	
	public boolean updateBook(Book book) {
		return repositories.getBookRepository().update(book);
	}
	
	public boolean delteBook(Book book) {
		return repositories.getBookRepository().delete(book);
	}
	
	public Password getPasswordById(String id) {
		return repositories.getPasswordRepository().getByKey(id);
	}
	
	public Set<Password> getAllPasswords(){
		return repositories.getPasswordRepository().getAll();
	}
	
	public boolean createPassword(Password password) {
		return repositories.getPasswordRepository().create(password);
	}
	
	public boolean updatePassword(Password password) {
		return repositories.getPasswordRepository().update(password);
	}
	
	public boolean deletePassword(Password password) {
		return repositories.getPasswordRepository().delete(password);
	}
}
