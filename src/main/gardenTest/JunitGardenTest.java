package gardenTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import garden.*;

public class JunitGardenTest {

    public static Plant plant;
    public static Pinidae pin;
    public static Orange orange;
    public static Cedar cedar;
    public static Rose rose;

@Test
@DisplayName("Plant test")
    public void basicTest1() {
    Assertions.assertNull(plant , "Verify if plant is a null object");

    Assertions.assertEquals("garden.Plant",Plant.class.getName(), "Check if the class name has been changed");
    System.out.println(Plant.class.getName());
}

@Test
@DisplayName("Pinidae test")
    public void basicTest2() {
    pin = new Pinidae();
    Assertions.assertEquals("mountain",pin.getGrowthEnvironment(),"verify the mountain message");

    pin.setGrowthEnvironment(null);
    Assertions.assertNull(pin.getGrowthEnvironment(), "verify if it.s null after set");
}

@Test
@DisplayName("Orange test")
    public void basicTest3() {
    Assertions.assertNull(orange);

    orange = new Orange();

    Assertions.assertAll(
            () -> Assertions.assertNull(orange.getTimeToHarvest()),
            () -> Assertions.assertFalse(orange.isEatable())
    );

    orange = new Orange(10,5,true,"August",50);

    Assertions.assertAll(
            () -> Assertions.assertEquals("August",orange.getTimeToHarvest()),
            () -> Assertions.assertTrue(orange.isEatable()),
            () -> Assertions.assertEquals(50, orange.getOxygenProduction())
    );
}

@Test
@DisplayName("Cedar test")
    public void basicTest4(){
    cedar = new Cedar();

    Assertions.assertFalse(cedar.isEatable());
    Assertions.assertAll(
            () -> Assertions.assertEquals("mountain and Mediterranean", cedar.getGrowthEnvironment()),
            () -> Assertions.assertNotEquals("beach and Mediterranean", cedar.getGrowthEnvironment())
    );
}

@Test
@DisplayName("Rose test")
    public void basicTest5(){
    rose = new Rose();
    Assertions.assertEquals("yellow",rose.color(), "check the color");

}
}
