package com.rentx.businessservices;

import com.google.cloud.storage.*;
import com.rentx.controller.UserProfileController;
import com.rentx.dataaccess.ImageDAO;
import com.rentx.dtos.ImageDto;
import com.rentx.entities.Image;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.*;

import com.google.cloud.storage.Blob;

class ImageServiceTest {

    @InjectMocks
    ImageService imageService;

    @Mock
    Storage storage;

    @Mock
    Blob mockBlob;

    @Mock
    ImageDAO imageDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        imageService = new ImageService();
        imageService.setStorage(storage);
        imageService.setImageDAO(imageDAO);
    }

    @Test
    void downloadFileSuccess() {
        when(mockBlob.getContent()).thenReturn(new byte[1]);
        when(storage.get(any(String.class), any(String.class))).thenReturn(mockBlob);
        ByteArrayResource expected = new ByteArrayResource(mockBlob.getContent());

        ByteArrayResource res = imageService.downloadFile("bucketName", "test.jpg");

        assertEquals(expected, res);
    }

    @Test
    void uploadFileSuccess() {
        byte[] content = new byte[1];
        when(imageDAO.insert(any(Image.class))).thenReturn(new Image());
        boolean res = imageService.uploadFile("bucketName", new MockMultipartFile("name", content), 123, "test");

        assertTrue(res);
    }

    @Test
    void uploadFileFailed() {
        boolean res = imageService.uploadFile("bucketName", null, 123, "test");
        assertFalse(res);
    }

    @Test
    void get() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image());

        when(imageDAO.get(any(String.class), any(Integer.class))).thenReturn(imageList);

        List<ImageDto> images = imageService.get("test", 123);
        assertNotNull(images);
    }
}