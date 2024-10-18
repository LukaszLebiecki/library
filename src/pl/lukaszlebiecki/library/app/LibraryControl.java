package pl.lukaszlebiecki.library.app;

import pl.lukaszlebiecki.library.io.DataReader;
import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.Library;

public class LibraryControl {
    private final int exit = 0;
    private final int addBook = 1;
    private final int printBook = 2;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case addBook -> addBook();
                case printBook -> printBooks();
                case exit -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponowanie.");
            }
        } while (option != exit);

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
        System.out.println(exit + " - wyjście z programu");
        System.out.println(addBook + " - dodanie nowej książki");
        System.out.println(printBook + " - wyświetl dostępne książki");
    }

}
