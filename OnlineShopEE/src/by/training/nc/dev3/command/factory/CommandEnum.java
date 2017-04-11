package by.training.nc.dev3.command.factory;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.command.admin.AdminEditPageCommand;
import by.training.nc.dev3.command.admin.AdminProfilePageCommand;
import by.training.nc.dev3.command.customer.CustomerProfilePageCommand;
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
    ADMINPROFILEPAGE {
        {
            this.command = new AdminProfilePageCommand();
        }
    },
    EDITPAGE {
        {
            this.command = new AdminEditPageCommand();
        }
    },
    CUSTOMERPROFILEPAGE {
        {
            this.command = new CustomerProfilePageCommand();
        }
    },
    FILLPROFILE {
                {
                    this.command = new FillProfileCommand();
                }
            },
    EDIT_MAIN_DATA {
        {
            this.command = new EditMainDataCommand();
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