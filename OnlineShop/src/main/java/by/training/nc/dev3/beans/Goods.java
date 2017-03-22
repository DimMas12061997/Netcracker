package by.training.nc.dev3.beans;


import java.io.Serializable;

public class Goods implements Serializable {
    private String name;
    private int number;
    private double unitPrice;
    private static int numberObjects;

    public Goods() {
        numberObjects++;
    }

    public Goods(String name, int number, double unitPrice) {
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
        numberObjects++;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", numberObjects=" + numberObjects +
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
