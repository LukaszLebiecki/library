package pl.lukaszlebiecki.library.io;

import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.LibraryUser;
import pl.lukaszlebiecki.library.model.Magazine;
import pl.lukaszlebiecki.library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {

    public void printBooks(Collection<Publication> publications) {
        long count = publications.stream()
                .filter(p -> p instanceof Book)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();

        if (count == 0) {
            printLine("Brak książek w bibliotece");
        }

    }

    public void printMagazines(Collection<Publication> publications) {
        long count = publications.stream()
                .filter(p -> p instanceof Magazine)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();
        if (count == 0) {
            printLine("Brak magazynów w bibliotece");
        }
    }

    public void printUser(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }
}
