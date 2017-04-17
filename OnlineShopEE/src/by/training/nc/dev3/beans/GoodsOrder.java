package by.training.nc.dev3.beans;


public class GoodsOrder extends Entity{
    private int idGoods;
    private int idOrder;
    private int number;

    public int getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(int idGoods) {
        this.idGoods = idGoods;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "GoodsOrder{" +
                "idGoods=" + idGoods +
                ", idOrder=" + idOrder +
                ", number=" + number +
                '}';
    }
}
