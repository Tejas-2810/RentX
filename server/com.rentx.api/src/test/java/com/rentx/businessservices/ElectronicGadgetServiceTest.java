package com.rentx.businessservices;

import com.rentx.dataaccess.repository.ElectronicGadgetRepository;
import com.rentx.entities.ElectronicGadget;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElectronicGadgetServiceTest {

    @Mock
    private ElectronicGadgetRepository electronicGadgetRepository;

    @InjectMocks
    private ElectronicGadgetService electronicGadgetService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAutowiredField() {
        // Assert that the @Autowired field is properly injected
        assertNotNull(electronicGadgetService);
    }

    @Test
    public void testGetAllElectronicGadgetDetails() {
        // Arrange
        List<ElectronicGadget> electronicGadgetsList = new ArrayList<>();
        electronicGadgetsList.add(new ElectronicGadget(1, "samsung", "2012", "ZL1", "mobile"));
        electronicGadgetsList.add(new ElectronicGadget(1, "sony", "2012", "ZL2", "mobile"));
        when(electronicGadgetRepository.findAll()).thenReturn(electronicGadgetsList);
        // Act
        List<ElectronicGadget> result = electronicGadgetService.getAllElectronicGadgetsDetails();
        // Assert
        assertEquals(electronicGadgetsList, result);
        verify(electronicGadgetRepository, times(1)).findAll();
    }

    @Test
    public void testAddElectronicGadget() {
        // Arrange
        ElectronicGadget electronicGadget = new ElectronicGadget(1, "sony", "2012", "ZL2", "mobile");
        when(electronicGadgetRepository.save(electronicGadget)).thenReturn(electronicGadget);
        // Act
        ElectronicGadget result = electronicGadgetService.addElectronicGadgets(electronicGadget);
        // Assert
        assertEquals(electronicGadget, result);
        verify(electronicGadgetRepository, times(1)).save(electronicGadget);
    }

    @Test
    public void testGetElectronicGadgetDetailsByIdNotFound() {
        // Arrange +  Act
        when(electronicGadgetRepository.findById(1)).thenReturn(Optional.empty());
        // Assert
        assertThrows(ResourceNotFoundException.class, () -> electronicGadgetService.getElectronicGadgetsDetailsById(1));
        verify(electronicGadgetRepository, times(1)).findById(1);
    }

    @Test
    public void testGetElectronicGadgetDetailsByType() {
        // Arrange
        List<ElectronicGadget> electronicGadgetsList = new ArrayList<>();
        electronicGadgetsList.add(new ElectronicGadget(1, "samsung", "2012", "ZL1", "mobile"));
        electronicGadgetsList.add(new ElectronicGadget(1, "sony", "2012", "ZL2", "mobile"));
        when(electronicGadgetRepository.findByGadgetType("WorkDesk")).thenReturn(electronicGadgetsList);
        // Act
        List<ElectronicGadget> result = electronicGadgetService.getElectronicGadgetsDetailsByType("WorkDesk");
        // Assert
        assertEquals(electronicGadgetsList, result);
        verify(electronicGadgetRepository, times(1)).findByGadgetType("WorkDesk");
    }




}
