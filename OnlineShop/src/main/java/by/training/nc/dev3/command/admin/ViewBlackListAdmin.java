package by.training.nc.dev3.command.admin;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class ViewBlackListAdmin extends ActAdmin {
    @Override
    public void execute() {
        acts.viewBlackList();
    }
}
