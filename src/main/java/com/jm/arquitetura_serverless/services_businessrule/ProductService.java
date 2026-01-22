package com.jm.arquitetura_serverless.services_businessrule;

import com.jm.arquitetura_serverless.domain.category.Category;
import com.jm.arquitetura_serverless.domain.category.CategoryDTO;
import com.jm.arquitetura_serverless.domain.category.exceptions.CategoryNotFoundExeption;
import com.jm.arquitetura_serverless.domain.product.Product;
import com.jm.arquitetura_serverless.domain.product.ProductDTO;
import com.jm.arquitetura_serverless.domain.product.exceptions.ProductNotFoundException;
import com.jm.arquitetura_serverless.repositories.CategoryRepository;
import com.jm.arquitetura_serverless.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private CategoryService categoryService;
    private ProductRepository repository;

    public ProductService(CategoryService categoryService, ProductRepository repository) {

        this.categoryService = categoryService;
        this.repository = repository;
    }

    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundExeption :: new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);

        this.repository.save(newProduct);
        return newProduct;

    }

    public Product update(String id, ProductDTO productData){
       Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

         this.categoryService.getById(productData.categoryId())
                .ifPresent(product::setCategory);

        if(!productData.title().isEmpty()) product.setTitle(productData.title());
        if(!productData.description().isEmpty()) product.setDescription(productData.description());
        if(!(productData.price() == null)) product.setPrice(productData.price());

        this.repository.save(product);

        return product;

    }

    public void delete(String id){
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(product);

    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }
}
