package bookshop.repositories.services;

import bookshop.entities.Address;
import bookshop.entities.Author;
import bookshop.entities.Book;
import bookshop.entities.Customer;
import bookshop.entities.Publisher;
import bookshop.repositories.implementations.CRUDRepository;

public interface RepositoriesContainerService {
	public CRUDRepository<Author, Integer> getAuthorRepository();

	public CRUDRepository<Book, String> getBookRepository();

	public CRUDRepository<Address, Integer> getAddressRepository();

	public CRUDRepository<Publisher, String> getPublisherRepository();

	public CRUDRepository<Customer, String> getCustomerRepository();

}
