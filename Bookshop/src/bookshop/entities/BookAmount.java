package bookshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="buchbestand")
public class BookAmount {
	
	@Id
	@OneToOne
	@JoinColumn(name="isbn")
	private Book book;
	
	@Column(name="bestand")
	private int amount;

	public BookAmount() {
		
	}
	public BookAmount(Book book, int amount) {
		super();
		this.book = book;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void getBook(Book book) {
		this.book = book;
	}
	
	
}
