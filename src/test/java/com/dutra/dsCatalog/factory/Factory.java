package com.dutra.dsCatalog.factory;

import com.dutra.dsCatalog.dtos.ProductDto;
import com.dutra.dsCatalog.entities.Category;
import com.dutra.dsCatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "http://www.img.com.br", Instant.parse("2025-01-01T03:00:00Z"));
        product.getCategories().add(new Category(2L, "Electronics"));
        return product;

    }

    public static ProductDto createProductDto() {
        Product product = createProduct();
        return new ProductDto(product, product.getCategories());
    }
}
