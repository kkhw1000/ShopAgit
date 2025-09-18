package com.hanul.shop.ShopAgit.product.application;

import com.hanul.shop.ShopAgit.product.domain.Product;
import com.hanul.shop.ShopAgit.product.domain.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public Product create(String name, int price, int stock) {
        Product newProduct = Product.create(name, price, stock);
        Product saved = productRepository.save(newProduct);
        log.debug("Product 저장 성공 : {} ", saved);
        return saved;
    }

}
