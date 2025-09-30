package com.hanul.shop.ShopAgit.product.application;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.ProductNotFoundException;
import com.hanul.shop.ShopAgit.discount.policy.DiscountType;
import com.hanul.shop.ShopAgit.product.domain.Product;
import com.hanul.shop.ShopAgit.product.domain.ProductRepository;
import com.hanul.shop.ShopAgit.product.presentation.DiscountInfo;
import com.hanul.shop.ShopAgit.product.presentation.ProductSummaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        log.info("새 상품 생성 성공: id={}, name={}", saved.getId(), saved.getName());
        return saved;
    }

    //TODO 이거 오히려 성능 안 좋아 질 수 도있다고 하는 글을 본것같음, 나중에 확인하기
    @Transactional(readOnly = true)
    public Product findByName(String name) {
        Product found = productRepository.findByName(name).orElseThrow(() -> new ProductNotFoundException(ErrorCode.PRODUCT_NOT_FOUND));
        log.debug("Product, name으로 찾기 : {} ", found);
        return found;
    }

    @Transactional(readOnly = true)
    public Product getProductById(long id) {
        Product productById = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(ErrorCode.PRODUCT_NOT_FOUND));
        log.debug("Product, id로 찾기 : {}", productById);
        return productById;
    }

    @Transactional(readOnly = true)
    public Page<ProductSummaryResponse> getProducts(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        Page<ProductSummaryResponse> productSummaryResponsePage = productPage.map(this::toProductSummaryResponse);
        log.debug("상품 목록 조회: page={}, size={}, totalElements={}", pageable.getPageNumber(), pageable.getPageSize(), productPage.getTotalElements());
        return productSummaryResponsePage;
    }


    private ProductSummaryResponse toProductSummaryResponse(Product product) {

        List<DiscountInfo> list = product.getPolicyEntities().stream().map
                        (policy -> DiscountInfo.builder()
                        .type(policy.getDiscountType())
                        .value(policy.getValue())
                        .build())
                .toList();

        ProductSummaryResponse dto = ProductSummaryResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .originalPrice(product.getPrice())
                .discountInfo(list)
                .discountedPrice(1000) //TODO DUMMY데이터 삽입 중 나중에 해결할 것.
                .build();

        return dto;
    }


}
