package com.jm.arquitetura_serverless.services_businessrule;


import com.jm.arquitetura_serverless.domain.category.Category;
import com.jm.arquitetura_serverless.domain.category.CategoryDTO;
import com.jm.arquitetura_serverless.domain.category.exceptions.CategoryNotFoundExeption;
import com.jm.arquitetura_serverless.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData){
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;

    }

    public Category update(String id, CategoryDTO categoryData){
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundExeption::new);

        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.repository.save(category);

        return category;

    }

    public void delete(String id){
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundExeption::new);

        this.repository.delete(category);

    }

    public List<Category> getAll(){
        return this.repository.findAll();
    }

    public Optional<Category> getById(String id){

        return this.repository.findById(id);
    }

}
