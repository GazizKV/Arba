package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.serafim.web.dto.ProductForm;
import ru.serafim.web.services.ProductService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUpLoadProductData(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String productUpLoad(@Valid ProductForm productForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productForm", productForm);
            return "product";
        }
        productService.insertIntoDataBase(productForm);
        return "products";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts() {
        return "products";
    }
}
