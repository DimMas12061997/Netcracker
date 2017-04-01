package by.training.nc.dev3.beans;


import java.io.Serializable;

public class Goods implements Serializable{
    private String name;
    private int number;
    private double unitPrice;
    private String producer;
    private String description;
    private static int numberObjects;

    public Goods() {
        numberObjects++;
    }

    public Goods(String name, int number, double unitPrice, String producer, String description) {
        this.name = name;
        this.number = number;
        this.unitPrice = unitPrice;
        this.producer = producer;
        this.description = description;
        numberObjects++;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
