package com.rentx.controller;

import com.rentx.businessservices.interfaces.ICategoryService;
import com.rentx.dtos.CategoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {
    @Mock
    private ICategoryService categoryService;

    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryController = new CategoryController(categoryService);
    }
    
    @Test
    void findAll() {
        List<CategoryDto> categoryList = new ArrayList<>();

        when(categoryService.findAll()).thenReturn(categoryList);

        List<CategoryDto> result = categoryController.findAll();

        assertEquals(categoryList, result);
    }

    @Test
    void getCategoryById() {
        int categoryId = 1;
        List<CategoryDto> categoryList = new ArrayList<>();

        when(categoryService.getCategoryById(categoryId)).thenReturn(categoryList);

        List<CategoryDto> result = categoryController.getAdvertisementsByUserId(categoryId);

        assertEquals(categoryList, result);
    }
}
