package bookshop;

import bookshop.repository.BookshopRepository;

public class App 
{
    public static void main( String[] args )
    {
        BookshopRepository bookshopRepository = BookshopRepository.getInstance();
        bookshopRepository.createAuthors();
        System.out.println("Authors created");
    }
}
