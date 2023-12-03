import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Book a = new Book();
            Library b = new Library();
            ArrayList<Book> all_books = new ArrayList<>();
            all_books = a.standard_books();
            ArrayList<Library> all_libraries = new ArrayList<>();
            all_libraries = b.standard_libraries();
            System.out.println("\nWelcome to the Library System!");
            //test

            boolean exit = false;
            while (!exit) {
                int choice;
                Menu.menu();

                while (!sc.hasNextInt()) {
                    System.out.print("Invalid input. Please enter a number in the range 1-5: ");
                    sc.nextLine(); // Consume the invalid input
                }

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        Menu.search_menu();
                        Scanner sc2 = new Scanner(System.in);
                        int search_choice;

                        boolean validInput = false;

                        while (!validInput) {
                            try {
                                search_choice = sc2.nextInt();
                                LibrarySearch ls = new LibrarySearch();

                                if (search_choice == 1) {
                                    ls.search(all_books, all_libraries);
                                    validInput = true;
                                }
                                else if (search_choice == 2) {
                                    ls.categorized_search(all_books, all_libraries);
                                    validInput = true;
                                }
                                else if (search_choice == 3)
                                    validInput = true;
                                else
                                    System.out.print("The number must be in the range 1-3: ");
                            }
                            catch (InputMismatchException e) {
                                sc2.nextLine(); // Clear the invalid input
                                System.out.print("Invalid input. Please enter a valid numeric choice in the range 1-3: ");
                            }
                        }
                        break;
                    case 2:
                        Menu.library_menu();
                        Scanner sc3 = new Scanner(System.in);
                        int library_choice;
                        boolean validInput2 = false;

                        while (!validInput2) {
                            try {
                                library_choice = sc3.nextInt();
                                if (library_choice == 1) {
                                    System.out.println("\nList of libraries");
                                    System.out.println(all_libraries);
                                    validInput2 = true;
                                }
                                else if (library_choice == 2) {
                                    b.insert_new_library(all_libraries);
                                    validInput2 = true;
                                }
                                else if (library_choice == 3) {
                                    b.delete_library(all_libraries);
                                    validInput2 = true;
                                }
                                else if (library_choice == 4){
                                    Library l = b.select_library(all_libraries);
                                    l.print_books();
                                    validInput2 = true;
                                }
                                else if (library_choice == 5)
                                    validInput2 = true;
                                else
                                    System.out.print("The number must be in the range 1-5: ");
                            }
                            catch (InputMismatchException e) {
                                sc3.nextLine(); // Clear the invalid input
                                System.out.print("Invalid input. Please enter a valid numeric choice in the range 1-5: ");
                            }
                        }
                        break;
                    case 3:
                        Menu.book_menu();
                        Scanner sc4 = new Scanner(System.in);
                        int book_choice;
                        boolean validInput3 = false;
                        while (!validInput3) {
                            try {
                                book_choice = sc4.nextInt();
                                if (book_choice == 1){
                                    System.out.println("\nList of books");
                                    System.out.println(all_books);
                                    validInput3 = true;
                                }
                                else if (book_choice == 2) {
                                    a.insert_new_book(all_books);
                                    validInput3 = true;
                                }
                                else if (book_choice == 3) {
                                    a.delete_book(all_books);
                                    validInput3 = true;
                                }
                                else if (book_choice == 4){
                                    //ArrayList<Library> libraries_with_book = a.find_book(all_books, all_libraries);
                                    //System.out.println("\n" + libraries_with_book);
                                    a.find_book(all_books, all_libraries);
                                    validInput3 = true;
                                }
                                else if (book_choice == 5)
                                    validInput3 = true;
                                else
                                    System.out.print("The number must be in the range 1-5: ");
                            }
                            catch (InputMismatchException e) {
                                sc4.nextLine(); // Clear the invalid input
                                System.out.print("Invalid input. Please enter a valid numeric choice in the range 1-5: ");
                            }
                        }
                        break;
                    case 4:
                        Menu.edit_menu();
                        Scanner sc5 = new Scanner(System.in);
                        int edit_choice;
                        boolean validInput4 = false;
                        while (!validInput4) {
                            try {
                                edit_choice = sc5.nextInt();
                                if (edit_choice == 1){
                                    Library library = b.select_library(all_libraries);
                                    if (library.getName().equals("Library Not Found"))
                                        break;
                                    else
                                        library.add_book_in_library(all_books, all_libraries,library.getName());
                                    validInput4 = true;
                                }
                                else if (edit_choice == 2) {
                                    Library library = b.select_library(all_libraries);
                                    if (library.getName().equals("Library Not Found"))
                                        break;
                                    else
                                        b.remove_book_from_library(all_books, all_libraries, library.getName());
                                    validInput4 = true;
                                }
                                else if (edit_choice == 3)
                                    validInput4 = true;
                                else
                                    System.out.print("The number must be in the range 1-3: ");
                            }
                            catch (InputMismatchException e) {
                                sc5.nextLine(); // Clear the invalid input
                                System.out.print("Invalid input. Please enter a valid numeric choice in the range 1-3: ");
                            }
                        }
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Please, insert a number in the range 1-5.");
                }
            }
        }
    }
}
