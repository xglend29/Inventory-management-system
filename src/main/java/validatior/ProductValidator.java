package validatior;

import dto.ProductRequest;

public class ProductValidator {
    public static void validateProduct(ProductRequest request) {
        if(request.getTitle().isBlank()) {
            throw new IllegalArgumentException();
        }
        if(request.getPrice() == 0D) {
            throw new IllegalArgumentException();
        }
        if(request.getQuantity() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
