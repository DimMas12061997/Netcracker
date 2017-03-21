package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.beans.Administrator.*;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.enums.AdminAct;
import by.training.nc.dev3.enums.CustomerAct;
import by.training.nc.dev3.exceptions.MyException;
import by.training.nc.dev3.tools.FileWorker;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Customer extends Human implements Serializable {
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

    public void setBudget(double budget) {
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

    public void doAction(CustomerAct act) throws MyException {
        System.out.println(this);
        FileWorker sz = new FileWorker();
        String customers = FileWorker.filePath + "customers.txt";
        Customer res = null;
        try {
            res = (Customer) sz.deserialization(customers);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(res);
        CustomerActs customerActs = new CustomerActs(res);
        for (Map.Entry<CustomerAct, ActCommandCustomer> entry : acts.entrySet()) {
            if (act.equals(entry.getKey())) {
                entry.getValue().execute();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (Double.compare(customer.budget, budget) != 0) return false;
        if (CreditCardNumber != null ? !CreditCardNumber.equals(customer.CreditCardNumber) : customer.CreditCardNumber != null)
            return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        return acts != null ? acts.equals(customer.acts) : customer.acts == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (CreditCardNumber != null ? CreditCardNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(budget);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (acts != null ? acts.hashCode() : 0);
        return result;
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
