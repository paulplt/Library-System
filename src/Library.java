import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {

    private String name;
    private String city;
    ArrayList<Library> libraries = new ArrayList<>();
    private ArrayList<Book> books_in_a_library = new ArrayList<>();

    public Library(){}

    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {

        String formatting = "\nLibrary: %-80s City: %s";

        if (libraries.indexOf(this) == 0) {
            String formatting0 = "[Library: %-80s City: %s";
        }

        return String.format(formatting, name, city);
    }

    public ArrayList<Library> standard_libraries(){
        libraries.add(new Library("National Library of Greece", "Athens"));
        libraries.add(new Library("University of Crete Library", "Heraklion, Crete"));
        libraries.add(new Library("Aristotle University of Thessaloniki Library", "Thessaloniki"));
        libraries.add(new Library("The American College of Greece - John S. Bailey Library", "Athens"));
        libraries.add(new Library("Central Public Library of Serres", "Serres"));
        libraries.add(new Library("Central Library of the National and Kapodistrian University of Athens",
                "Athens"));
        libraries.add(new Library("University of Patras Library", "Patras"));
        libraries.add(new Library("Central Library of the National Technical University of Athens",
                "Athens"));
        libraries.add(new Library("Library and Information Center of the University of Ioannina",
                "Ioannina"));
        libraries.add(new Library("National Archaeological Museum Library", "Athens"));

        return libraries;
    }

    public Library insert_new_library(ArrayList<Library> all_libraries){
        System.out.println("\nAdd a new library to the system ");
        System.out.print("Insert library's name: ");
        Scanner sc = new Scanner(System.in);
        String library_name = sc.nextLine();
        for (Library l: all_libraries){
            if (library_name.equals(l.getName())){
                System.out.println("The library \'" + library_name + "\' already exists.");
                return null;
            }
        }

        System.out.print("Insert library's city: ");
        String library_city = sc.nextLine();

        Library l = new Library(library_name, library_city);
        libraries.add(l);
        System.out.println("\nThe library \"" + library_name + "\" added successfully.");
        System.out.println("\nList of libraries");
        System.out.println(libraries);
        return l;
    }

    public void delete_library(ArrayList<Library> all_libraries){
        System.out.println("\nDelete a library from the system");
        Iterator<Library> iterator = all_libraries.iterator();
        boolean found = false;
        System.out.print("Insert library's name: ");
        Scanner sc = new Scanner(System.in);
        String library = sc.nextLine();

        while (iterator.hasNext()) {
            Library current_library = iterator.next();
            if (current_library.getName().equalsIgnoreCase(library)) {
                all_libraries.remove(current_library);
                System.out.println("The following library removed from the system successfully: ");
                System.out.println(current_library);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("The library \"" + library + "\" was not found in the system");

    }

    public boolean hasBook(Book book) {
        for (Book b : books_in_a_library) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle())) {
                //System.out.println(b.getTitle() + " exists in the library " + name);
                return true;
            }
        }
        //System.out.println(book.getTitle() + " doesn't exist in the library " + name);
        return false;
    }

    public Library select_library(ArrayList<Library> all_libraries){
        System.out.print("Insert library's name: ");
        Scanner sc = new Scanner(System.in);
        String libr = sc.nextLine();

        for (Library library: all_libraries)
            if (library.getName().equalsIgnoreCase(libr))
                return library;

        System.out.println("Library with the name \"" + libr + "\" doesn't exist in the Library System.");
        // No matching library found
        Library notFound = new Library("Library Not Found", "");
        return notFound;
    }

    public void add_book(Book b){
        books_in_a_library.add(b);
    }

    public void add_book_in_library(ArrayList<Book> all_books, ArrayList<Library> all_libraries, String library_name) {
        System.out.print("Insert book's title: ");
        Scanner sc = new Scanner(System.in);
        String book = sc.nextLine();

        String library = library_name;
        boolean bookFound = false;
        boolean libraryFound = false;

        for (Book b : all_books)
            if (b.getTitle().equalsIgnoreCase(book)) {
                bookFound = true;
                for (Library l : all_libraries) {
                    if (library_name.equals(l.getName()))
                        if (l.hasBook(b)) {
                            System.out.println("The book \"" + b.getTitle() + "\" already exists in the library \"" + l.getName() + "\"");
                            break;
                        }

                    if (l.getName().equalsIgnoreCase(library)) {
                        l.add_book(b);
                        System.out.println("The book \"" + b.getTitle() + "\" added in the library \"" + l.getName() + "\"");
                        libraryFound = true;
                        break;
                    }
                }
            }

        if (!bookFound)
            System.out.println("Book with the name \"" + book + "\" doesn't exist in the Library System.");

        if (!libraryFound)
            if (library_name.equals("Library Not Found"))
                System.out.println("Library not found.");
    }

    public void remove_book(Book b){
        Iterator<Book> iterator = books_in_a_library.iterator();
        boolean found = false;
        while (!found){
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getTitle().equals(b.getTitle())) {
                    iterator.remove();
                    //System.out.println(b.getTitle() + " has been removed successfully.");
                    found = true;
                }
            }
        }
    }

    public void remove_book_from_library(ArrayList<Book> all_books, ArrayList<Library> all_libraries, String library_name){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert book's title: ");
        String book = sc.nextLine();

        String library = library_name;
        boolean bookFound = false;
        boolean bookExists = false;
        boolean libraryFound = false;

        for (Library l : all_libraries)
            if (l.getName().equalsIgnoreCase(library)){
                libraryFound = true;
                for (Book b : all_books)
                    if (b.getTitle().equalsIgnoreCase(book)){
                        bookExists = true;
                        if (l.hasBook(b)) {
                            l.remove_book(b);
                            System.out.println("The book \"" + b.getTitle() + "\" removed from library \"" + l.getName() + "\".");
                            bookFound = true;
                            break;
                        }
                        else
                            System.out.println("The book \"" + b.getTitle() + "\" doesn't exist in the library \"" + l.getName() + "\".");
                    }

                if (bookFound)
                    break;
            }

        if (!bookFound && !bookExists)
            System.out.println("Book with the name \"" + book + "\" doesn't exist in the Library System.");

        if (!libraryFound)
            if (library_name.equals("Library Not Found"))
                System.out.println("Library not found.");
    }

    public void print_books() {
        Iterator<Book> iterator = books_in_a_library.iterator();

        if (books_in_a_library.isEmpty()) {
            System.out.println("There is no book.");
            return;
        }

        if (!getName().equalsIgnoreCase("Library Not Found"))
            System.out.println("\nLibrary \"" + getName() + "\" in " + getCity());
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.print(book.getTitle() + " (" + book.getCategory() + ", " + book.getAuthor());
            System.out.println(", " + book.getISBN() + ", " + book.getPub_year() + ")");
        }
    }
}
