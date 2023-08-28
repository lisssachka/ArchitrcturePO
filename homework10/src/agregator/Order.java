package agregator;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Метод добавления элемента в заказ.
     *
     * @param item элемент заказа для добавления
     */
    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    /**
     * Метод расчета общей стоимости заказа.
     *
     * @return общая стоимость заказа
     */
    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
