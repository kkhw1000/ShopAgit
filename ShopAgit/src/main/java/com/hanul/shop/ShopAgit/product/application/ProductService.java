package com.hanul.shop.ShopAgit.product.application;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.ProductNotFoundException;
import com.hanul.shop.ShopAgit.product.domain.Product;
import com.hanul.shop.ShopAgit.product.domain.ProductRepository;
import com.hanul.shop.ShopAgit.product.presentation.ProductSummaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //TODO 이거 오히려 성능 안 좋아 질 수 도있다고 하는 글을 본것같음, 나중에 확인하기
    @Transactional(readOnly = true)
    public Product findByName(String name) {
        Product found = productRepository.findByName(name).orElseThrow(() -> new ProductNotFoundException(ErrorCode.PRODUCT_NOTFOUND));
        log.debug("Product, name으로 찾기 : {} ", found);
        return found;
    }

    @Transactional(readOnly = true)
    public Product getProductById(long id) {
        Product productById = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(ErrorCode.PRODUCT_NOTFOUND));
        log.debug("Product, id로 찾기 : {}", productById);
        return productById;
    }

    @Transactional(readOnly = true)
    public List<ProductSummaryResponse> getProducts(int page, int size) {
        List<ProductSummaryResponse> productSummaryResponses = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        productPage.getContent().forEach(product -> {
            productSummaryResponses.add(toProductSummaryResponse(product));
        });
        return productSummaryResponses;
    }


    private ProductSummaryResponse toProductSummaryResponse(Product product) {
        ProductSummaryResponse dto = ProductSummaryResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        return dto;
    }


}
