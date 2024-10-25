package pl.lukaszlebiecki.library.app;

import pl.lukaszlebiecki.library.io.DataReader;
import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.Library;
import pl.lukaszlebiecki.library.model.Magazine;

public class LibraryControl {


    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case ADD_MAGAZINE -> addMagazine();
                case PRINTS_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadź ponowanie.");
            }
        } while (option != Option.EXIT);

    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
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
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }

}
