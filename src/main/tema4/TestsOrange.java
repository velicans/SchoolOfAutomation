import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestsOrange {

    Orange testTree;
    @Before
    public void setData() {
         testTree = new Orange();
    }
    @After
    @Test
    public void  verifyGetTimeToHarvest(){
         Assertions.assertEquals("August",testTree.getTimeToHarvest());

    }

    @Test
    public void  verifySetOxygenProduction(){

        int expectedOxigenProduction =15;
        testTree.setOxygenProduction(expectedOxigenProduction);
        Assertions.assertEquals(expectedOxigenProduction,testTree.oxygenProduction);


    }

    @Test
    public void verifySetAge(){
        int expectedAge = 5;
        testTree.setAge(expectedAge);

        Assertions.assertEquals(expectedAge, testTree.age);

    }

    @Test
    public void verifyIsEatable(){
//test should fail;
        Assertions.assertFalse(testTree.isEatable());

    }

}
