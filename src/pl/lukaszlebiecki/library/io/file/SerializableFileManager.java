package pl.lukaszlebiecki.library.io.file;

import pl.lukaszlebiecki.library.exception.DataExportException;
import pl.lukaszlebiecki.library.exception.DataImportException;
import pl.lukaszlebiecki.library.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Library.o";


    @Override
    public Library importData() {
        try (
                var fis = new FileInputStream(FILE_NAME);
                var ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (ClassNotFoundException | IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {
        try (
                var fos = new FileOutputStream(FILE_NAME);
                var oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        } catch (IOException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        }

    }
}
