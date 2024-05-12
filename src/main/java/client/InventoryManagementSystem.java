package client;

import dto.ProductRequest;
import entity.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inventory Managment Syste");
        System.out.println("1. Add product");
        System.out.println("2, Display all products");
        System.out.println("3, Notify for low stock product");
        System.out.println("4, Add category");
        System.out.println("5 display all categories");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                createProduct(sc);
                break;
            case 2:
                displayAllProduct();
        }

    }

    private static void displayAllProduct() {
    }

    public static void createProduct(Scanner scanner) {
        ProductRequest productRequest = new ProductRequest();
        System.out.println("Ju lutem fusni emrin e producktit");
        productRequest.setTitle(scanner.next());
        System.out.println("Ju lutem fusni pershkrimin e produktit");
        productRequest.setDescription(scanner.next());
        System.out.println("Ju lutem fusni ID e categorise");
        productRequest.setCategoryId(scanner.nextLong());
        System.out.println("Ju lutem fusni cmimin e produktit");
        productRequest.setPrice(scanner.nextDouble());
        System.out.println("Ju lutem fusni sasine e produktit");
        productRequest.setQuantity(scanner.nextInt());
        ProductService productService = new ProductServiceImpl();
        productService.createProduct(productRequest);
    }
}
