package io.leeseunghee.web;

import io.leeseunghee.application.ProductService;
import io.leeseunghee.application.dto.ProductRequest;
import io.leeseunghee.persistence.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody final ProductRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") final String id) {

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") final String id) throws Exception {
        productService.deleteProduct(id);

        return ResponseEntity.ok("Success");
    }

}
