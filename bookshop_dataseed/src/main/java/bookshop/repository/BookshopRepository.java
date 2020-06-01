package bookshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bookshop.models.Address;
import bookshop.models.Author;
import bookshop.models.Book;
import bookshop.models.BookAmount;
import bookshop.models.BookAuthor;
import bookshop.models.BookPrise;
import bookshop.models.ModelFacade;
import bookshop.models.Publisher;

public class BookshopRepository {

    private static BookshopRepository instance = null;
    private ModelFacade facade = ModelFacade.getInstance();

    private BookshopRepository() {

    }

    public static BookshopRepository getInstance() {
        return (instance == null) ? new BookshopRepository() : instance;
    }
    public boolean createAddresses() {
        boolean created = false;
        Set<Address> addresses = new HashSet<Address>();
        addresses = facade.getAllAddresses();
        
        String create = "INSERT INTO adresse(id, strasse, zusatz, plz, stadt) VALUES(?,?,?,?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(Address address : addresses){
                statement.setInt(1, address.getId());
                statement.setString(2, address.getStreet());
                statement.setString(3, address.getSuffix());
                statement.setString(4, address.getZipCode());
                statement.setString(5, address.getCity());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;

    }

    public boolean createAuthors() {
        boolean created = false;
        Set<Author> authors = new HashSet<Author>();
        authors = facade.getAllAuthors();
        
        String create = "INSERT INTO autor(id, vorname, nachname) VALUES(?,?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(Author author : authors){
                statement.setInt(1, author.getId());
                statement.setString(2, author.getFirstName());
                statement.setString(3, author.getLastName());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;

    }

    public boolean createBooks() {
        boolean created = false;
        Set<Book> books = new HashSet<Book>();
        books = facade.getAllBooks();
        
        String create = "INSERT INTO buch(isbn, titel, verlag, bild, bild_pfad) VALUES(?,?,?,?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(Book book : books){
                statement.setString(1, book.getIsbn());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getPublisher());
                statement.setBytes(4, book.getPicture());
                statement.setString(5, book.getPicturePath());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;

    }

    public boolean createBookAuthors() {
        boolean created = false;
        List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
        bookAuthors = facade.getAllBookAuthors();
        
        String create = "INSERT INTO buchautor(isbn, autorId) VALUES(?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(BookAuthor bookAuthor : bookAuthors){
                statement.setString(1, bookAuthor.getIsbn());
                statement.setInt(2, bookAuthor.getAuthorId());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    public boolean createPublishers() {
        boolean created = false;
        Set<Publisher> publishers = new HashSet<Publisher>();
        publishers = facade.getAllPublishers();
        
        String create = "INSERT INTO verlag(name, adressId) VALUES(?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(Publisher publisher : publishers){
                statement.setString(1, publisher.getName());
                statement.setInt(2, publisher.getAdressId());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    public boolean createBookAmount() {
        boolean created = false;
        Set<BookAmount> amounts = new HashSet<BookAmount>();
        amounts = facade.getAllBookAmounts();
        
        String create = "INSERT INTO buchbestand(isbn, bestand) VALUES(?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(BookAmount amount : amounts){
                statement.setString(1, amount.getIsbn());
                statement.setInt(2, amount.getAmount());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    public boolean createBookPrise() {
        boolean created = false;
        Set<BookPrise> prises = new HashSet<BookPrise>();
        prises = facade.getAllBookPrises();
        
        String create = "INSERT INTO buchpreis(isbn, preis) VALUES(?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(BookPrise prise : prises){
                statement.setString(1, prise.getIsbn());
                statement.setDouble(2, prise.getPrise());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            
            connection.commit();

            statement.close();
            connection.close();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }
}