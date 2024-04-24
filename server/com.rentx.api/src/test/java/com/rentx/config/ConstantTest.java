package com.rentx.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantTest {
    Constant constantValue = new Constant();
    @Test
    public void testKitchenApplianceCategoryId() {
        assertEquals(11, Constant.KITCHEN_APPLIANCE_CATEGORY_ID);
    }

    @Test
    public void testFurnitureCategoryId() {
        assertEquals(12, Constant.FURNITURE_CATEGORY_ID);
    }

    @Test
    public void testBooksCategoryId() {
        assertEquals(13, Constant.BOOKS_CATEGORY_ID);
    }

    @Test
    public void testElectronicGadgetCategoryId() {
        assertEquals(14, Constant.ELECTRONIC_GADGET_CATEGORY_ID);
    }
}
