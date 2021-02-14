package apitests.must;

import apitests.grape.TestGrapes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class MustTest {

    public static final String MUST_API_URL = "https://endavawineapp.azurewebsites.net/must/";
    public static final String MUST_NAME = TestGrapes.GRAPE_NAME;
    public static final float MUST_VALUE = 12;
    public static final String MUST_UNIT = "Litres";
    public static final String MUST_TYPE = "Dry";

    public final Logger LOGGER = Logger.getLogger(getClass().getName());

    static MustTestMethods testMust;

    @BeforeAll
    public static void initVar(){
        testMust= new MustTestMethods(MUST_NAME,MUST_VALUE,MUST_UNIT,MUST_TYPE,MUST_API_URL);
    }

    @BeforeEach
    public void initMust(){
        testMust.getMust();
    }


    @Test
    @DisplayName("testAddMust")
    public void testAddMust(){
        int returnCode;
        testMust.addMust();
        LOGGER.info("Must added");

    }

    //Am tot incercat sa vad ce problema are, nu am gasit de ce nu merge delete, desi imi gaseste ID ok
    @Test
    @DisplayName("testDeleteMust")
    public void testDeleteMust(){
        testMust.getMust();
        testMust.deleteMust();
        LOGGER.info("Must deleted");

        testMust.isMustAvailable();
    }
}
