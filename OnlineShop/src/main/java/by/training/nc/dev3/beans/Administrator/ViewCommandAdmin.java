package by.training.nc.dev3.beans.Administrator;

public class ViewCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.viewGoods();
    }
}