package presentation;

import data.InMemoryBookRepository;
import domian.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository();

        // Добавляем книги в магазин
        Book book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        Book book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        inMemoryBookRepository.addBook(book1);
        inMemoryBookRepository.addBook(book2);

        // Получаем список всех книг в магазине
        List<Book> allBooks = inMemoryBookRepository.getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }
}
