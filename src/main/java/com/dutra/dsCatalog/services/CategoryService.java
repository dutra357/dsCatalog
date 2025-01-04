package com.dutra.dsCatalog.services;

import com.dutra.dsCatalog.dtos.CategoryDto;
import com.dutra.dsCatalog.repositories.CategoryRepository;
import com.dutra.dsCatalog.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(category -> new CategoryDto(category)).toList();
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        return new CategoryDto(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category not found!")
        ));
    }
}
