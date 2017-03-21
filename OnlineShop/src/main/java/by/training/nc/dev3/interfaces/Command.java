package by.training.nc.dev3.interfaces;

import by.training.nc.dev3.exceptions.MyException;

import java.io.InvalidObjectException;

public interface Command {
   void execute() throws MyException, InvalidObjectException;
}
