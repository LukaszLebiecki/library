package pl.lukaszlebiecki.library.io;

import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.LibraryUser;
import pl.lukaszlebiecki.library.model.Magazine;

import java.util.Scanner;

public class DataReader {

    private final Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {
        printer.printLine("Tytuł:");
        String title = sc.nextLine();
        printer.printLine("Autor");
        String author = sc.nextLine();
        printer.printLine("Wydawnictwo");
        String publisher = sc.nextLine();
        printer.printLine("ISBN");
        String isbn = sc.nextLine();
        printer.printLine("Rok wydania");
        int year = getInt();
        printer.printLine("Liczba stron");
        int pages = getInt();
        return new Book(title, author, publisher, year, pages, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Tytuł:");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo");
        String publisher = sc.nextLine();
        printer.printLine("Jezyk");
        String language = sc.nextLine();
        printer.printLine("Rok wydania");
        int year = getInt();
        printer.printLine("Miesac");
        int month = getInt();
        printer.printLine("Dzien");
        int day = getInt();
        return new Magazine(title, publisher, language, year, month, day );
    }

    public LibraryUser createLibraryUser() {
        printer.printLine("Imię");
        String firsName = sc.nextLine();
        printer.printLine("Nazwisko");
        String lastName = sc.nextLine();
        printer.printLine("Pesel");
        String pesel = sc.nextLine();
        return new LibraryUser(firsName, lastName, pesel);
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
