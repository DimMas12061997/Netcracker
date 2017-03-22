package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.enums.SortingIndex;

import java.util.Comparator;


public class ServiceComparator implements Comparator<Goods> {
    private SortingIndex index;

    public ServiceComparator(SortingIndex index) {
        this.index = index;
    }

    @Override
    public int compare(Goods o1, Goods o2) {
        switch(index){
            case NAME:
                return o1.getName().compareTo(o2.getName());
            case PRICE:
                return Double.compare(o1.getUnitPrice(), o2.getUnitPrice());
            case NUMBER:
                return Double.compare(o1.getNumber(), o2.getNumber());
            default:
                throw new EnumConstantNotPresentException(SortingIndex.class, index.name());
        }
    }
}
