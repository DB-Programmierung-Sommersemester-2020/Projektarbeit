package bookshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="kunde")
public class Customer {

	@Id
	@Column(name="kundenNr")
	private String customerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="customerId", cascade=CascadeType.ALL)
	private Password password;

	@OneToMany(mappedBy = "customer")
	private Set<CustomerPurchase> purchases = new HashSet<CustomerPurchase>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "kundenadresse", 
	joinColumns = @JoinColumn(name = "kundenNr"), 
	inverseJoinColumns = @JoinColumn(name="adressId"))
	private Set<Address> adresses = new HashSet<Address>();
	
	public Customer() {
		
	}
	public Customer(String id, String name, String email) {
		super();
		this.customerId = id;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<CustomerPurchase> getPurchases() {
		return purchases;
	}
	
	public void setPurchases(Set<CustomerPurchase> purchases) {
		this.purchases = purchases;
	}
	
	public Set<Address> getAdresses() {
		return adresses;
	}
	
	public void setAdresses(Set<Address> adresses) {
		this.adresses = adresses;
	}
	
	public Password getPassword() {
		return password;
	}
	
	public void setPassword(Password password) {
		this.password = password;
	}
	
	public String getEmail() {	
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getId() {
		return customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", name=" + name + "]";
	}
	
	
	
}
