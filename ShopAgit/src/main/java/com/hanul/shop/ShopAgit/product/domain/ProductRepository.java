package com.hanul.shop.ShopAgit.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository{

    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
    void deleteById(Long id);

}
