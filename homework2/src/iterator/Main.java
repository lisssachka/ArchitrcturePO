package iterator;

// Интерфейс контейнера (агрегата)
interface IAggregate<T> {
    // Метод, возвращающий итератор для контейнера
    IIterator<T> CreateIterator();

    // Метод, возвращающий количество элементов в контейнере
    int Count();

    // Метод, возвращающий элемент в контейнере по его позиции index
    T GetItem(int index);
}

// Интерфейс итератора
interface IIterator<T> {
    // Перемотать курсор в начало набора
    void First();

    // Перемотать курсор на следующий элемент
    void Next();

    // Вернуть элемент, на который указывает курсор
    T CurrentItem();

    // Проверка, указывает ли курсор на позицию,
    // которая находится за последним элементом набора
    boolean IsDone();
}

public class Main {
    public static void main(String[] args) {

    }
}
