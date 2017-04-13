package by.training.nc.dev3.constants;

public class SqlRequests {
    public static final String ADD_CUTOMER = "INSERT INTO online_shop.user(first_name, last_name, login, password, role_id, shop_id ) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_ID_ROLE = "SELECT role_id FROM online_shop.role WHERE role_name = ?;";
    public static final String GET_ID_SHOP = "SELECT id_shop FROM online_shop.shop WHERE name_shop = ?;";
    public static final String GET_ROLE_NAME = "SELECT role_name FROM online_shop.user u INNER JOIN online_shop.role r ON u.role_id = r.role_id WHERE login = ? AND password = ?";
    public static final String GET_LOG_AND_PASS = "SELECT login, password FROM online_shop.user WHERE login = ? AND password = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM online_shop.user WHERE login = ?;";
    public static final String GET_USER_ID = "SELECT user_id FROM online_shop.user WHERE login = ?;";
    public static final String ADD_USER_PROFILE = "INSERT INTO online_shop.user_profil(email, address, budget, credit_card_number, user_id) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_USERPROFILE_BY_ID = "SELECT * FROM online_shop.user_profil WHERE user_id = ?;";
    public static final String UPDATE_USER_PROFILE = "UPDATE online_shop.user_profil SET email = ?, address = ?, budget = ?, credit_card_number = ? WHERE user_id = ?";
    public static final String UPDATE_USER = "UPDATE online_shop.user SET first_name = ?, last_name = ?, login = ?, password = ? WHERE user_id = ?";
    public static final String GET_ALL_CLIENTS = "SELECT first_name, last_name, login, role_id FROM online_shop.user ORDER BY last_name";
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM online_shop.category";
    public static final String GET_GOODS_BY_CATEGORY_ID = "SELECT * FROM online_shop.goods WHERE category_id = ?";
    private SqlRequests() {
    }
}