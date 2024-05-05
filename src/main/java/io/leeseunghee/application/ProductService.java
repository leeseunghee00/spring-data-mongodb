package io.leeseunghee.application;

import io.leeseunghee.application.dto.ProductRequest;
import io.leeseunghee.persistence.Product;
import io.leeseunghee.persistence.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(final ProductRequest request) {

        final Product product = new Product(request.name(), request.description());

        return  productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(final String id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void deleteProduct(final String id) throws Exception {
        final Product product = productRepository.findById(id)
                .orElseThrow(Exception::new);

        productRepository.delete(product);
    }
}
