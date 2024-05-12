package client;

import dto.OrderItemsRequest;
import dto.OrderRequest;
import entity.PaymentStatusEnum;
import service.OrderService;
import service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Na ljepni detajet per krijimin e order");

        System.out.println("Ju lutem fusni client id tuaj");
        Long clientId = sc.nextLong();
        System.out.println("Ju lutem fusni payemt status");
        String payementStatus = sc.next();
        List<OrderItemsRequest> orderItemsRequestList = new ArrayList<>();
        int c;
        do {
            System.out.println("Ju lutem fusni product ID, fusni product id = 300 kur ");
            Long productId = sc.nextLong();
            System.out.println("Ju lutem fusni sasine per kte product");
            Integer quantity = sc.nextInt();
            OrderItemsRequest orderItemsRequest =
                    new OrderItemsRequest(productId, quantity);
            orderItemsRequestList.add(orderItemsRequest);
            System.out.println("Ju lutem shtypni 1 per te vazhduar te shtoni produkte" +
                    " dhe 0 nese lista e produkteve eshte plotesuar ");
            c = sc.nextInt();
        } while (c != 0);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setClientId(clientId);
        orderRequest.setOrderItemsRequestList(orderItemsRequestList);
        orderRequest.setPaymentStatus(PaymentStatusEnum.valueOf(payementStatus));
        OrderService orderService = new OrderServiceImpl();
        orderService.create(orderRequest);
    }
}
