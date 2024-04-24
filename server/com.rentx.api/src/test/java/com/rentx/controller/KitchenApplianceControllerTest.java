package com.rentx.controller;

import com.rentx.businessservices.KitchenApplianceService;
import com.rentx.entities.KitchenAppliance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class KitchenApplianceControllerTest {
    @Mock
    private KitchenApplianceService kitchenApplianceService;
    private KitchenApplianceController kitchenApplianceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kitchenApplianceController = new KitchenApplianceController();
        kitchenApplianceController.setKitchenApplianceService(kitchenApplianceService);
    }

    @Test
    void getAllKitchenApplianceDetails() {
        List<KitchenAppliance> applianceList = new ArrayList<>();
        when(kitchenApplianceService.getAllKitchenApplianceDetails()).thenReturn(applianceList);
        List<KitchenAppliance> result = kitchenApplianceController.getAllKitchenApplianceDetails();
        assertEquals(applianceList, result);
    }

    @Test
    void addKitchenAppliance() {
        KitchenAppliance kitchenAppliance = new KitchenAppliance();
        when(kitchenApplianceService.addKitchenAppliance(kitchenAppliance)).thenReturn(kitchenAppliance);
        KitchenAppliance result = kitchenApplianceController.addKitchenAppliance(kitchenAppliance);
        assertEquals(kitchenAppliance, result);
    }

    @Test
    void getKitchenApplianceDetailsById() {
        int id = 1;
        KitchenAppliance kitchenAppliance = new KitchenAppliance();
        when(kitchenApplianceService.getKitchenApplianceDetailsById(id)).thenReturn(kitchenAppliance);
        ResponseEntity<Object> result = kitchenApplianceController.getKitchenApplianceDetailsById(id);
        assertEquals(ResponseEntity.ok(kitchenAppliance), result);
    }
    
    @Test
    void getKitchenApplianceDetailsByType() {
        String type = "Oven";
        List<KitchenAppliance> applianceList = new ArrayList<>();
        when(kitchenApplianceService.getKitchenApplianceDetailsByType(type)).thenReturn(applianceList);
        List<KitchenAppliance> result = kitchenApplianceController.getKitchenApplianceDetailsByType(type);
        assertEquals(applianceList, result);
    }
}
