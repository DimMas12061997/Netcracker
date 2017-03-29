package by.training.nc.dev3.beans;

import java.io.Serializable;

public class Administrator extends Human implements Serializable {
    private String email;

    public Administrator() {
    }

    public Administrator(String name, String surname, String email) {
        super(name, surname);
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Administrator that = (Administrator) o;

        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
