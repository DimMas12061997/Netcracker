package by.training.nc.dev3.resource;


import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static ResourceBundle resourceBundle;

    private LocaleManager() {
    }

    public static void setBundle(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("pagecontent", locale);
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public static void fillSession(HttpSession session) {
        try {
            session.setAttribute("title", new String((LocaleManager.getProperty("label.title").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("submit", new String((LocaleManager.getProperty("button.submit").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("catalog", new String((LocaleManager.getProperty("menu.catalog").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("search", new String((LocaleManager.getProperty("button.search").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("searchGood", new String((LocaleManager.getProperty("placeholder.searchGood").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("entrance", new String((LocaleManager.getProperty("menu.entrance").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("registration", new String((LocaleManager.getProperty("menu.registration").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderLogin", new String((LocaleManager.getProperty("placeholder.login").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderPassword", new String((LocaleManager.getProperty("placeholder.password").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderName", new String((LocaleManager.getProperty("placeholder.name").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderSurname", new String((LocaleManager.getProperty("placeholder.surname").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderRepeatPassword", new String((LocaleManager.getProperty("placeholder.repeatPassword").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("descriptionShop", new String((LocaleManager.getProperty("label.descriptionShop").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("basket", new String((LocaleManager.getProperty("menu.basket").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("myProfile", new String((LocaleManager.getProperty("menu.myProfile").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("logout", new String((LocaleManager.getProperty("menu.logout").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("edit", new String((LocaleManager.getProperty("menu.edit").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("users", new String((LocaleManager.getProperty("menu.users").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("managingBlackList", new String((LocaleManager.getProperty("menu.managingBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("purchaseHistory", new String((LocaleManager.getProperty("menu.purchaseHistory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("shopManagement", new String((LocaleManager.getProperty("menu.shopManagement").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("personalData", new String((LocaleManager.getProperty("label.personalData").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("emailLabel", new String((LocaleManager.getProperty("label.email").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("addressLabel", new String((LocaleManager.getProperty("label.address").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("budgetLabel", new String((LocaleManager.getProperty("label.budget").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("creditNumberLabel", new String((LocaleManager.getProperty("label.creditNumber").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("save", new String((LocaleManager.getProperty("button.save").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("editData", new String((LocaleManager.getProperty("label.editData").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("dateLabel", new String((LocaleManager.getProperty("label.date").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("menuLabel", new String((LocaleManager.getProperty("label.menu").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("newLabel", new String((LocaleManager.getProperty("label.new").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("priceLabel", new String((LocaleManager.getProperty("label.price").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("addBasketLabel", new String((LocaleManager.getProperty("label.addBasket").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("producerLabel", new String((LocaleManager.getProperty("label.producer").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("descriptionLabel", new String((LocaleManager.getProperty("label.description").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("sortLabel", new String((LocaleManager.getProperty("label.sort").getBytes("ISO-8859-1")), "Cp1251"));

            session.setAttribute("nameLabel", new String((LocaleManager.getProperty("label.nameGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("numberLabel", new String((LocaleManager.getProperty("label.numberGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("sumLabel", new String((LocaleManager.getProperty("label.summary").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("numberLabel", new String((LocaleManager.getProperty("label.numberGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("removeLabel", new String((LocaleManager.getProperty("label.remove").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("payLabel", new String((LocaleManager.getProperty("label.pay").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("update", new String((LocaleManager.getProperty("label.update").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("buy", new String((LocaleManager.getProperty("label.buy").getBytes("ISO-8859-1")), "Cp1251"));

            session.setAttribute("titlePurchase", new String((LocaleManager.getProperty("label.titlePurchase").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("loginLabel", new String((LocaleManager.getProperty("label.login").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("orderCostLabel", new String((LocaleManager.getProperty("label.orderCost").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("profitShopLabel", new String((LocaleManager.getProperty("label.profitShop").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("nonPayers", new String((LocaleManager.getProperty("label.nonPayers").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("orderPrice", new String((LocaleManager.getProperty("label.orderPrice").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("addBlackList", new String((LocaleManager.getProperty("label.addBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("blackListLabel", new String((LocaleManager.getProperty("label.blackList").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("surnameLabel", new String((LocaleManager.getProperty("label.surname").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("nameLabel", new String((LocaleManager.getProperty("label.name").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("removeFromBlackList", new String((LocaleManager.getProperty("label.removeFromBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("roleLabel", new String((LocaleManager.getProperty("label.role").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("adminLabel", new String((LocaleManager.getProperty("label.admin").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("customerLabel", new String((LocaleManager.getProperty("label.customer").getBytes("ISO-8859-1")), "Cp1251"));

            session.setAttribute("addCategory", new String((LocaleManager.getProperty("label.addCategory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("nameCategory", new String((LocaleManager.getProperty("label.nameCategory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("add", new String((LocaleManager.getProperty("button.add").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("editCategory", new String((LocaleManager.getProperty("label.editCategory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("editGoods", new String((LocaleManager.getProperty("label.editGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("chooseCategory", new String((LocaleManager.getProperty("label.chooseCategory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("addGoods", new String((LocaleManager.getProperty("label.addGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("selectAllGoods", new String((LocaleManager.getProperty("label.selectAllGoods").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("select", new String((LocaleManager.getProperty("label.select").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("categoryLabel", new String((LocaleManager.getProperty("label.category").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("remove", new String((LocaleManager.getProperty("button.remove").getBytes("ISO-8859-1")), "Cp1251"));

            if (session.getAttribute("errorLoginPassMessage") != null)
                session.setAttribute("errorLoginPassMessage", new String((LocaleManager.getProperty("message.loginerror").getBytes("ISO-8859-1")), "Cp1251"));
            if (session.getAttribute("userBlackList") != null)
                session.setAttribute("userBlackList", new String((LocaleManager.getProperty("message.userBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            if (session.getAttribute("errorPayment") != null)
                session.setAttribute("errorPayment", new String((LocaleManager.getProperty("message.buyerror").getBytes("ISO-8859-1")), "Cp1251"));
            if (session.getAttribute("regError") != null)
                session.setAttribute("regError", new String((LocaleManager.getProperty("message.regerror").getBytes("ISO-8859-1")), "Cp1251"));
            if (session.getAttribute("errorProfile") != null)
                session.setAttribute("errorProfile", new String((LocaleManager.getProperty("message.errorfillprofile").getBytes("ISO-8859-1")), "Cp1251"));
            if (session.getAttribute("notFound") != null)
            session.setAttribute("notFound", new String((LocaleManager.getProperty("message.notFound").getBytes("ISO-8859-1")), "Cp1251"));

        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
    }
}
