package bookshop.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "buch")
public class Book {

	@Id
	@Column(name = "isbn")
	private String isbn;

	@Column(name = "titel")
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="verlag")
	private Publisher publisher;

	@Column(name = "bild")
	private byte[] picture;

	@Column(name = "bild_pfad")
	private String pic_path;

	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private BookAmount BookAmount;
	
	@OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
	private BookPrise BookPrise;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "buchautor", 
	joinColumns = @JoinColumn(name = "isbn"), 
	inverseJoinColumns = @JoinColumn(name="autorId"))
	private Set<Author> authors = new HashSet<Author>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "kundenkauf", 
	joinColumns = @JoinColumn(name = "isbn"), 
	inverseJoinColumns = @JoinColumn(name="kundenNr"))
	private Set<Customer> customers = new HashSet<Customer>();
	
	@OneToMany(mappedBy = "book", cascade=CascadeType.ALL)
	private Collection<BookSale> bookSales = new ArrayList<BookSale>();

	public Book() {
		super();
	}

	public Book(String title, Publisher verlag, String pic_path) {
		super();
		this.title = title;
		this.publisher = verlag;
		this.pic_path = pic_path;
	}

	public Book(String title, Publisher verlag, byte[] picture) {
		super();
		this.title = title;
		this.publisher = verlag;
		this.picture = picture;
	}

	public Book(String id, String title, Publisher verlag, String pic_path) {
		this(title, verlag, pic_path);
		this.isbn = id;
	}

	public Book(String id, String title, Publisher verlag, byte[] picture) {
		this(title, verlag, picture);
		this.isbn = id;
	}

	public Book(String title, Publisher verlag, byte[] picture, Set<Author> authors) {
		this(title, verlag, picture);
		this.authors = authors;
	}

	public Book(String title, Publisher verlag, String pic_path, Set<Author> authors) {
		this(title, verlag, pic_path);
		this.authors = authors;
	}

	public Book(String id, String title, Publisher verlag, byte[] picture, Set<Author> authors) {
		this(id, title, verlag, picture);
		this.authors = authors;
	}

	public Book(String id, String title, Publisher verlag, String pic_path, Set<Author> authors) {
		this(id, title, verlag, pic_path);
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVerlag(Publisher verlag) {
		this.publisher = verlag;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getPic_path() {
		return pic_path;
	}

	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}

	public Set<Author> getAutors() {
		return authors;
	}

	public void setAutors(Set<Author> autors) {
		this.authors = autors;
	}

	public String getId() {
		return isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public BookAmount getBookAmount() {
		return BookAmount;
	}

	public void setBookAmount(BookAmount bookAmount) {
		BookAmount = bookAmount;
	}

	public BookPrise getBookPrise() {
		return BookPrise;
	}

	public void setBookPrise(BookPrise bookPrise) {
		BookPrise = bookPrise;
	}

	
	public Collection<BookSale> getBookSales() {
		return bookSales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + isbn + ", title=" + title + ", verlag=" + publisher + ", picture=" + Arrays.toString(picture)
				+ ", pic_path=" + pic_path + "]";
	}

}
