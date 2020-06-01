package bookshop.models;

public class BookPrise {
    private String isbn;
    private double prise;

    public BookPrise(String isbn, double prise) {
        this.isbn = isbn;
        this.prise = prise;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        long temp;
        temp = Double.doubleToLongBits(prise);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (Double.doubleToLongBits(prise) != Double.doubleToLongBits(other.prise))
            return false;
        return true;
    }
    
}