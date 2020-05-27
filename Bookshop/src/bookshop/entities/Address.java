package bookshop.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="adresse")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="strasse")
	private String street;
	
	@Column(name="zusatz")
	private String suffix;
	
	@Column(name="plz")
	private String zipCode;
	
	@Column(name="stadt")
	private String city;
	
	@OneToOne(mappedBy = "address")
	Publisher publisher;
	
	public Address() {
		super();
	}

	public Address(String street, String suffix, String zipCode, String city) {
		super();
		this.street = street;
		this.suffix = suffix;
		this.zipCode = zipCode;
		this.city = city;
	}

	public Address(int id, String street, String suffix, String zipCode, String city) {
		this(street, suffix, zipCode, city);
		this.id = id;
	}
	
	public Address(String street, String suffix, String zipCode, String city, Publisher publisher) {
		this(street, suffix, zipCode,city);
		this.publisher = publisher;
	}

	public Address(int id, String street, String suffix, String zipCode, String city, Publisher publisher) {
		this(id, street, suffix, zipCode,city);
		this.publisher = publisher;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", suffix=" + suffix + ", zipCode=" + zipCode + ", city="
				+ city + "]";
	}
	
	

}
