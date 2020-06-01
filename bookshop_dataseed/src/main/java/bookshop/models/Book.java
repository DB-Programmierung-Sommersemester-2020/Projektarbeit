package bookshop.models;

public class Book {
    private String isbn;
    private String title;
    private String publisher;
    private byte[] picture;
    private String picturePath;

    public Book(String isbn, String title, String publisher, byte[] picture, String picturePath) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.picture = picture;
        this.picturePath = picturePath;
    }

    public Book(String isbn, String title, String publisher, String picturePath) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.picturePath = picturePath;
    }

    public Book(String isbn, String title, String publisher, byte[] picture) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.picture = picture;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", publisher=" + publisher + ", title=" + title + "]";
    }
    
}