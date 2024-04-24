package com.rentx.controller;

import com.rentx.businessservices.BooksService;
import com.rentx.businessservices.FurnitureService;
import com.rentx.entities.Books;
import com.rentx.entities.Furniture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;


public class BooksControllerTest {

    @InjectMocks
    private BooksController booksController;

    @Mock
    private BooksService booksService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        booksController = new BooksController();
        booksController.setBooksService(booksService);
    }

    @Test
    public void testGetAllBooksCategoryDetails() {
        List<Books> booksList = new ArrayList<>();
        booksList.add(new Books("Sameer Jain", "2019"));
        when(booksService.getAllBooksDetails()).thenReturn(booksList);

        List<Books> result = booksController.getAllBooksCategoryDetails();

        assertEquals(booksList, result);
        verify(booksService, times(1)).getAllBooksDetails();
    }


    @Test
    public void testAddBooksProductDetails() {
        Books books = new Books("Ricky Jonathan", "2023");
        when(booksService.addBook(books)).thenReturn(books);

        Books result = booksController.addBookProductDetails(books);

        assertEquals(books, result);
        verify(booksService, times(1)).addBook(books);
    }

    @Test
    public void testGetBooksProductDetailsById() {
        Books books = new Books("", "Ramesh Furnitures");
        books.setBooksID(3);
        when(booksService.getBookDetailsById(3)).thenReturn(books);

        ResponseEntity<Books> result = booksController.getBookProductDetailsById(3);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(books, result.getBody());
        verify(booksService, times(1)).getBookDetailsById(3);
    }

    @Test
    public void testGetBooksProductDetailsByAuthor() {
        List<Books> booksList = new ArrayList<>();
        booksList.add(new Books("Jane Doe", "2020"));
        when(booksService.getBooksDetailsByAuthor("Jane Doe")).thenReturn(booksList);

        List<Books> result = booksController.getBooksProductDetailsByAuthor("Jane Doe");

        assertEquals(booksList, result);
        verify(booksService, times(1)).getBooksDetailsByAuthor("Jane Doe");
    }

}
