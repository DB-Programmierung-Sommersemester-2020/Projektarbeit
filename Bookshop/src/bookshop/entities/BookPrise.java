package bookshop.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="buchpreis")
public class BookPrise {
	
	@Id
	@OneToOne
	@JoinColumn(name="isbn")
	private Book book;
	
	@Column(name="preis")
	private Double prise;
	
	public BookPrise() {
		
	}
	public BookPrise(Book book, Double prise) {
		super();
		this.book = book;
		this.prise = prise;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Double getPrise() {
		return prise;
	}
	public void setPrise(Double prise) {
		this.prise = prise;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((prise == null) ? 0 : prise.hashCode());
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
		BookPrise other = (BookPrise) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (prise == null) {
			if (other.prise != null)
				return false;
		} else if (!prise.equals(other.prise))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookPrise [book=" + book + ", prise=" + prise + "]";
	}
	
	
}
