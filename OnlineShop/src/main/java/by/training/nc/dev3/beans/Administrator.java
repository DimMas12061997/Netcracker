package by.training.nc.dev3.beans;

import by.training.nc.dev3.command.*;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.exceptions.MyException;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Administrator extends Human implements Serializable {
    private String email;
    Map<AdminAct, ActCommand> acts = new HashMap<>();

    public Administrator() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Administrator that = (Administrator) o;

        if (!email.equals(that.email)) return false;
        return acts.equals(that.acts);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + acts.hashCode();
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
        acts.put(AdminAct.VIEWORDER, new ViewOrderCommandAdmin());
        acts.put(AdminAct.CHECK, new CheckOrderCommandAdmin());
        acts.put(AdminAct.VIEWBLACKLIST, new  ViewBlackListCommandAdmin());

    }

    public void doAction(AdminAct act) throws MyException {
        for (Map.Entry<AdminAct, ActCommand> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                try {
                    entry.getValue().execute();
                } catch (InvalidObjectException e) {
                    e.printStackTrace();
                }
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
