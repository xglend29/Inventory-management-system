package service;

import dto.OrderRequest;
import entity.Order;

public interface OrderService {
    Order create(OrderRequest orderRequest);
}
