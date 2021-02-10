package JUnit5;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnitTest {

    public static int number;

    @BeforeAll
    public static void beforeAll(){
        number = 6;
    }

    @BeforeEach
    public void beforeEach(){
        number += 5;
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Run after each test");
    }

    @Test
    public void basicTest() {
        System.out.println(number);
        Assertions.assertEquals(11, number, "Message comes here");
    }

    @Test
    public void basicTest2() {
        System.out.println(number);
        Assertions.fail("Not implemented yet");
    }

    @Test
    @Disabled("basicTest3 Not Implemented yet")
    public void basicTest3() {
        System.out.println(number);
        Assertions.fail("Not implemented yet");
    }

    @Tag("APITests")
    @Test
    @DisplayName("Basic test 4.")
    public void basicTest4() {
        System.out.println(number);
        Assertions.assertEquals(11, number, "Message comes here");
    }

    @Test
    @DisplayName("Multiple Assertions")
    public void multipleAssertions() {
        Assumptions.assumeTrue(1 == 1, "Chrome version = 10");

        int[] array = {1, 2, 3};

        Assertions.assertAll(
                () -> Assertions.assertEquals(5, array[0]),
                () -> Assertions.assertEquals(6, array[1]),
                () -> Assertions.assertEquals(7, array[2])
        );

    }

    public void exception(){
        if (1 == 1)
            throw new IllegalArgumentException("IllegalArgurment");
    }

    @Test
    @DisplayName("Checking Exeptions")
    public void checkingExeptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> exception());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testParametrizat(int nr) {
        Assertions.assertEquals(1, nr);
    }

    @Nested
    class NestedClass {
        @Test
        @DisplayName("Nested Method")
        public void nestedClass() {
            Assertions.assertEquals(1, 1);
        }

        @Test
        @DisplayName("Nested Method2")
        public void nestedClass2() {
            Assertions.assertEquals(1, 1);
        }
    }

    @Test
    @DisplayName("asdasdasdtest tesadsa awea wwe")
    public void asdasdasdtestTesadsaAweaWwe() {
    }
    
    @Test
    @DisplayName("Nume de test lung. 1000000")
    public void numeDeTestLung1000000() {
        
    }
    
    @AfterAll
    public static void afterAll() {
        System.out.println("Run after tests");
    }
}
