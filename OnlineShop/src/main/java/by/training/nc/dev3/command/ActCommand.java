package by.training.nc.dev3.command;

import by.training.nc.dev3.service.AdminActs;
import by.training.nc.dev3.interfaces.Command;

public abstract class ActCommand implements Command {
    protected AdminActs acts = new AdminActs();
}
