package by.training.nc.dev3.constants;

public class SqlRequests {
    public static final String ADD_CUTOMER = "INSERT INTO online_shop.user(first_name, last_name, login, password, role_id, shop_id ) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String GET_ID_ROLE = "SELECT role_id FROM online_shop.role WHERE role_name = ?;";
    public static final String GET_ID_SHOP = "SELECT id_shop FROM online_shop.shop WHERE name_shop = ?;";

    private SqlRequests() {
    }
}