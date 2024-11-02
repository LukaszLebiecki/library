package pl.lukaszlebiecki.library.model;

import java.io.Serializable;

public class Library implements Serializable {

    private static final int MAX_PUBLICATION = 200;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATION];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATION) {
            throw new ArrayIndexOutOfBoundsException("Max publication exceeded " + MAX_PUBLICATION);
        }
        publications[publicationsNumber++] = publication;

    }
}
