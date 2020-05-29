package bookshop.entities;


import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kundenpassword")
public class Password {
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="kundenNr")
	private Customer customerId;
	
	@Lob
	@Column(name="pwdhash")
	private byte[] pwdHash;
	
	@Lob
	@Column(name="salt")
	private byte[] salt;
	
	public Password() {
		super();
	}
	
	public Password(Customer id, byte[] pwdHash, byte[] salt) {
		super();
		this.customerId = id;
		this.pwdHash = pwdHash;
		this.salt = salt;
	}
	
	public Password(byte[] pwdHash, byte[] salt) {
		super();
		this.pwdHash = pwdHash;
		this.salt = salt;
	}

	public Customer getId() {
		return customerId;
	}
	public byte[] getPwdHash() {
		return pwdHash;
	}

	public byte[] getSalt() {
		return salt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + Arrays.hashCode(pwdHash);
		result = prime * result + Arrays.hashCode(salt);
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
		Password other = (Password) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (!Arrays.equals(pwdHash, other.pwdHash))
			return false;
		if (!Arrays.equals(salt, other.salt))
			return false;
		return true;
	}

	
}

