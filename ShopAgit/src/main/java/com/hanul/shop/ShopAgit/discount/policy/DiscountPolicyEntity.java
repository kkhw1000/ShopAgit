package com.hanul.shop.ShopAgit.discount.policy;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class DiscountPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private int value;

    protected DiscountPolicyEntity() {
    }


}
