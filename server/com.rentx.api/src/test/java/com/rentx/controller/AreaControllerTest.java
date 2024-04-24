package com.rentx.controller;

import com.rentx.businessservices.interfaces.IAreaService;
import com.rentx.dtos.AreaDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AreaControllerTest {
    @Mock
    private IAreaService AreaService;

    private AreaController AreaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        AreaController = new AreaController(AreaService);
    }

    @Test
    void findAll() {
        List<AreaDto> AreaList = new ArrayList<>();

        when(AreaService.findAll()).thenReturn(AreaList);

        List<AreaDto> result = AreaController.findAll();

        assertEquals(AreaList, result);
    }
}
