package bookshop.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kundenkauf")
public class CustomerPurchase {

	@Id
	@ManyToOne
	@Column(name = "kundenNr")
	private Customer customer;
	
	@Column(name="isbn")
	private Book book;
	
	@Column(name="menge")
	private int amount;
	
	@Column(name="datum")
	private Date date;
	
	public CustomerPurchase() {
		super();
	}

	public CustomerPurchase(Customer customer, Book isbn, int amount) {
		super();
		this.customer = customer;
		this.book = isbn;
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Book getIsbn() {
		return book;
	}

	//TODO: Parse to String
	public Date getDate() {
		return date;
	}

	public int getAmount() {
		return amount;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		CustomerPurchase other = (CustomerPurchase) obj;
		if (amount != other.amount)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerPurchase [customerId=" + customer + ", isbn=" + book + ", amount=" + amount + "]";
	}
	
	
	
	
}
