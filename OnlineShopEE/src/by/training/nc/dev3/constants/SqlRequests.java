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
    public static final String GET_GOODS_BY_CATEGORY_ID_SORT_BY_PRICE = "SELECT * FROM online_shop.goods WHERE category_id = ? ORDER BY unit_price";
    public static final String GET_GOODS_ID = "SELECT * FROM online_shop.goods WHERE goods_id = ?";
    public static final String GET_GATEGORY_BY_ID = "SELECT * FROM online_shop.category WHERE id_category = ?";
    public static final String UPDATE_NUMBER_GOODS = "UPDATE online_shop.goods SET goods_number = ? WHERE goods_name = ?";
    public static final String GET_ORDER_ID = "SELECT order_id FROM online_shop.order WHERE id_user = ?;";
    public static final String ADD_ORDER = "INSERT INTO online_shop.order(order_cost, id_user) VALUES (?, ?)";
    public static final String UPDATE_ORDER = "UPDATE online_shop.order SET order_cost = ? WHERE id_user = ?";
    public static final String GET_GOODS_BY_NAME = "SELECT * FROM online_shop.goods WHERE goods_name = ?;";
    public static final String GET_ORDER_BY_USER_ID = "SELECT * FROM online_shop.order WHERE id_user = ?;";
    public static final String ADD_GOODS_ORDER = "INSERT INTO online_shop.order_goods(id_order, id_goods, number) VALUES (?, ?, ?)";
    public static final String GET_ALL_GOODS_ORDER = "SELECT * FROM online_shop.order_goods";
    public static final String UPDATE_NUMBER_GOODS_ORDER = "UPDATE online_shop.order_goods SET number = ? WHERE id_order = ? AND id_goods = ?";
    public static final String GET_COUNT_NUMBER = "SELECT sum(number) FROM online_shop.order_goods where id_order = ?";
    public static final String GET_ALL_GOODS_ORDER_BY_ID = "SELECT goods_id, goods_name, unit_price, goods_number, number, producer, description, category_id FROM online_shop.order_goods og INNER JOIN online_shop.goods g ON og.id_goods = g.goods_id WHERE id_order = ?";
    public static final String REMOVE_ORDER_BY_ID = "DELETE FROM online_shop.order_goods WHERE id_goods = ?";
    public static final String REMOVE_ORDER = "DELETE FROM online_shop.order WHERE id_user = ?";
    public static final String GET_SHOP_BY_ID = "SELECT * FROM online_shop.shop WHERE id_shop = ?";
    public static final String UPDATE_SHOP = "UPDATE online_shop.shop SET profit = ? WHERE id_shop = ?";
    public static final String UPDATE_ORDER_STATUS = "UPDATE online_shop.order SET order_status = ? WHERE id_user = ?";
    public static final String GET_ALL_ORDERS = "SELECT order_id,order_cost,login FROM online_shop.`order` o INNER JOIN online_shop.user u ON o.id_user = u.user_id WHERE order_status = ? AND u.role_id = 2";
    public static final String GET_ALL_ORDERS_COSTS = "SELECT order_id,order_cost,login FROM online_shop.`order` o INNER JOIN online_shop.user u ON o.id_user = u.user_id WHERE order_status = 1";
    public static final String GET_ALL_GOODS = "SELECT * FROM online_shop.goods g INNER JOIN online_shop.category c ON g.category_id = c.id_category";
    public static final String GET_ALL_GOODS_SORT_BY_PRICE = "SELECT * FROM online_shop.goods g INNER JOIN online_shop.category c ON g.category_id = c.id_category ORDER BY unit_price";
    public static final String GET_ALL_GOODS_BY_CATEGORY_ID = "SELECT * FROM online_shop.goods g INNER JOIN online_shop.category c ON g.category_id = c.id_category WHERE category_id = ?";
    public static final String REMOVE_CATEGORY = "DELETE FROM online_shop.category WHERE id_category = ?";
    public static final String ADD_USER_BLACK_LIST = "INSERT INTO online_shop.black_list(user_id) VALUES (?)";
    public static final String GET_ALL_USER_IN_BLACK_LIST = "SELECT u.user_id, login, first_name, last_name FROM online_shop.black_list bl INNER JOIN online_shop.user u ON bl.user_id = u.user_id";
    public static final String GET_BLACKLIST_BY_ID = "SELECT * FROM online_shop.black_list WHERE user_id = ?";
    public static final String ADD_CATEGORY = "INSERT INTO online_shop.category (category_name) VALUES (?)";
    public static final String GET_GATEGORY_BY_NAME = "SELECT * FROM online_shop.category WHERE category_name = ?";
    public static final String ADD_GOODS = "INSERT INTO online_shop.goods(goods_name, goods_number, unit_price, producer, description, shop_id, category_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String REMOVE_GOODS = "DELETE FROM online_shop.goods WHERE goods_id = ?";
    public static final String REMOVE_USER_FROM_BLACKLIST = "DELETE FROM online_shop.black_list WHERE user_id = ?";
    public static final String UPDATE_CATEGORY = "UPDATE online_shop.category SET category_name = ? WHERE id_category = ?";
    public static final String UPDATE_GOODS = "UPDATE online_shop.goods SET goods_name = ?, goods_number = ?, unit_price = ?, producer = ?, description = ?, shop_id = ?, category_id = ?  WHERE goods_id = ?";

    private SqlRequests() {
    }
}