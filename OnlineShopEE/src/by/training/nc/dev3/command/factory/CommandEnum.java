package by.training.nc.dev3.command.factory;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.command.admin.AdminEditPageCommand;
import by.training.nc.dev3.command.admin.AdminProfilePageCommand;
import by.training.nc.dev3.command.admin.ShowCustomersCommand;
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
    SHOW_CUSTOMERS{
        {
            this.command = new ShowCustomersCommand();
        }
    },
    CATALOG{
        {
            this.command = new CatalogCommand();
        }
    },
    SHOW_GOODS{
        {
            this.command = new ShowGoodsCommand();
        }
    },
    MAKE_ORDER{
        {
            this.command = new MakeOrderCommand();
        }
    },
    SHOW_DESCRIPTION{
        {
            this.command = new ShowDescriptionCommand();
        }
    },
    REMOVE_ORDER{
        {
            this.command = new RemoveOrderCommand();
        }
    },
    UPDATE_ORDER{
        {
            this.command = new UpdateOrderCommand();
        }
    },
    BUY_ORDER{
        {
            this.command = new BuyOrderCommand();
        }
    },
    SHOW_ORDER{
        {
            this.command = new ShowOrderCommand();
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