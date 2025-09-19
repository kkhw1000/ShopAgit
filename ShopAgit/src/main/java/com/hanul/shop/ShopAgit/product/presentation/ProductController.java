package com.hanul.shop.ShopAgit.product.presentation;

import com.hanul.shop.ShopAgit.product.application.ProductService;
import com.hanul.shop.ShopAgit.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable long id) {
        Product productById = productService.getProductById(id);
        return ResponseEntity.ok().body(productById);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductSummaryResponse>> findAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ProductSummaryResponse> summaryResponses = productService.getProducts(page, size);
        return  ResponseEntity.ok().body(summaryResponses);
    }

}
