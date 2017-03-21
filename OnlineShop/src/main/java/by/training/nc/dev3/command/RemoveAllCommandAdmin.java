package by.training.nc.dev3.command;

public class RemoveAllCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.removeAllGoods();
    }
}
