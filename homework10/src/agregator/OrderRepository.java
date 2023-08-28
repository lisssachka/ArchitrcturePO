package agregator;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    // Соединение с базой данных
    private Connection connection;

    public OrderRepository(String databaseUrl) throws SQLException {
        connection = DriverManager.getConnection(databaseUrl);
        initDatabase();
    }

    /**
     * Инициализация таблиц в БД.
     */
    private void initDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        // Создание таблицы продуктов, если она еще не создана
        statement.execute("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name TEXT, price REAL)");
        // Создание таблицы заказов, если она еще не создана
        statement.execute("CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT, totalAmount REAL)");
        // Создание таблицы элементов заказа, если она еще не создана
        statement.execute("CREATE TABLE IF NOT EXISTS order_items (orderId INTEGER, productId INTEGER, quantity INTEGER)");
        statement.close();
    }

    /**
     * Сохранение информации о заказе в БД.
     *
     * @param order Заказ, который необходимо сохранить
     */
    public void save(Order order) throws SQLException {
        connection.setAutoCommit(false);

        // Вставка данных о заказе в таблицу заказов
        PreparedStatement orderStmt = connection.prepareStatement("INSERT INTO orders(totalAmount) VALUES (?)");
        orderStmt.setDouble(1, order.getTotalPrice());
        orderStmt.executeUpdate();
        ResultSet generatedKeys = orderStmt.getGeneratedKeys();
        int orderId = generatedKeys.getInt(1);
        generatedKeys.close();
        orderStmt.close();

        // Вставка данных о элементах заказа в таблицу элементов заказа
        PreparedStatement itemStmt = connection.prepareStatement("INSERT INTO order_items(orderId, productId, quantity) VALUES (?, ?, ?)");
        for (OrderItem item : order.getItems()) {
            itemStmt.setInt(1, orderId);
            itemStmt.setInt(2, item.getProduct().getId());
            itemStmt.setInt(3, item.getQuantity());
            itemStmt.executeUpdate();
        }
        itemStmt.close();

        connection.commit();
        connection.setAutoCommit(true);
    }

    /**
     * Извлечение последнего заказа из БД.
     *
     * @return Последний сохраненный заказ или null
     */
    public Order getLastOrder() throws SQLException {
        String query = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int orderId = resultSet.getInt("id");
            Order order = new Order();
            order.setItems(getOrderItemsByOrderId(orderId));

            return order;
        }

        return null;
    }

    /**
     * Извлечение заказа из БД по идентификатору.
     *
     * @param id Идентификатор заказа
     * @return Заказ с указанным идентификатором или null
     */
    public Order getById(int id) throws SQLException {
        Order order = new Order();
        order.setItems(getOrderItemsByOrderId(id));
        return order;
    }

    private List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_items WHERE orderId=?");
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("productId");
            int quantity = rs.getInt("quantity");
            Product product = new Product(productId, "Product " + productId, 10.0);
            orderItems.add(new OrderItem(product, quantity));
        }
        rs.close();
        stmt.close();

        return orderItems;
    }

}