package domian;

public class Book {
    private String id;
    private String title;
    private String author;
    private double price;

    /**
     * Создание нового экземпляра класса
     * @param id идентификатор книги
     * @param title название книги
     * @param author автор книги
     * @param price цена книги
     */
    public Book(String id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Книга: " + title + ", Автор: " + author + ", Цена: $" + price);
    }
}
