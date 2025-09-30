package com.hanul.shop.ShopAgit.orderItem;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.order.Order;
import com.hanul.shop.ShopAgit.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;

    @Column(name = "count", nullable = false)
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    protected OrderItem() {
    }

    private OrderItem(Product product, int count) {

        this.count = count;
        this.totalPrice = product.getPrice() * count;
        this.product = product;
    }

    public static OrderItem createOrderItem(Product product, int count) {

        if (count <= 0) throw new DomainException(ErrorCode.INVALID_COUNT);
        else if (product == null) throw new DomainException(ErrorCode.PRODUCT_NOT_FOUND);
        else if (product.getPrice() <= 0) throw new DomainException(ErrorCode.INVALID_PRICE);


        return new OrderItem(product, count);
    }

    //편의 관계 메소드, 상위 비즈니스 개념 Order 에서 등록 처리.
    public void linkOrder(Order order) {
        this.order = order;
    }
}
