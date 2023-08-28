package agregator;

import java.sql.SQLException;

public class OrderService {

    // Репозиторий для работы с заказами в базе данных
    private OrderRepository repository;

    /**
     * Конструктор класса OrderService.
     *
     * @param repository Репозиторий для работы с заказами в БД.
     */
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод для создания и сохранения заказа в БД
     * @param order Объект, который необходимо сохранить.
     * @throws SQLException Если возникнет проблема с БД.
     */
    public void createOrder(Order order) throws SQLException {
        repository.save(order);
    }

    /**
     * Метод для получения заказа по его идентификатору.
     *
     * @param id Идентификатор заказа.
     * @return Объект заказа или null.
     * @throws SQLException Если возникнет проблема с базой данных.
     */
    public Order getOrderById(int id) throws SQLException {
        return repository.getById(id);
    }

}
