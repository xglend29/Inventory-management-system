package converter;

import dto.ProductRequest;
import entity.Category;
import entity.Product;

public class ProductConverter {
    public static Product convertRequestToEntity(ProductRequest request) {
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setCategory(new Category(request.getCategoryId()));
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setTitle(request.getTitle());

        return product;
    }
}
