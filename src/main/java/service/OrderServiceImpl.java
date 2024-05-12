package service;

import config.HibernateConfig;
import converter.OrderConverter;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dto.OrderRequest;
import entity.Order;
import entity.Product;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{
    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private ProductDao productDao = new ProductDaoImpl(sessionFactory);
    private OrderDao orderDao = new OrderDaoImpl(sessionFactory);
    @Override
    public Order create(OrderRequest orderRequest) {
        List<Long> productIds = orderRequest.getOrderItemsRequestList()
                .stream()
                .map(orderItemRequest -> orderItemRequest.getProductId())
                .collect(Collectors.toList());

        Map<Long, Double> mapPrice = new HashMap<>();

        List<Product> getProducts = productDao.findAllByIds(productIds);

        for (Product product: getProducts) {
            mapPrice.put(product.getId(), product.getPrice());
        }

        Order order = OrderConverter.convertOrderToEntity(orderRequest);
        order.getOrderItemsList().stream().forEach(
                orderItems -> orderItems.setSubTotal(orderItems.getQuantity()
                * mapPrice.get(orderItems.getProduct().getId()))
        );

        Double total = order.getOrderItemsList().stream().mapToDouble(
                orderItem -> orderItem.getSubTotal()
        ).sum();

        order.setTotal(total);
        return orderDao.create(order);
    }
}
