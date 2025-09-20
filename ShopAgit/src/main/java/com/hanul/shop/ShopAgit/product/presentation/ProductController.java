package com.hanul.shop.ShopAgit.product.presentation;

import com.hanul.shop.ShopAgit.common.exception.ErrorCode;
import com.hanul.shop.ShopAgit.common.exception.ProductNotFoundException;
import com.hanul.shop.ShopAgit.common.response.ApiResponse;
import com.hanul.shop.ShopAgit.product.application.ProductService;
import com.hanul.shop.ShopAgit.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable long id) {
        Product productById = productService.getProductById(id);
        return ResponseEntity.ok().body(productById);
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<ProductSummaryResponse>>> findAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ProductSummaryResponse> summaryResponses = productService.getProducts(page, size);
        if (summaryResponses.isEmpty()) {
            log.info("상품 목록 조회 결과 없음 (page={}, size={})", page, size);
            return ResponseEntity.ok().body(ApiResponse.success(summaryResponses,"결과가 없습니다."));
        }
        log.info("상품 목록 조회 성공 (count={})", summaryResponses.size());
        return  ResponseEntity.ok().body(ApiResponse.success(summaryResponses,"상품 목록 조회 성공"));
    }

}
