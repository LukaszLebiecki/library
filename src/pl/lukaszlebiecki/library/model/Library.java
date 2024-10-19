package pl.lukaszlebiecki.library.model;

public class Library {

    private static final int MAX_BOOKS = 100;
    private Book[] books = new Book[MAX_BOOKS];
    private int booksNumber = 0;

    public void addBook(Book book) {
        if (booksNumber < MAX_BOOKS) {
            books[booksNumber++] = book;
        } else {
            System.out.println("Maxymalna liczba książek została osiągnięta!");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak książek w bibliotece");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }
}
