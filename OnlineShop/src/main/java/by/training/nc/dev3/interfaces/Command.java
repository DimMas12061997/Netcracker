package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.exceptions.MyException;

public interface Command {
    /**
     * Calls a method by object type
     *
     * @throws MyException
     */
    void execute() throws MyException;
}
