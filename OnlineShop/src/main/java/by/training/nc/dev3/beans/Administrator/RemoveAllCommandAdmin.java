package by.training.nc.dev3.beans.Administrator;

public class RemoveAllCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.removeAllGoods();
    }
}
