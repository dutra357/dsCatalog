package com.dutra.dsCatalog.services;

import com.dutra.dsCatalog.dtos.CategoryDto;
import com.dutra.dsCatalog.entities.Category;
import com.dutra.dsCatalog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(category -> new CategoryDto(category)).toList();
    }
}
