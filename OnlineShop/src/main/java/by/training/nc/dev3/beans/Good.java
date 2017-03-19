package by.training.nc.dev3.beans;

/**
 * Created by Дмитрий on 17.03.2017.
 */
public class Good {
    private String name;
    private int number;
    private double unitPrice;

    public Good() {
    }

    public Good(String name, int number, double unitPrice) {
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
