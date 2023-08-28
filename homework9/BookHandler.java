import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookHandler implements HttpHandler {
    private static List<Book> books;
    private static AtomicInteger idGenerator;
    private static ObjectMapper objectMapper;

    public BookHandler() {
        this.books = new ArrayList<>();
        this.idGenerator = new AtomicInteger(1);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String[] pathParts = exchange.getRequestURI().getPath().split("/");
            if(pathParts.length == 3){
                int bookId = Integer.parseInt(pathParts[2]);
                for (Book book: books) {
                    if(bookId == book.getId()){
                        String responseBody = objectMapper.writeValueAsString(book);
                        exchange.getResponseHeaders().set("Content-Type", "application/json");
                        exchange.sendResponseHeaders(200, responseBody.length());
                        try (OutputStream os = exchange.getResponseBody()) {
                            os.write(responseBody.getBytes());
                        }
                    }
                }
            } else {
                String responseBody = objectMapper.writeValueAsString(books);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        } else if ("POST".equals(exchange.getRequestMethod())) {
            // Необходимо внести информацию о книге, за исключением id
            String[] pathParts = exchange.getRequestURI().getPath().split("/");
            if(pathParts.length == 5) {
                int newId = idGenerator.getAndIncrement();
                String newTitle = pathParts[2];
                String newAuthor = pathParts[3];
                double newPrice = Double.parseDouble(pathParts[4]);
                Book newBook = new Book(newId, newTitle, newAuthor, newPrice);
                books.add(newBook);
                String responseBody = objectMapper.writeValueAsString(newBook);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(201, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        } else if ("PUT".equals(exchange.getRequestMethod())){
            // Необходимо внести id и всю информацию по книге с обновлением
            String[] pathParts = exchange.getRequestURI().getPath().split("/");
            if(pathParts.length == 6) {
                int bookId = Integer.parseInt(pathParts[2]);
                String newTitle = pathParts[3];
                String newAuthor = pathParts[4];
                double newPrice = Double.parseDouble(pathParts[5]);
                for (Book book : books) {
                    book.setTitle(newTitle);
                    book.setAuthor(newAuthor);
                    book.setPrice(newPrice);
                    String responseBody = objectMapper.writeValueAsString(book);
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(201, responseBody.length());
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBody.getBytes());
                    }
                }
            }
        }
        else if ("DELETE".equals(exchange.getRequestMethod())) {
            String[] pathParts = exchange.getRequestURI().getPath().split("/");
            if (pathParts.length == 3) {
                int bookId = Integer.parseInt(pathParts[2]);
                books.removeIf(book -> book.getId() == bookId);
                String responseBody = "{\"message\":\"Book with ID " + bookId + " removed.\"}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseBody.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBody.getBytes());
                }
            }
        } else {
            String responseBody = "{\"error\":\"Method not allowed\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(405, responseBody.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(responseBody.getBytes());
            }
        }
    }
}
