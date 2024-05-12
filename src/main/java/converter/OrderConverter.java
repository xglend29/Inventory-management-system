package converter;

import dto.OrderItemsRequest;
import dto.OrderRequest;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static Order convertOrderToEntity(OrderRequest orderRequest) {
        Order order = new Order();
        order.setPaymentStatus(orderRequest.getPaymentStatus());
        order.setClient(new Client(orderRequest.getClientId()));
        order.setOrderItemsList(
                convertItemToEntity(orderRequest.getOrderItemsRequestList()));
        return order;
    }

    public static List<OrderItems> convertItemToEntity(List<OrderItemsRequest> request) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (OrderItemsRequest orderItemsRequest: request) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProduct(new Product(orderItemsRequest.getProductId()));
            orderItem.setQuantity(orderItemsRequest.getQuantity());
            orderItemsList.add(orderItem);
        }
        return orderItemsList;
    }
}
