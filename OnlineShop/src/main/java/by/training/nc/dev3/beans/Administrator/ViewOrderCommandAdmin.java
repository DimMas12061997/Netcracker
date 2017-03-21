package by.training.nc.dev3.beans.Administrator;


public class ViewOrderCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.viewOrder();
    }
}