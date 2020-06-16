package bookshop.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelFacade {
    private static ModelFacade instance = null;
    private Set<Address> addresses = new HashSet<Address>();
    private Set<Author> authors = new HashSet<Author>();
    private Set<Book> books = new HashSet<Book>();
    private Set<Publisher> publishers = new HashSet<Publisher>();
    private Set<BookAmount> amounts = new HashSet<BookAmount>();
    private Set<BookPrise> prises = new HashSet<BookPrise>();
    private List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();

    private ModelFacade() {
        fillAddresses();
        fillAuthors();
        fillBooks();
        fillPublishers();
        fillBookAmount();
        fillBookPrises();
        fillBookAuthors();
    }

    private void fillAddresses() {
        Address hanserAddress = new Address(1,"Kolbergerstraße 22", "81679", "München");
        addresses.add(hanserAddress);

        Address dpunktAddress = new Address(2,"Wieblinger Weg 17", "69123", "Heidelberg");
        addresses.add(dpunktAddress);

        Address prenticeHallAddress = new Address(3,"Upper Saddle River", "07097", "New Jersey");
        addresses.add(prenticeHallAddress);

        Address addisonWeslyAddress = new Address(4,"St.-Martin-Str. 82", "81541", "München");
        addresses.add(addisonWeslyAddress);

        Address morganKaufmannAddress = new Address(5,"340 Pine Street", "6th Floor", "94104", "San Francisco");
        addresses.add(morganKaufmannAddress);
    }

    private void fillPublishers() {
        Publisher hanser = new Publisher("Hanser", 1);
        Publisher dpunkt = new Publisher("dpunkt.verlag", 2);
        Publisher prenticeHall = new Publisher("Prentice Hall", 3);
        Publisher addisonWesly = new Publisher("Addison Wesely", 4);
        Publisher morganKaufmann = new Publisher("Morgan Kaufmann", 5);

        publishers.add(hanser);
        publishers.add(dpunkt);
        publishers.add(prenticeHall);
        publishers.add(addisonWesly);
        publishers.add(morganKaufmann);
    }

    private void fillAuthors() {
        Author starke = new Author(1,"Gernot", "Starke");
        Author siedersleben = new Author(2,"Johannes", "Siedersleben");
        Author martin = new Author(3,"Robert", "Martin");
        Author lea = new Author(4,"Doug", "Lea");
        Author mcCool = new Author(5,"Michael", "McCool");
        Author robinson = new Author(6,"Arch", "Robinson");
        Author reinders = new Author(7,"James", "Reinders");
        Author jeffers = new Author(8,"Jim", "Jeffers");
        Author tanenbaum = new Author(9,"Andrew", "Tanenbaum");
        Author bos = new Author(10,"Herbert", "Bos");
        Author wetherall = new Author(11,"David", "Wetherall");
        Author tilkov = new Author(12,"Stefan", "Tilkov");

        authors.add(starke);
        authors.add(siedersleben);
        authors.add(martin);
        authors.add(lea);
        authors.add(mcCool);
        authors.add(robinson);
        authors.add(reinders);
        authors.add(jeffers);
        authors.add(tanenbaum);
        authors.add(bos);
        authors.add(wetherall);
        authors.add(tilkov);
    }

    private void fillBooks() {
        Book xeonPhi = new Book("9780124104143", "Intel Xeon Phi Coprocerssor High-Performance Programming",
                "Morgan Kaufmann", "WebContent/pic/9780124104143.jpg");
        Book sPP = new Book("9780124159938", "Structured Parallel Programming", "Morgan Kaufmann",
                "WebContent/pic/9780124159938.jpg");
        Book cN = new Book("9780130384881", "Computer Networks", "Prentice Hall", "WebContent/pic/9780130384881.jpg");
        Book cC = new Book("9780132350884", "Clean Code", "Prentice Hall", "WebContent/pic/9780132350884.jpg");
        Book mOS = new Book("9780135881873", "Modern Operating Systems", "Prentice Hall",
                "WebContent/pic/9780135881873.jpg");
        Book aSD = new Book("9780135974445", "Agile Software Development", "Prentice Hall",
                "WebContent/pic/9780135974445");
        Book cC2 = new Book("9780137081073", "The Clean Coder", "Prentice Hall", "WebContent/pic/9780137081073.jpg");
        Book cPJ = new Book("9780201310092", "Concurrent Programming in Java", "Addison Wesely",
                "WebContent/pic/9780201310092.jpg");
        Book spS = new Book("9783446218437", "Softwaretechnik: Praxiswissen für Softwareingenieure", "Hanser",
                "WebContent/pic/9783446218437.jpg");
        Book eSA = new Book("9783446427280", "Effektive Software-Architekturen", "Hanser",
                "WebContent/pic/9783446427280.jpg");
        Book mSA = new Book("9783898642927", "Moderne Software-Architekturen", "dpunkt.verlag",
                "WebContent/pic/9783898642927");
        Book soa = new Book("9783898644372",
                "SOA-Expertenwissen: Methoden, Konzepte und Praxis serviceorientierter Architekturen", "dpunkt.verlag",
                "WebContent/pic/9783898644372.jpg");
        Book http = new Book("9783898647328",
                "REST und HTTP: Einsatz der Architektur des Web für Integrationsszenarien", "dpunkt.verlag",
                "WebContent/pic/9783898647328.jpg");

        books.add(xeonPhi);
        books.add(sPP);
        books.add(cN);
        books.add(cC);
        books.add(mOS);
        books.add(aSD);
        books.add(cC2);
        books.add(cPJ);
        books.add(spS);
        books.add(eSA);
        books.add(mSA);
        books.add(soa);
        books.add(http);
    }

    private void fillBookAuthors() {
        BookAuthor xeonPhiAuthor = new BookAuthor("9780124104143", 12);
        BookAuthor sPP = new BookAuthor("9780124159938", 5);
        BookAuthor sPP1 = new BookAuthor("9780124159938", 6);
        BookAuthor sPP2 = new BookAuthor("9780124159938", 7);
        BookAuthor cN = new BookAuthor("9780130384881", 11);
        BookAuthor cC = new BookAuthor("9780132350884", 3);
        BookAuthor mOS = new BookAuthor("9780135881873", 9);
        BookAuthor mOS1 = new BookAuthor("9780135881873", 10);
        BookAuthor aSD = new BookAuthor("9780135974445", 3);
        BookAuthor cC2 = new BookAuthor("9780137081073", 3);
        BookAuthor cPJ = new BookAuthor("9780201310092", 4);
        BookAuthor spS = new BookAuthor("9783446218437", 2);
        BookAuthor eSA = new BookAuthor("9783446427280", 1);
        BookAuthor mSA = new BookAuthor("9783898642927", 2);
        BookAuthor soa = new BookAuthor("9783898644372", 1);
        BookAuthor soa1 = new BookAuthor("9783898644372", 11);
        BookAuthor http = new BookAuthor("9783898647328", 11);

        bookAuthors.add(xeonPhiAuthor);
        bookAuthors.add(sPP);
        bookAuthors.add(sPP1);
        bookAuthors.add(sPP2);
        bookAuthors.add(cN);
        bookAuthors.add(cC);
        bookAuthors.add(mOS);
        bookAuthors.add(mOS1);
        bookAuthors.add(aSD);
        bookAuthors.add(cC2);
        bookAuthors.add(cPJ);
        bookAuthors.add(spS);
        bookAuthors.add(eSA);
        bookAuthors.add(mSA);
        bookAuthors.add(soa);
        bookAuthors.add(soa1);
        bookAuthors.add(http);
    }

    private void fillBookAmount() {
        BookAmount xeonPhiAuthor = new BookAmount("9780124104143", 120);
        BookAmount sPP = new BookAmount("9780124159938", 50);
        BookAmount cN = new BookAmount("9780130384881", 110);
        BookAmount cC = new BookAmount("9780132350884", 30);
        BookAmount mOS = new BookAmount("9780135881873", 90);
        BookAmount aSD = new BookAmount("9780135974445", 30);
        BookAmount cC2 = new BookAmount("9780137081073", 30);
        BookAmount cPJ = new BookAmount("9780201310092", 40);
        BookAmount spS = new BookAmount("9783446218437", 20);
        BookAmount eSA = new BookAmount("9783446427280", 10);
        BookAmount mSA = new BookAmount("9783898642927", 20);
        BookAmount soa = new BookAmount("9783898644372", 10);
        BookAmount http = new BookAmount("9783898647328", 110);

        amounts.add(xeonPhiAuthor);
        amounts.add(sPP);
        amounts.add(cN);
        amounts.add(cC);
        amounts.add(cC2);
        amounts.add(mOS);
        amounts.add(aSD);
        amounts.add(cPJ);
        amounts.add(spS);
        amounts.add(eSA);
        amounts.add(mSA);
        amounts.add(soa);
        amounts.add(http);

    }

    private void fillBookPrises() {
        BookPrise xeonPhiAuthor = new BookPrise("9780124104143", 42.95);
        BookPrise sPP = new BookPrise("9780124159938", 42.95);
        BookPrise cN = new BookPrise("9780130384881", 96.20);
        BookPrise cC = new BookPrise("9780132350884", 33.95);
        BookPrise mOS = new BookPrise("9780135881873", 76.22);
        BookPrise aSD = new BookPrise("9780135974445", 67.97);
        BookPrise cC2 = new BookPrise("9780137081073", 39.97);
        BookPrise cPJ = new BookPrise("9780201310092", 47.95);
        BookPrise spS = new BookPrise("9783446218437", 25.95);
        BookPrise eSA = new BookPrise("9783446427280", 39.95);
        BookPrise mSA = new BookPrise("9783898642927", 39.00);
        BookPrise soa = new BookPrise("9783898644372", 59.00);
        BookPrise http = new BookPrise("9783898647328", 23.95);

        prises.add(xeonPhiAuthor);
        prises.add(sPP);
        prises.add(cN);
        prises.add(cC);
        prises.add(cC2);
        prises.add(mOS);
        prises.add(aSD);
        prises.add(cPJ);
        prises.add(spS);
        prises.add(eSA);
        prises.add(mSA);
        prises.add(soa);
        prises.add(http);
    }

    public static ModelFacade getInstance() {
        return (instance == null) ? new ModelFacade() : instance;
    }

    public Set<Address> getAllAddresses() {
        return this.addresses;
    }

    public Set<Author> getAllAuthors() {
        return this.authors;
    }

    public Set<Book> getAllBooks() {
        return this.books;
    }

    public Set<Publisher> getAllPublishers() {
        return this.publishers;
    }

    public Set<BookAmount> getAllBookAmounts() {
        return this.amounts;
    }

    public Set<BookPrise> getAllBookPrises() {
        return this.prises;
    }

    public List<BookAuthor> getAllBookAuthors() {
        return this.bookAuthors;
    }
}
