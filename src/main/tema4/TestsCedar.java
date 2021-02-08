import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class TestsCedar {

    Cedar testTree;
    @Before
    public void setData() {
         testTree = new Cedar();
    }
    @After
    @Test
    public void  verifyInitialNoOfSpecies(){
       // Cedar testTree = new Cedar();
        int expectedNoOfSpecies = 10;
        Assertions.assertEquals(expectedNoOfSpecies,testTree.getNumberOfSpecies(),"nr of species previously set to "+expectedNoOfSpecies);


    }

    @Test
    public void  verifySetNoOfSpecies(){

        testTree.setNumberOfSpecies(12);
        int expectedNoOfSpecies = 12;
        Assertions.assertEquals(expectedNoOfSpecies,testTree.getNumberOfSpecies(),"nr of species previously set to "+expectedNoOfSpecies);


    }

    @Test
    public void verifyGetGrowthEnvironment(){

        Assertions.assertEquals("mountain and Mediterranean", testTree.getGrowthEnvironment());

    }

    @Test
    public void verifyIsEatable(){

        Assertions.assertFalse(testTree.isEatable());

    }

}
