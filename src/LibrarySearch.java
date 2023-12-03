import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LibrarySearch {

    public void search(ArrayList<Book> books, ArrayList<Library> libraries){
        HashSet<Book> matchingBooks = new HashSet<>();
        HashSet<Library> matchingLibraries = new HashSet<>();

        System.out.print("Search: ");
        Scanner sc = new Scanner(System.in);
        String search = sc.nextLine();

        System.out.println("\nBooks: ");
        for (Book b : books){
            String title = b.getTitle();
            String category = b.getCategory();
            String author = b.getAuthor();
            String ISBN = b.getISBN();
            int pub_year = b.getPub_year();

            if (title.contains(search))
                matchingBooks.add(b);
            if (category.contains(search))
                matchingBooks.add(b);
            if (author.contains(search))
                matchingBooks.add(b);
            if (ISBN.contains(search))
                matchingBooks.add(b);
            if (String.valueOf(pub_year).contains(search))
                matchingBooks.add(b);
        }

        if (matchingBooks.isEmpty())
            System.out.println("There is no book.");
        else
            System.out.println(matchingBooks);

        System.out.println("\nLibraries: ");
        for (Library l : libraries) {
            String name = l.getName();
            String city = l.getCity();

            if (name.contains(search))
                matchingLibraries.add(l);
            if (city.contains(search))
                matchingLibraries.add(l);
        }

        if (matchingLibraries.isEmpty())
            System.out.println("There is no library.");
        else
            System.out.println(matchingLibraries);
    }

    public void categorized_search(ArrayList<Book> books, ArrayList<Library> libraries){
        HashSet<Book> matchingBooks = new HashSet<>();
        HashSet<String> matchingCategories = new HashSet<>();
        HashSet<String> matchingAuthors = new HashSet<>();
        HashSet<String> matchingISBNs = new HashSet<>();
        HashSet<Library> matchingLibraries = new HashSet<>();
        int matching_parts = 0;

        System.out.print("Search: ");
        Scanner sc = new Scanner(System.in);
        String search = sc.nextLine();

        //Books
        for (Book b : books){
            String title = b.getTitle();
            int pub_year = b.getPub_year();
            if (title.contains(search) || String.valueOf(pub_year).contains(search)) {
                matchingBooks.add(b);
                matching_parts++;
            }
        }
        if(!matchingBooks.isEmpty()){
            System.out.println("\nBooks ");
            for (Book b: matchingBooks)
                System.out.println(b.getTitle() + " (Publication Year: " + b.getPub_year() + ")");
        }

        //Categories
        for (Book b : books){
            String category = b.getCategory();
            if (category.contains(search)) {
                matchingCategories.add(category);
                matching_parts++;
            }
        }
        if (!matchingCategories.isEmpty()) {
            System.out.println("\nCategories ");
            for (String category : matchingCategories)
                System.out.println(category);
        }

        //Authors
        for (Book b : books){
            String author = b.getAuthor();
            if (author.contains(search)) {
                matchingAuthors.add(author);
                matching_parts++;
            }
        }
        if (!matchingAuthors.isEmpty()){
            System.out.println("\nAuthors ");
            for (String author : matchingAuthors)
                System.out.println(author);
        }

        //ISBNs
        for (Book b : books){
            String isbn = b.getISBN();
            if (isbn.contains(search)) {
                matchingISBNs.add(isbn + " (" + b.getTitle() + ")");
                matching_parts++;
            }
        }
        if (!matchingISBNs.isEmpty()){
            System.out.println("\nISBNs ");
            for (String isbn : matchingISBNs)
                System.out.println(isbn);
        }

        //Libraries
        for (Library l : libraries){
            String library = l.getName();
            if (library.contains(search)) {
                matchingLibraries.add(l);
                matching_parts++;
            }
        }
        if (!matchingLibraries.isEmpty()){
            System.out.println("\nLibraries ");
            for (Library l: matchingLibraries)
                System.out.println(l.getName() + " (" + l.getCity() + ")");
        }

        if (matching_parts == 0)
            System.out.println("No results");
    }
}
