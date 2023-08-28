package agregator;

public class OrderItem {

    private Product product;
    private int quantity;

    /**
     * Конструктор, который создает элемент заказа.
     *
     * @param product  Продукт, который нужно добавить в заказ
     * @param quantity Количество продукта в заказе
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
