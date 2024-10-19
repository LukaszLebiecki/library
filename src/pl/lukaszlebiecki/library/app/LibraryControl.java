package pl.lukaszlebiecki.library.app;

import pl.lukaszlebiecki.library.io.DataReader;
import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.Library;

public class LibraryControl {

    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int PRINT_BOOK = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOK -> printBooks();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponowanie.");
            }
        } while (option != EXIT);

    }
    private void exit(){
        System.out.println("Koniec programu, papa!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(PRINT_BOOK + " - wyświetl dostępne książki");
    }

}
