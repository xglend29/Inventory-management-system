package service;

import dto.ProductRequest;
import entity.Product;

import java.util.List;

public interface ProductService {
        void createProduct(ProductRequest request);
        List<Product> notifyForLowStock();
}
