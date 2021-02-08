import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsPinidae {

    Pinidae testTree;

    @Before
    public void setData() {
        testTree = new Pinidae();
    }

    @After

    @Test
    public void verifyGetGrowthEnvironment() {

        Assertions.assertEquals("mountain", testTree.getGrowthEnvironment());

    }

    @Test
    public void verifySetOxygenProduction() {

        int expectedOxigenProduction = 15;
        testTree.setOxygenProduction(expectedOxigenProduction);
        Assertions.assertEquals(expectedOxigenProduction, testTree.oxygenProduction);


    }
}


