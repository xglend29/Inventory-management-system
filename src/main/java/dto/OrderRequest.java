package dto;

import entity.OrderStatusEnum;
import entity.PaymentStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private Long clientId;
    private PaymentStatusEnum paymentStatus;
    List<OrderItemsRequest> orderItemsRequestList = new ArrayList<>();

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<OrderItemsRequest> getOrderItemsRequestList() {
        return orderItemsRequestList;
    }

    public void setOrderItemsRequestList(List<OrderItemsRequest> orderItemsRequestList) {
        this.orderItemsRequestList = orderItemsRequestList;
    }
}
