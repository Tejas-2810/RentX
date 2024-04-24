package com.rentx.controller;

import com.rentx.businessservices.ElectronicGadgetService;
import com.rentx.entities.ElectronicGadget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ElectronicGadgetControllerTest {
    @Mock
    private ElectronicGadgetService electronicGadgetService;

    private ElectronicGadgetController electronicGadgetControllerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        electronicGadgetControllerController = new ElectronicGadgetController();
        electronicGadgetControllerController.setElectronicGadgetService(electronicGadgetService);
    }
    @Test
    void getAllElectronicGadgetsDetails() {
        List<ElectronicGadget> gadgetList = new ArrayList<>();
        when(electronicGadgetService.getAllElectronicGadgetsDetails()).thenReturn(gadgetList);
        List<ElectronicGadget> result = electronicGadgetControllerController.getAllElectronicGadgetsDetails();
        assertEquals(gadgetList, result);
    }
    @Test
    void addElectronicGadgets() {
        ElectronicGadget electronicGadget = new ElectronicGadget();
        when(electronicGadgetService.addElectronicGadgets(electronicGadget)).thenReturn(electronicGadget);
        ElectronicGadget result = electronicGadgetControllerController.addElectronicGadgets(electronicGadget);
        assertEquals(electronicGadget, result);
    }

    @Test
    void getElectronicGadgetsDetailsById() {
        int id = 1;
        ElectronicGadget electronicGadget = new ElectronicGadget();
        when(electronicGadgetService.getElectronicGadgetsDetailsById(id)).thenReturn(electronicGadget);
        ResponseEntity<Object> result = electronicGadgetControllerController.getElectronicGadgetsDetailsById(id);
        assertEquals(ResponseEntity.ok(electronicGadget), result);
    }

    @Test
    void getElectronicGadgetsDetailsByType() {
        String type = "Phone";
        List<ElectronicGadget> gadgetList = new ArrayList<>();
        when(electronicGadgetService.getElectronicGadgetsDetailsByType(type)).thenReturn(gadgetList);
        List<ElectronicGadget> result = electronicGadgetControllerController.getElectronicGadgetsDetailsByType(type);
        assertEquals(gadgetList, result);
    }    
}
