package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.ProductForm;
import ru.serafim.web.models.Product;
import ru.serafim.web.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product insertIntoDataBase(ProductForm productForm) {
        Product product = Product.builder()
                .name(productForm.getName())
                .produceDate(productForm.getDate())
                .winNumber(productForm.getVin())
                .mass(productForm.getMass())
                .build();
        productRepository.save(product);

        return product;
    }
}
