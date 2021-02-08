package day3exercises.main;

import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Or;


class Tests {

    public Cedar cedar;
    public Orange orange,orangeInit;
    public Rose rose;
    public Pinidae pinidae;

    static int oxygen,height,age;
    static String harvest;
    static boolean isEatable;


    @BeforeAll
    public static void initVariables(){
        oxygen=20;
        height = 15;
        age = 3;
        harvest="Autumn";
        isEatable=true;

    }

    @BeforeEach
    public void initClasses() {

        cedar = new Cedar(oxygen);
        orange = new Orange(oxygen);
        orangeInit = new Orange(age,height,isEatable,harvest,oxygen);
        rose = new Rose(oxygen);
        pinidae = new Pinidae(oxygen);

    }

    @Tag("Cedar")
    @Test
    @DisplayName("cedarTest")
    public void cedarTest() {

        Assertions.assertAll(
                () ->Assertions.assertEquals("Mountain and Mediterranean",cedar.getGrowthEnvironment(),"Should always be 'Mountain and Mediterranean'"),
                () ->Assertions.assertEquals(oxygen,cedar.getOxygenProduction(),"Oxygen"),
                () ->Assertions.assertEquals(false,cedar.isEatable(),"Eatable should always be false"),
                () ->Assertions.assertEquals(10,cedar.numberOfSpecies,"Species should always be 10")
        );
    }

    // For initialised orange object with oxygen
    @Tag("Orange")
    @Test
    @DisplayName("orangeTest")
    public void orangeTest(){
        Assertions.assertAll(
                () ->Assertions.assertEquals(null,orange.getTimeToHarvest(),"Should be null when initializing with oxygen"),
                () ->Assertions.assertEquals(oxygen,orange.getOxygenProduction(),"Oxygen"),
                () ->Assertions.assertEquals(true,orange.isEatable(),"Should always be true"),
                () ->Assertions.assertEquals(0,orange.getHeight(),"Should be 0 when initializing with oxygen"),
                () -> Assertions.assertEquals(0,orange.getAge(),"Should be 0 when initializing with oxygen")
        );


    }

    // For initialised orange object with oxygen, height, age, harvest, eatable
    @Tag("OrangeWithAllArguments")
    @Test
    @DisplayName("orangeTest 2")
    public void orangeTest2(){

        Assertions.assertAll(
                () ->Assertions.assertEquals(harvest,orangeInit.getTimeToHarvest(),"Harvest"),
                () ->Assertions.assertEquals(oxygen,orangeInit.getOxygenProduction(),"Oxygen"),
                () ->Assertions.assertEquals(true,orangeInit.isEatable(),"Should always be true"),
                () ->Assertions.assertEquals(height,orangeInit.getHeight(),"Height"),
                () -> Assertions.assertEquals(age,orangeInit.getAge(),"age")
        );
    }

    @Tag("RoseTest")
    @Test
    @DisplayName("roseTest")
    public void roseTest(){
        Assertions.assertAll(
                () ->Assertions.assertEquals(oxygen,rose.getOxygenProduction(),"Oxygen"),
                () ->Assertions.assertEquals(false,rose.isEatable(),"Eatable should be false")
        );
    }

    @Test
    @DisplayName("pinidaeTest")
    public void pinidaeTest(){
        Assertions.assertAll(
                () ->Assertions.assertEquals(oxygen,pinidae.getOxygenProduction(),"Oxygen"),
                () ->Assertions.assertEquals("Mountain",pinidae.getGrowthEnvironment(),"Should be Mountain")
        );
    }




}

