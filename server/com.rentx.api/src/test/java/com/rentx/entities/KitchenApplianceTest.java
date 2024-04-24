package com.rentx.entities;

import com.rentx.entities.Category;
import com.rentx.entities.KitchenAppliance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KitchenApplianceTest {

    @Test
    public void testNoArgsConstructor() {
        //arrange
        KitchenAppliance kitchenAppliance = new KitchenAppliance();

        //act and assert
        assertNotNull(kitchenAppliance);
    }

    @Test
    public void testAllArgsConstructor() {
        //arrange
        Category category = new Category();

        //act
        KitchenAppliance kitchenAppliance = new KitchenAppliance(1, "IKEA", "2022", "ModelX", "Refrigerator", category);

        //assert
        assertNotNull(kitchenAppliance);
        assertEquals(1, kitchenAppliance.getKitchenApplianceID());
        assertEquals("IKEA", kitchenAppliance.getManufacturer());
        assertEquals("2022", kitchenAppliance.getYearOfPurchase());
        assertEquals("ModelX", kitchenAppliance.getModelName());
        assertEquals("Refrigerator", kitchenAppliance.getApplianceType());
        assertEquals(category, kitchenAppliance.getCategoryID());
    }

    @Test
    public void testGettersAndSetters() {
        //arrange
        KitchenAppliance kitchenAppliance = new KitchenAppliance();
        Category category = new Category();

        //act
        kitchenAppliance.setKitchenApplianceID(1);
        kitchenAppliance.setManufacturer("IKEA");
        kitchenAppliance.setYearOfPurchase("2022");
        kitchenAppliance.setModelName("ModelX");
        kitchenAppliance.setApplianceType("Refrigerator");
        kitchenAppliance.setCategoryID(category);

        //assert
        assertEquals(1, kitchenAppliance.getKitchenApplianceID());
        assertEquals("IKEA", kitchenAppliance.getManufacturer());
        assertEquals("2022", kitchenAppliance.getYearOfPurchase());
        assertEquals("ModelX", kitchenAppliance.getModelName());
        assertEquals("Refrigerator", kitchenAppliance.getApplianceType());
        assertEquals(category, kitchenAppliance.getCategoryID());
    }

    @Test
    public void testNotEquals() {
        //arrange
        Category category1 = new Category();
        Category category2 = new Category();

        //act
        KitchenAppliance kitchenAppliance1 = new KitchenAppliance(1, "IKEA", "2022", "ModelX", "Refrigerator", category1);
        KitchenAppliance kitchenAppliance2 = new KitchenAppliance(2, "Samsung", "2021", "ModelY", "Oven", category2);

        //assert
        assertNotEquals(kitchenAppliance1, kitchenAppliance2);
        assertNotEquals(kitchenAppliance1.hashCode(), kitchenAppliance2.hashCode());
    }

    @Test
    void testConstructor() {
        //arrange and act
        KitchenAppliance kitchenAppliance = new KitchenAppliance(1, "Ikea", "123", "Sofa", "Refrigerator");

        //assert
        assertNotNull(kitchenAppliance);
    }
}
