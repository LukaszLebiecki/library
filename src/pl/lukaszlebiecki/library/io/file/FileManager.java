package pl.lukaszlebiecki.library.io.file;

import pl.lukaszlebiecki.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
