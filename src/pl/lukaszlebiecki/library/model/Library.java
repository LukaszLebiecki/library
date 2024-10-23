package pl.lukaszlebiecki.library.model;

public class Library {

    private static final int MAX_PUBLICATION = 200;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATION];


    public void addBook(Book book) {
        if (publicationsNumber < MAX_PUBLICATION) {
            publications[publicationsNumber++] = book;
        } else {
            System.out.println("Maxymalna liczba książek została osiągnięta!");
        }
    }

    public void printBooks() {
        int countBooks = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Book) {
                publications[i].printInfo();
                countBooks++;
            }
        }
        if (countBooks == 0) {
            System.out.println("Brak książek w bibliotece");
        }

    }

    public void addMagazine(Magazine magazine) {
        if (publicationsNumber < MAX_PUBLICATION) {
            publications[publicationsNumber++] = magazine;
        } else {
            System.out.println("Maxymalna liczba magazynow została osiągnięta!");
        }
    }

    public void printMagazines() {
        int countMagazines = 0;
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i] instanceof Magazine) {
                publications[i].printInfo();
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
    }
}
