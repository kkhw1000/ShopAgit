package com.hanul.shop.ShopAgit.order;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.orderItem.OrderItem;
import com.hanul.shop.ShopAgit.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
//TODO: 익셉션 생성하기.
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    protected Order() {
    }

    private Order(OrderStatus orderStatus, Member member, List<OrderItem> orderItems) {
        this.orderStatus = orderStatus;
        this.member = member;

        for (OrderItem orderItem : orderItems) {
            this.addOrderItem(orderItem);
        }

    }

    public static Order createOrder(Member member, List<OrderItem> orderItems) {

        //TODO 익셉션 생성 할 것.
        if (orderItems.isEmpty()) {
            return null;
        } else if (member == null) {
            return null;
        }
        return new Order(OrderStatus.PROCESSING, member, orderItems);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.linkOrder(this);
    }

    public void confirm() {

        OrderStatus target = OrderStatus.ORDERED;
        //TODO 익셉션 생성 할 것. ex) 주문을 완료 할수 없습니다.
        if (!this.orderStatus.canChangeStatus(target)) throw new DomainException(ErrorCode.CANNOT_CHANGE_STATUS);

        this.orderStatus = target;
    }

    public void cancel() {

        OrderStatus target = OrderStatus.CANCELED;
        //TODO 익셉션 생성 할 것. ex) 배송 완료된 주문은 취소 할 수 없습니다.
        if (!this.orderStatus.canChangeStatus(target)) { return;}

        this.orderStatus = target;
    }

    public void delivery() {

        OrderStatus target = OrderStatus.DELIVERED;
        //TODO 익셉션 생성 할 것. ex) 배송이 완료되지 않았습니다.
        if (!this.orderStatus.canChangeStatus(target)) { return;}

        this.orderStatus = target;
    }

}
