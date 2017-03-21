package by.training.nc.dev3.beans;

import java.io.Serializable;

public abstract class Human implements Serializable {
    private String name;
    private String surname;

    public Human() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
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
