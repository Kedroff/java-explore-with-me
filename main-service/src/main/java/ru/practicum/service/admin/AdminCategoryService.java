package ru.practicum.service.admin;

import ru.practicum.exceptions.NotFoundException;
import ru.practicum.model.category.Category;
import ru.practicum.model.category.dto.CategoryDto;

public interface AdminCategoryService {

    public Category create(CategoryDto categoryDto);

    public Category patch(Integer id, CategoryDto categoryDto) throws NotFoundException;

    public void delete(Integer id) throws NotFoundException;
}