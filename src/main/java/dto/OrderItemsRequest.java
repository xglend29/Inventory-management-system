package dto;

public class OrderItemsRequest {
    public OrderItemsRequest(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    private Long productId;
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
