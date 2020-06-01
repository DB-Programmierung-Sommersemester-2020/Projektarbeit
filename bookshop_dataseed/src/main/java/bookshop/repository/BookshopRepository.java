package bookshop.repository;

import java.sql.Connection;

public class BookshopRepository {
    private Connection connection = DatabaseConnection.getInstance().getConnection();
    private static BookshopRepository instance = null;

    private BookshopRepository() {

    }

    public static BookshopRepository getInstance() {
        return (instance==null) ? new BookshopRepository() : instance;
    }
}