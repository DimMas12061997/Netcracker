package by.training.nc.dev3.beans.Administrator;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class RemoveCommandAdmin extends ActCommand {
    @Override
    public void execute() {
        acts.removeGood();
    }
}
