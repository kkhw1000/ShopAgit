package com.hanul.shop.ShopAgit.order;

import org.aspectj.weaver.ast.Or;

/*
- PROCESSING → ORDERED, CANCELED 전환 가능
- ORDERED → CANCELED, DELIVERED 전환 가능
- CANCELED, DELIVERED → 종단 상태 (추가 전환 불가)
 */
public enum OrderStatus {

    // 진행 중: 주문 완료(ORDERED) 또는 주문 취소(CANCELED)로 전환 가능
    PROCESSING() {
        @Override
        public boolean canChangeStatus(OrderStatus nextStatus) {
            return nextStatus == ORDERED || nextStatus == CANCELED;
        }
    },

    // 주문 완료: 취소(CANCELED) 또는 배송 완료(DELIVERED)로 전환 가능
    ORDERED() {
        @Override
        public boolean canChangeStatus(OrderStatus nextStatus) {
            return nextStatus == CANCELED ||  nextStatus == DELIVERED;
        }
    },

    // 주문 취소: 다음 단계 없음. 종단 상태.
    CANCELED() {
        @Override
        public boolean canChangeStatus(OrderStatus nextStatus) {
            return false;
        }
    },

    // 배송 완료: 다음 단계 없음. 종단 상태.
    DELIVERED() {
        //다음 단계 없음. 종단 상태.
        @Override
        public boolean canChangeStatus(OrderStatus nextStatus) {
            return false;
        }
    };

    public abstract boolean canChangeStatus(OrderStatus nextStatus);
}
