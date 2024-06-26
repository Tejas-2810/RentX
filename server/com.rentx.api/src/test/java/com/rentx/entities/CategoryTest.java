package com.rentx.entities;

import com.rentx.entities.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testNoArgsConstructor() {
        //arrange
        Category category = new Category();

        //act and assert
        assertNotNull(category);
    }

    @Test
    public void testAllArgsConstructor() {
        //arrange
        Category category = new Category(1, "Electronics");

        //act and assert
        assertNotNull(category);
        assertEquals(1, category.getCategoryID());
        assertEquals("Electronics", category.getName());
    }

    @Test
    public void testGettersAndSetters() {
        //arrange
        Category category = new Category();

        //act
        category.setCategoryID(1);
        category.setName("Books");

        //assert
        assertEquals(1, category.getCategoryID());
        assertEquals("Books", category.getName());
    }

    @Test
    public void testNotEquals() {
        //arrange
        Category category1 = new Category(1, "Electronics");

        //act
        Category category2 = new Category(2, "Books");

        //assert
        assertNotEquals(category1, category2);
        assertNotEquals(category1.hashCode(), category2.hashCode());
    }
}
