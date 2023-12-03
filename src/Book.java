import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Book {
    private String title;
    private String category;
    private String author;
    private String ISBN;
    private int pub_year;
    ArrayList<Book> books = new ArrayList<>();

    public Book() {

    }

    public Book(String title, String category, String author, String ISBN, int pub_year) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.ISBN = ISBN;
        this.pub_year = pub_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPub_year() {
        return pub_year;
    }

    public void setPub_year(int pub_year) {
        this.pub_year = pub_year;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {

        String formatting = "\nBook: %-38s Category: %-20s  Author: %-22s ISBN: %-20s Publication Year: %d";

        if (books.indexOf(this) == 0) {
            String formatting0 = "[Book: %-30s Category: %-10s  Author: %-21s ISBN: %-20s Publication Year: %d";
        }

        return String.format(formatting, title, category, author, ISBN, pub_year);
    }

    public ArrayList<Book> standard_books(){
        books.add(new Book("To Kill a Mockingbird", "Fiction" ,"Harper Lee",
                "978-0061120084", 1960));
        books.add(new Book("1984", "Fiction" ,"George Orwell",
                "978-0451524935", 1949));
        books.add(new Book("Don Quixote", "Satire", "Miguel de Cervantes",
                "978-0060934347", 1605));
        books.add(new Book("The Divine Comedy", "Epic Poetry","Dante Alighieri",
                "978-0142437223", 1320));
        books.add(new Book("The Adventures of Huckleberry Finn", "Adventure","Mark Twain",
                "978-0486280615", 1884));
        books.add(new Book("The Lord of the Rings", "Fantasy","J.R.R. Tolkien",
                "978-0618640157", 1954));
        books.add(new Book("Wuthering Heights","Gothic Fiction","Emily Bronte",
                "978-0141439556", 1847));
        books.add(new Book("Anna Karenina","Fiction","Leo Tolstoy",
                "978-0143035008", 1877));
        books.add(new Book("The Great Gatsby", "Fiction", "F. Scott Fitzgerald",
                "978-0743273565", 1925));
        books.add(new Book("Pride and Prejudice", "Classic", "Jane Austen",
                "978-0486280493", 1813));
        books.add(new Book("Moby-Dick", "Adventure", "Herman Melville",
                "978-1853260087", 1851));
        books.add(new Book("The Catcher in the Rye", "Fiction", "J.D. Salinger",
                "978-0316769174", 1951));
        books.add(new Book("One Hundred Years of Solitude", "Magical Realism", "Gabriel Garcia Marquez",
                "978-0141184999", 1967));
        books.add(new Book("War and Peace", "Historical Fiction", "Leo Tolstoy",
                "978-0679405631", 1869));
        books.add(new Book("Brave New World", "Dystopian", "Aldous Huxley",
                "978-0060850524", 1932));
        books.add(new Book("Crime and Punishment", "Psychological Fiction", "Fyodor Dostoevsky",
                "978-0451524935", 1866));
        books.add(new Book("The Picture of Dorian Gray", "Gothic Fiction", "Oscar Wilde",
                "978-0141442464", 1890));
        books.add(new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien",
                "978-0618002214", 1937));
        books.add(new Book("The Alchemist", "Adventure", "Paulo Coelho",
                "978-0061122415", 1988));
        books.add(new Book("Jane Eyre", "Gothic Fiction", "Charlotte Bronte",
                "978-0141441146", 1847));
        books.add(new Book("The Road", "Post-Apocalyptic", "Cormac McCarthy",
                "978-0307387899", 2006));
        books.add(new Book("Frankenstein", "Gothic Fiction", "Mary Shelley",
                "978-0141439471", 1818));
        books.add(new Book("The Grapes of Wrath", "Historical Fiction", "John Steinbeck",
                "978-0143039433", 1939));

        return books;
    }

    public Book insert_new_book(ArrayList<Book> all_books){
        System.out.println("Add a new book to the system");
        System.out.print("Insert book's title: ");
        Scanner sc = new Scanner(System.in);
        String book_title = sc.nextLine();

        System.out.print("Insert book's category: ");
        String book_category = sc.nextLine();

        System.out.print("Insert book's author: ");
        String book_author = sc.nextLine();

        System.out.print("Insert book's ISBN: ");
        String book_isbn = sc.nextLine();
        for (Book b: all_books){
            if (book_isbn.equals(b.getISBN())){
                System.out.println("The ISBN \'" + book_isbn + "\' already exists in the book " + b.getTitle());
                return null;
            }
        }

        System.out.print("Insert book's publication year: ");
        int book_pub_year = 0;

        try{
            book_pub_year = sc.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input. Try again and enter a valid year.");
            sc.nextLine();
            return null;
        }

        Book b = new Book(book_title,book_category,book_author,book_isbn,book_pub_year);
        books.add(b);
        System.out.println(books);

        return b;
    }

    public void delete_book(ArrayList<Book> all_books){
        Iterator<Book> iterator = all_books.iterator();
        boolean found = false;
        System.out.print("Insert book's title or ISBN: ");
        Scanner sc = new Scanner(System.in);
        String book = sc.nextLine();

        while (iterator.hasNext()) {
            Book current_book = iterator.next();
            if (current_book.getTitle().equalsIgnoreCase(book) || current_book.getISBN().equalsIgnoreCase(book)) {
                all_books.remove(current_book);
                System.out.println("The following book removed from the system successfully: ");
                System.out.println(current_book);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("No book with title or ISBN \"" + book + "\" was found.");

    }

    public Book select_book(ArrayList<Book> all_books){
        System.out.print("Insert book's name: ");
        Scanner sc = new Scanner(System.in);
        String book = sc.nextLine();

        for (Book b: all_books){
            if (b.getTitle().equalsIgnoreCase(book)){
                return b;
            }
        }
        System.out.println("Book " + book + " was not found.");
        return null;
    }

//    public ArrayList<Library> find_book(ArrayList<Book> books, ArrayList<Library> libraries){
//        System.out.print("Insert book's name: ");
//        Scanner sc = new Scanner(System.in);
//        String book = sc.nextLine();
//
//        ArrayList<Library> libraries_with_book = new ArrayList<>();
//        boolean bookExistsInLibrarySystem = false;
//
//        for (Book bb : books)
//            if (bb.getTitle().equalsIgnoreCase(book)) {
//                bookExistsInLibrarySystem = true;
//                for (Library l : libraries)
//                    if (l.hasBook(bb))
//                        libraries_with_book.add(l);
//            }
//
//        if (bookExistsInLibrarySystem) {
//            if (libraries_with_book.isEmpty())
//                System.out.println("\nThe book \"" + book + "\"  exists in the Library System but doesn't exist in any library.");
//            else
//                System.out.print("\nThe book \"" + book + "\" exists in the following libraries: \n");
//        }
//        else
//            System.out.println("\nThe book \"" + book + "\" doesn't exist in the Library System.");
//
//        return libraries_with_book;
//    }

    public void find_book(ArrayList<Book> books, ArrayList<Library> libraries) {
        System.out.print("Insert book's name: ");
        Scanner sc = new Scanner(System.in);
        String book = sc.nextLine();
        ArrayList<Library> libraries_with_book = new ArrayList<>();
        boolean bookExistsInLibrarySystem = false;

        for (Book bb : books)
            if (bb.getTitle().equalsIgnoreCase(book)) {
                bookExistsInLibrarySystem = true;
                for (Library l : libraries)
                    if (l.hasBook(bb))
                        libraries_with_book.add(l);
            }

        if (bookExistsInLibrarySystem) {
            if (libraries_with_book.isEmpty())
                System.out.println("\nThe book \"" + book + "\" exists in the Library System but doesn't exist in any library.");
            else {
                System.out.print("\nThe book \"" + book + "\" exists in the following libraries: ");
                for (Library library : libraries_with_book)
                    System.out.print(library);
            }
            System.out.println();
        }
        else
            System.out.println("\nThe book \"" + book + "\" doesn't exist in the Library System.");
    }

}
