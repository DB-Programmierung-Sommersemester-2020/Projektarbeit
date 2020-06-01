package bookshop.models;

public class Address {
    private int id;
    private String street;
    private String suffix;
    private String zipCode;
    private String city;

    public Address() {
    }

    public Address(String street, String suffix, String zipCode, String city) {
        this.street = street;
        this.suffix = suffix;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address(int id, String street, String zipCode, String city) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
    
    public Address(int id, String street,String suffix, String zipCode, String city) {
        this.id = id;
        this.street = street;
        this.suffix = suffix;
        this.zipCode = zipCode;
        this.city = city;
	}

	public int getId() {
        return id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + id;
        result = prime * result + ((street == null) ? 0 : street.hashCode());
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
        if (zipCode == null) {
            if (other.zipCode != null)
                return false;
        } else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", id=" + id + ", street=" + street + ", suffix=" + suffix + ", zipCode="
                + zipCode + "]";
    }

}