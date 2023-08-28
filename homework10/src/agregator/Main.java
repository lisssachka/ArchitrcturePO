package agregator;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {

            OrderRepository repo = new OrderRepository("jdbc:sqlite:shop.db");
            OrderService service = new OrderService(repo);
            Product book = new Product(1, "Книга", 100.0);
            Order order = new Order();
            OrderItem orderItem = new OrderItem(book, 3);
            order.addItem(orderItem);
            service.createOrder(order);
            Order lastOrder = repo.getLastOrder();
            if (lastOrder != null) {
                System.out.println("Последний сохраненный заказ:");
                System.out.println(lastOrder);
            } else {
                System.out.println("В базе данных нет заказов.");
            }

        } catch (SQLException e) {
                 e.printStackTrace();
        }
    }
}