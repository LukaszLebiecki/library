package pl.lukaszlebiecki.library.io;

import pl.lukaszlebiecki.library.model.Book;
import pl.lukaszlebiecki.library.model.Magazine;
import pl.lukaszlebiecki.library.model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(publication);
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine("Brak książek w bibliotece");
        }

    }

    public void printMagazines(Publication[] publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                System.out.println(publication);
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            printLine("Brak magazynów w bibliotece");
        }
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }
}
