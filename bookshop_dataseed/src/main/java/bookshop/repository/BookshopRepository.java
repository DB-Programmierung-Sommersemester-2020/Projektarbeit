package bookshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import bookshop.models.Author;
import bookshop.models.ModelFacade;

public class BookshopRepository {

    private static BookshopRepository instance = null;
    private ModelFacade facade = ModelFacade.getInstance();

    private BookshopRepository() {

    }

    public static BookshopRepository getInstance() {
        return (instance == null) ? new BookshopRepository() : instance;
    }

    public boolean createAuthors() {
        boolean created = false;
        Set<Author> authors = new HashSet<Author>();
        authors = facade.getAllAuthors();
        
        String create = "INSERT INTO autor(vorname, nachname) VALUES(?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement statement = connection.prepareStatement(create);

            for(Author author : authors){
                statement.setString(1, author.getFirstName());
                statement.setString(2, author.getLastName());
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            created = (count.length>0) ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;

    }
}