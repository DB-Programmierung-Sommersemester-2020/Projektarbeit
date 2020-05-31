package bookshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kundenkauf")
public class BookSale {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="kundenNr")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;
	
	@Id
	@Column(name="datum")
	private String salesTimeStamp;
	
	@Column(name="menge")
	private int amount;
	
	public BookSale() {
		super();
	}

	public BookSale(Customer customer, Book book, String salesTimeStamp) {
		super();
		this.customer = customer;
		this.book = book;
		this.salesTimeStamp = salesTimeStamp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Book getBook() {
		return book;
	}

	public String getSalesTimeStamp() {
		return salesTimeStamp;
	}

	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((salesTimeStamp == null) ? 0 : salesTimeStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookSale other = (BookSale) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (salesTimeStamp == null) {
			if (other.salesTimeStamp != null)
				return false;
		} else if (!salesTimeStamp.equals(other.salesTimeStamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookSale [customer=" + customer + ", book=" + book + ", salesTimeStamp=" + salesTimeStamp + "]";
	}
	
	

}
