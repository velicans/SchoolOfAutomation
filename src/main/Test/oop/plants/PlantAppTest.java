package oop.plants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlantAppTest {

    public Orange orange = new Orange(100, 20, 10D);
    Cedar cedarTree = new Cedar(200);
    Pinidae pinidae = new Pinidae(150);

    @Test
    @DisplayName("Orange: Object Instantiation")
    public void checkOrangeObjectInstantiation() {
        Assertions.assertAll(
                () -> assertEquals(100, orange.getOxygenProduction(), "Oxygen production should be 100"),
                () -> assertEquals(20, orange.getAge(), "Age should be 20"),
                () -> assertEquals(10D, orange.getHeight(), "Height should be 10D"));
    }

    @Test
    @DisplayName("Orange:timeToHarvest")
    public void orangeTimeToHarvestTest() {
        Assertions.assertEquals("August", orange.getTimeToHarvest(), "Orange time to harvest should be August");

    }

    @Test
    @DisplayName("Orange:isEatable")
    public void orangeIsEatableTest() {
        Assertions.assertTrue(orange.isEatable(), "Orange isEatable should be true");
    }

    @Test
    @DisplayName("Cedar: Object Instantiation")
    public void checkCedarObjectInstantiation() {
        Assertions.assertAll(
                () -> assertEquals(200, cedarTree.getOxygenProduction(), "Oxygen production should be 200"),
                () -> assertEquals(10, cedarTree.getNumberOfSpecies(), "Height should be 10"));
    }

    @Test
    @DisplayName("Cedar: GetGrowthEnvironment")
    public void cedarGetGrowthEnvironmentTest() {
        Assertions.assertEquals("mountain and Mediterranean", cedarTree.getGrowthEnvironment(),
                "Growth Environment for cedar trees should be mountain and Mediterranean");
    }

    @Test
    @DisplayName("Cedar: IsEatable")
    public void cedarIsEatableTest() {
        Assertions.assertFalse(cedarTree.isEatable(), "Cedar isEatable should be false");
    }


    @Test
    @DisplayName("Pinidae: Object Instantiation")
    public void checkPinidaeObjectInstantiation() {
        Assertions.assertAll(
                () -> assertEquals(150, pinidae.getOxygenProduction(), "Oxygen production should be 150"),
                () -> assertEquals(50, pinidae.getNumberOfSpecies(), "Height should be 50"));
    }

    @Test
    @DisplayName("Pinidae: GetGrowthEnvironment")
    public void pinidaeGetGrowthEnvironmentTest() {
        Assertions.assertEquals("mountain", pinidae.getGrowthEnvironment(),
                "Growth Environment for pinidae should be mountain");
    }


}