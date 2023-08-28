package cache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {
    public static void main(String[] args) {

        List<Product> productList = createProductList();

        ProductCache productCache = new ProductCache();

        int productId = 1;
        Product product = productCache.getProduct(productId, productList);
        System.out.println("Product from cache or list: " + product);

        product.setPrice(15.99);
        productCache.updateProduct(product, productList);

        product = productCache.getProduct(productId, productList);
        System.out.println("Updated product from cache or list: " + product);
    }

    private static List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 9.99));
        productList.add(new Product(2, "Product 2", 19.99));
        productList.add(new Product(3, "Product 3", 29.99));
        return productList;
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class ProductCache {
    private Map<Integer, Product> cache = new HashMap<>();

    public Product getProduct(int id, List<Product> productList) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            for (Product product : productList) {
                if (product.getId() == id) {
                    cache.put(id, product);
                    return product;
                }
            }
            return null;
        }
    }

    public void updateProduct(Product product, List<Product> productList) {
        cache.put(product.getId(), product);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                break;
            }
        }
    }
}
