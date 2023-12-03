public class Menu {
//    public static void menu(){
//        System.out.println("\n1 - Search");
//        System.out.println("2 - List of books");
//        System.out.println("3 - List of libraries");
//        System.out.println("4 - Add a new book to the system");
//        System.out.println("5 - Add a new library to the system");
//        System.out.println("6 - Add a book in a library");
//        System.out.println("7 - Remove a book from a library");
//        System.out.println("8 - Library Content");
//        System.out.println("9 - The libraries in which there is a book");
//        System.out.println("10 - Delete a book from the system");
//        System.out.println("11 - Delete a library from the system");
//        System.out.println("12 - Exit\n");
//        System.out.print("Insert a choice (1-12): ");
//    }

    public static void menu(){
        System.out.println("\nMain Menu\n");
        System.out.println("1 - Search");
        System.out.println("2 - Library Management");
        System.out.println("3 - Book Management");
        System.out.println("4 - Edit");
        System.out.println("5 - Exit");
        System.out.print("\nInsert a choice (1-5): ");
    }

    public static void search_menu(){
        System.out.println("\nSearch");
        System.out.println("\n1 - Display All Books and Libraries");
        System.out.println("2 - Display Categorized Results");
        System.out.println("3 - Back to the Main Menu");
        System.out.print("\nInsert a choice (1-3): ");
    }

    public static void book_menu(){
        System.out.println("\nBook Management");
        System.out.println("\n1 - List of books");
        System.out.println("2 - Add a new book to the system");
        System.out.println("3 - Delete a book from the system");
        System.out.println("4 - The libraries in which there is a book");
        System.out.println("5 - Back to the Main Menu");
        System.out.print("\nInsert a choice (1-5): ");
    }

    public static void library_menu(){
        System.out.println("\nLibrary Management");
        System.out.println("\n1 - List of libraries");
        System.out.println("2 - Add a new library to the system");
        System.out.println("3 - Delete a library from the system");
        System.out.println("4 - Library Content");
        System.out.println("5 - Back to the Main Menu");
        System.out.print("\nInsert a choice (1-5): ");
    }

    public static void edit_menu(){
        System.out.println("\nEdit");
        System.out.println("\n1 - Add a book in a library");
        System.out.println("2 - Remove a book from a library");
        System.out.println("3 - Back to the Main Menu");
        System.out.print("\nInsert a choice (1-3): ");
    }
}
