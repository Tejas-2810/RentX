package com.rentx.controller;

import com.rentx.businessservices.FurnitureService;
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


    public class FurnitureControllerTest {

        @InjectMocks
        private FurnitureController furnitureController;

        @Mock
        private FurnitureService furnitureService;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
            furnitureController = new FurnitureController();
            furnitureController.setFurnitureService(furnitureService);
        }

        @Test
        public void testGetAllFurnitureCategoryDetails() {
            List<Furniture> furnitureList = new ArrayList<>();
            furnitureList.add(new Furniture("Study Table", "Express 99"));
            furnitureList.add(new Furniture("table", "Table Home"));
            when(furnitureService.getAllFurnitureDetails()).thenReturn(furnitureList);

            List<Furniture> result = furnitureController.getAllFurnitureCategoryDetails();

            assertEquals(furnitureList, result);
            verify(furnitureService, times(1)).getAllFurnitureDetails();
        }


        @Test
        public void testAddFurnitureProductDetails() {
            Furniture furniture = new Furniture("cupboard", "office");
            when(furnitureService.addFurniture(furniture)).thenReturn(furniture);

            Furniture result = furnitureController.addFurnitureProductDetails(furniture);

            assertEquals(furniture, result);
            verify(furnitureService, times(1)).addFurniture(furniture);
        }

        @Test
        public void testGetFurnitureProductDetailsById() {
            Furniture furniture = new Furniture("stool", "Ramesh Furnitures");
            furniture.setFurnitureID(6);
            when(furnitureService.getFurnitureDetailsById(6)).thenReturn(furniture);

            ResponseEntity<Furniture> result = furnitureController.getFurnitureProductDetailsById(6);

            assertEquals(HttpStatus.OK, result.getStatusCode());
            assertEquals(furniture, result.getBody());
            verify(furnitureService, times(1)).getFurnitureDetailsById(6);
        }

        @Test
        public void testGetFurnitureProductDetailsByType() {
            List<Furniture> furnitureList = new ArrayList<>();
            furnitureList.add(new Furniture("Chair", "FW home"));
            furnitureList.add(new Furniture("Sofa", "Furniture home"));
            when(furnitureService.getFurnitureDetailsByType("Sofa")).thenReturn(furnitureList);

            List<Furniture> result = furnitureController.getFurnitureProductDetailsByType("Sofa");

            assertEquals(furnitureList, result);
            verify(furnitureService, times(1)).getFurnitureDetailsByType("Sofa");
        }

}