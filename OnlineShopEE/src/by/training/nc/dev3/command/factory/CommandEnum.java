package by.training.nc.dev3.command.factory;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.command.user.*;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGINPAGE {
        {
            this.command = new LoginPageCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    REGISTRATIONPAGE {
        {
            this.command = new RegistrationPageCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}