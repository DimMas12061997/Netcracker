package by.training.nc.dev3.beans;

/**
 * Created by Дмитрий on 17.03.2017.
 */
public abstract class Human {
    private String name;
    private String surname;

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
