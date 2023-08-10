package data;

import domian.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс BookStore является реализацией интерфейса BookRepository и
 * использует коллекцию для хранения книг
 */
public class InMemoryBookRepository implements BookRepository{
    private List<Book> books;

    /**
     * Создает новый экземпляр класса InMemoryBookRepository
     */
    public InMemoryBookRepository() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}
