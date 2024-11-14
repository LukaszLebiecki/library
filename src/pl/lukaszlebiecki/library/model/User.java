package pl.lukaszlebiecki.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable, CsvConvertible {
    private String firsName;
    private String lastName;
    private String pesel;

    public User(String firsName, String lastName, String pesel) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public abstract String toCsv();

    @Override
    public String toString() {
        return firsName + " " + lastName + " " + pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firsName, user.firsName) && Objects.equals(lastName, user.lastName) && Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName, pesel);
    }
}
