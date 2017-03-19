package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.beans.Administrator.*;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дмитрий on 17.03.2017.
 */
public class Customer extends Human {
    private String CreditCardNumber;
    private String address;
    private double budget;        //параметризация
    Map<CustomerAct, ActCommandCustomer> acts = new HashMap<>();

    public Customer() {

    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void fillMap() {
        acts.put(CustomerAct.ADD, new AddCommandCustomer());
        acts.put(CustomerAct.VIEW, new ViewCommandCustomer());
        acts.put(CustomerAct.REMOVE, new RemoveCommandCustomer());
        acts.put(CustomerAct.REMOVEALL, new RemoveAllCommandCustomer());
        acts.put(CustomerAct.VIEWORDER, new ViewOrderCommandCustomer());
        acts.put(CustomerAct.PAYORDER, new PaymentCommandCustomer());
    }

    public void doAction(CustomerAct act) {
        for (Map.Entry<CustomerAct, ActCommandCustomer> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                entry.getValue().execute();
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", CreditCardNumber='" + CreditCardNumber + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                '}';
    }

    public Customer(String name, String surname, String creditCardNumber, String address, double budget) {
        super(name, surname);
        CreditCardNumber = creditCardNumber;
        this.address = address;
        this.budget = budget;
    }
}
