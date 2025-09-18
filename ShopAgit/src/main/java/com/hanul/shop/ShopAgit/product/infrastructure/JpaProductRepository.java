package com.hanul.shop.ShopAgit.product.infrastructure;

import com.hanul.shop.ShopAgit.product.domain.Product;
import com.hanul.shop.ShopAgit.product.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, Long> {


}
