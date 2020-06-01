package bookshop;

import bookshop.repository.BookshopRepository;

public class App 
{
    public static void main( String[] args )
    {
        BookshopRepository bookshopRepository = BookshopRepository.getInstance();
        
        if(bookshopRepository.createAddresses()){
            System.out.println("Adresse seeded");
        }
        if(bookshopRepository.createPublishers()){
            System.out.println("Verlag seeded");
        }

        if(bookshopRepository.createAuthors()){
            System.out.println("Autor seeded");
        }

        if(bookshopRepository.createBooks()){
            System.out.println("Buch seeded");
        }

        if(bookshopRepository.createBookAuthors()){
            System.out.println("Buchautoren seeded");
        }

        if(bookshopRepository.createBookAmount()){
            System.out.println("Buchbestand seeded");
        }

        if(bookshopRepository.createBookPrise()){
            System.out.println("Buchprise seeded");
        }
    }
}
