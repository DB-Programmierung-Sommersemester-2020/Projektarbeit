package bookshop.repositories.implementations;

import bookshop.entities.Address;
import bookshop.entities.Author;
import bookshop.entities.Book;
import bookshop.entities.Customer;
import bookshop.entities.Publisher;
import bookshop.repositories.implementations.CRUDRepository;
import bookshop.repositories.services.RepositoriesContainerService;

public class RepositoriesContainer implements RepositoriesContainerService{
	private CRUDRepository<Author, Integer> authorRepository;
	private CRUDRepository<Book, String> bookRepository;
	private CRUDRepository<Address, Integer> addressRepository;
	private CRUDRepository<Publisher, String> publisherRepository;
	private CRUDRepository<Customer, String> customerRepository;
	
	public RepositoriesContainer(
			CRUDRepository<Author, Integer> authorRepository,
			CRUDRepository<Book, String> bookRepository, 
			CRUDRepository<Address, Integer> addressRepository,
			CRUDRepository<Publisher, String> publisherRepository,
			CRUDRepository<Customer, String> customerRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.addressRepository = addressRepository;
		this.publisherRepository = publisherRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public CRUDRepository<Author, Integer> getAuthorRepository() {
		return authorRepository;
	}

	@Override
	public CRUDRepository<Book, String> getBookRepository() {
		return bookRepository;
	}

	@Override
	public CRUDRepository<Address, Integer> getAddressRepository() {
		return addressRepository;
	}

	@Override
	public CRUDRepository<Publisher, String> getPublisherRepository() {
		return publisherRepository;
	}

	@Override
	public CRUDRepository<Customer, String> getCustomerRepository() {
		return customerRepository;
	}
	
	
	
}
