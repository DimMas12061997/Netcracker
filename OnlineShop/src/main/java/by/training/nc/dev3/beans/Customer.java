package by.training.nc.dev3.beans;

import java.io.Serializable;

public class Customer extends Human implements Serializable {
    private String CreditCardNumber;
    private String address;
    private double budget;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        if (Double.compare(customer.budget, budget) != 0) return false;
        if (CreditCardNumber != null ? !CreditCardNumber.equals(customer.CreditCardNumber) : customer.CreditCardNumber != null)
            return false;
        return address != null ? address.equals(customer.address) : customer.address == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (CreditCardNumber != null ? CreditCardNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(budget);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
