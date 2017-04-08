package by.training.nc.dev3.command;
import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
String execute(HttpServletRequest request);
}