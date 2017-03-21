package by.training.nc.dev3.command;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class ViewBlackListCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.viewBlackList();
    }
}
