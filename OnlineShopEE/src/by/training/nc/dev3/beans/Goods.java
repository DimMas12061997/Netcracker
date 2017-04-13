package by.training.nc.dev3.beans;


public class Goods extends Entity {
    private int idGoods;
    private String name;
    private int number;
    private double unitPrice;
    private String producer;
    private String description;
    private String createdDate;
    private int shopId;
    private int categoryId;

    @Override
    public String toString() {
        return "Goods{" +
                "idGoods=" + idGoods +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", shopId=" + shopId +
                ", categoryId=" + categoryId +
                '}';
    }

    public int getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(int idGoods) {
        this.idGoods = idGoods;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
