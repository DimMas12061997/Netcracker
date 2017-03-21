package by.training.nc.dev3.tools;

import by.training.nc.dev3.beans.Good;
import by.training.nc.dev3.enums.SortingIndex;

import java.util.Comparator;

/**
 * Created by Дмитрий on 21.03.2017.
 */
public class ServiceComparator implements Comparator<Good> {
    private SortingIndex index;

    public ServiceComparator(SortingIndex index) {
        this.index = index;
    }

    public SortingIndex getIndex() {
        return index;
    }

    public void setIndex(SortingIndex index) {
        if(index != null){
            this.index = index;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compare(Good o1, Good o2) {
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
