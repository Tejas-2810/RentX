package com.rentx.businessservices;

import com.rentx.dataaccess.repository.FurnitureRepository;
import com.rentx.dataaccess.repository.KitchenApplianceRepository;
import com.rentx.entities.KitchenAppliance;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class KitchenApplianceServiceTest {
    @Mock
    private KitchenApplianceRepository kitchenApplianceRepository;

    @InjectMocks
    private KitchenApplianceService kitchenApplianceService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllFurnitureDetails() {
        List<KitchenAppliance> kitchenApplianceList = new ArrayList<>();
        kitchenApplianceList.add(new KitchenAppliance(1, "ikea", "2015", "QR-1", "Sofa"));
        kitchenApplianceList.add(new KitchenAppliance(2, "ikea", "2023", "QR-2", "Bed"));
        when(kitchenApplianceRepository.findAll()).thenReturn(kitchenApplianceList);

        List<KitchenAppliance> result = kitchenApplianceService.getAllKitchenApplianceDetails();

        assertEquals(kitchenApplianceList, result);
        verify(kitchenApplianceRepository, times(1)).findAll();
    }

    @Test
    public void testAddFurniture() {
        KitchenAppliance furniture = new KitchenAppliance(1, "ikea", "2015", "QR-1", "Sofa");
        when(kitchenApplianceRepository.save(furniture)).thenReturn(furniture);

        KitchenAppliance result = kitchenApplianceService.addKitchenAppliance(furniture);

        assertEquals(furniture, result);
        verify(kitchenApplianceRepository, times(1)).save(furniture);
    }

    @Test
    public void testGetFurnitureDetailsById() {
        KitchenAppliance furniture = new KitchenAppliance(1, "ikea", "2015", "QR-1", "Sofa");
        when(kitchenApplianceRepository.findById(3)).thenReturn(Optional.of(furniture));

        KitchenAppliance result = kitchenApplianceService.getKitchenApplianceDetailsById(3);

        assertEquals(furniture, result);
        verify(kitchenApplianceRepository, times(1)).findById(3);
    }

    @Test
    public void testGetFurnitureDetailsByIdNotFound() {
        when(kitchenApplianceRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> kitchenApplianceService.getKitchenApplianceDetailsById(1));
        verify(kitchenApplianceRepository, times(1)).findById(1);
    }

    @Test
    public void testGetFurnitureDetailsByType() {
        List<KitchenAppliance> kitchenApplianceList = new ArrayList<>();
        kitchenApplianceList.add(new KitchenAppliance(1, "ikea", "2015", "QR-1", "Sofa"));
        kitchenApplianceList.add(new KitchenAppliance(2, "ikea", "2023", "QR-2", "Bed"));when(kitchenApplianceRepository.findByApplianceType("WorkDesk")).thenReturn(kitchenApplianceList);
        List<KitchenAppliance> result = kitchenApplianceService.getKitchenApplianceDetailsByType("WorkDesk");

        assertEquals(kitchenApplianceList, result);
        verify(kitchenApplianceRepository, times(1)).findByApplianceType("WorkDesk");
    }
}
