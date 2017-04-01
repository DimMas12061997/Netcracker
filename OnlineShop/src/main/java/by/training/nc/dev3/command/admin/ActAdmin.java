package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.service.AdminActs;
import by.training.nc.dev3.interfaces.Command;

public abstract class ActAdmin implements Command {
    protected AdminActs acts = new AdminActs();
}
