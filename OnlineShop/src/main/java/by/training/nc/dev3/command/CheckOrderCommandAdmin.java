package by.training.nc.dev3.command;

import java.io.InvalidObjectException;

public class CheckOrderCommandAdmin extends ActCommand {
    @Override
    public void execute() throws InvalidObjectException {
        acts.checkOrder();
    }
}
