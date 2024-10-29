package pl.lukaszlebiecki.library.app;

import pl.lukaszlebiecki.library.exception.NoSuchOptionException;
import pl.lukaszlebiecki.library.io.ConsolePrinter;
import pl.lukaszlebiecki.library.io.DataReader;
import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.Library;
import pl.lukaszlebiecki.library.model.Magazine;
import pl.lukaszlebiecki.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case ADD_MAGAZINE -> addMagazine();
                case PRINTS_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> printer.printLine("Nie ma takiej opcji, wprowadź ponowanie.");
            }
        } while (option != Option.EXIT);

    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk){
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie:");
            }
        }
        return option;
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnego magazynu");
        }
    }

    private void exit(){
        printer.printLine("Koniec programu, papa!");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć książki, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie można dodać kolejnej ksiązki");
        }
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję:");
        for (Option value : Option.values()) {
            printer.printLine(value.toString());
        }
    }

}
