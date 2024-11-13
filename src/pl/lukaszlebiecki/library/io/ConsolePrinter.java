package pl.lukaszlebiecki.library.io;

import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.LibraryUser;
import pl.lukaszlebiecki.library.model.Magazine;
import pl.lukaszlebiecki.library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {

    public void printBooks(Collection<Publication> publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine("Brak książek w bibliotece");
        }

    }

    public void printMagazines(Collection<Publication> publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
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
