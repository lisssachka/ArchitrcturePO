package data;

import domian.Book;

import java.util.List;

/**
 * Интерфейс BookRepository определяет методы для управления книгами в интернет-магазине
 */

public interface BookRepository {
    /**
     * Добавляет книгу в репозиторий
     * @param book объект класса Book
     */

    void addBook(Book book);

    /**
     * Удаляет книгу из репозитория
     * @param book объект класса Book
     */
    void removeBook(Book book);

    /**
     * Получает все книги из репозитория
     * @return список всех книг в репозитории
     */
    List<Book> getAllBooks();
}