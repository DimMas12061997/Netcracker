package by.training.nc.dev3.command.admin;

public class RemoveAllGoodsAdmin extends ActAdmin {
    @Override
    public void execute() {
        acts.removeAllGoods();
    }
}
