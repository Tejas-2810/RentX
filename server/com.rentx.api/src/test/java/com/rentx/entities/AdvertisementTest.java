package com.rentx.entities;

import com.rentx.entities.Advertisement;
import com.rentx.entities.ProductReal;
import com.rentx.entities.User;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AdvertisementTest {

    @Test
    public void testNoArgsConstructor() {
        //arrange
        Advertisement advertisement = new Advertisement();

        //act and assert
        assertNotNull(advertisement);
    }

    @Test
    public void testAllArgsConstructor() {
        //arrange
        User user = new User();
        ProductReal product = new ProductReal();

        //act
        Advertisement advertisement = new Advertisement(1, "Pending", "Test Advt", "Active",
                new Date(), new Date(), user, product);

        //assert
        assertNotNull(advertisement);
        assertEquals(1, advertisement.getAdvertisementID());
        assertEquals("Pending", advertisement.getVerificationStatus());
    }

    @Test
    public void testGettersAndSetters() {
        //arrange
        Advertisement advertisement = new Advertisement();

        //act
        advertisement.setAdvertisementID(1);
        advertisement.setVerificationStatus("Pending");
        advertisement.setAdvtTitle("Test Advt");
        advertisement.setIsActive("Active");
        advertisement.setPostDate(new Date());
        advertisement.setExpiryDate(new Date());
        User user = new User();
        advertisement.setUserID(user);
        ProductReal product = new ProductReal();
        advertisement.setProductID(product);

        //assert
        assertEquals(1, advertisement.getAdvertisementID());
        assertEquals("Pending", advertisement.getVerificationStatus());
        assertEquals("Test Advt", advertisement.getAdvtTitle());
        assertEquals("Active", advertisement.getIsActive());
        assertEquals(user, advertisement.getUserID());
        assertEquals(product, advertisement.getProductID());
    }

    @Test
    public void testEqualsAndHashCode() {
        //arrange
        Advertisement advertisement1 = new Advertisement(1, "Pending", "Test Advt", "Active",
                new Date(), new Date(), new User(), new ProductReal());

        //act
        Advertisement advertisement2 = new Advertisement(1, "Pending", "Test Advt", "Active",
                new Date(), new Date(), new User(), new ProductReal());

        //assert
        assertEquals(advertisement1, advertisement2);
        assertEquals(advertisement1.hashCode(), advertisement2.hashCode());
    }

    @Test
    public void testNotEquals() {
        //arrange
        Advertisement advertisement1 = new Advertisement(1, "Pending", "Test Advt", "Active",
                new Date(), new Date(), new User(), new ProductReal());

        //act
        Advertisement advertisement2 = new Advertisement(2, "Approved", "Another Advt", "Inactive",
                new Date(), new Date(), new User(), new ProductReal());

        //assert
        assertNotEquals(advertisement1, advertisement2);
        assertNotEquals(advertisement1.hashCode(), advertisement2.hashCode());
    }
}
