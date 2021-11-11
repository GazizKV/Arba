package ru.serafim.web.services;

import ru.serafim.web.dto.ProductForm;
import ru.serafim.web.models.Product;

public interface ProductService {
    Product insertIntoDataBase(ProductForm productForm);
}
