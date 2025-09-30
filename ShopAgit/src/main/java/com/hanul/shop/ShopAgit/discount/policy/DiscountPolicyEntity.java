package com.hanul.shop.ShopAgit.discount.policy;

import com.hanul.shop.ShopAgit.common.exception.DomainException;
import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "discount_policy_entity")
public class DiscountPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Column(nullable = false,name = "discount_value")
    private int value;

    protected DiscountPolicyEntity() {
    }

    private DiscountPolicyEntity(Product product, DiscountType discountType, int value) {
        this.discountType = discountType;
        this.product = product;
        this.value = value;
    }

    public static DiscountPolicyEntity create(Product product, DiscountType discountType, int value) {

        if (product == null ) throw new DomainException(ErrorCode.PRODUCT_NOT_FOUND);
        else if(value <= 0 ) throw new DomainException(ErrorCode.INVALID_DISCOUNT_PERCENT);

        DiscountPolicyEntity discountPolicyEntity = new DiscountPolicyEntity(product, discountType, value);
        return discountPolicyEntity;
    }


    public void linkProduct(Product product) {
        this.product = product;
    }


}
