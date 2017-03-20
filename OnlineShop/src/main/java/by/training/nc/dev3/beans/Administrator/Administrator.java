package by.training.nc.dev3.beans.Administrator;

import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.enums.AdminAct;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дмитрий on 17.03.2017.
 */
public class Administrator extends Human implements Serializable {
    private String email;
    Map<AdminAct, ActCommand> acts = new HashMap<>();

    public Administrator() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator that = (Administrator) o;

        if (!email.equals(that.email)) return false;
        return acts != null ? acts.equals(that.acts) : that.acts == null;

    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + (acts != null ? acts.hashCode() : 0);
        return result;
    }

    public Administrator(String name, String surname, String email) {
        super(name, surname);
        this.email = email;
    }

    public void fillMap() {
        acts.put(AdminAct.ADD, new AddCommandAdmin());
        acts.put(AdminAct.VIEW, new ViewCommandAdmin());
        acts.put(AdminAct.REMOVE, new RemoveCommandAdmin());
        acts.put(AdminAct.REMOVEALL, new RemoveAllCommandAdmin());
        acts.put(AdminAct.CHECK, new CheckOrderCommandAdmin());
    }

    public void doAction(AdminAct act) {
        for (Map.Entry<AdminAct, ActCommand> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                entry.getValue().execute();
            }
        }
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
