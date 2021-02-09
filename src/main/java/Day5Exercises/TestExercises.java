package Day5Exercises;

import Day3Exercises.Cedar;
import Day3Exercises.Orange;
import Day3Exercises.Pinidae;
import Day3Exercises.Rose;
import Day4Exercises.FileHandling;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestExercises {

    private final Orange orange = new Orange(7, 3, 35);
    private final Cedar cedar = new Cedar(20);
    private final Pinidae pinidae = new Pinidae(50);
    private final Rose rose = new Rose("red", "Louis Philippe Rose", 10);

    private static final Path path = Paths.get(System.getProperty("user.dir"), "PracticeFiles");
    private static final List<String> practiceFiles = new ArrayList<>();

    private static Stream<String> getPracticeFilesJson() {

        File[] files = new File(TestExercises.path.toString()).listFiles();

        assert files != null;
        for (File file : files) {
            if (file.isFile() && FilenameUtils.getExtension(file.toString()).equals("json")) {
                practiceFiles.add(FilenameUtils.removeExtension(file.getName()));
            }
        }
        return practiceFiles.stream();
    }

    @BeforeAll
    public static void initAll() {
        Assumptions.assumeTrue(Files.exists(path), path.toString() + " not found");
    }

    @BeforeEach
    public void init() {
    }

    @Test
    @DisplayName("~(˘▾˘~)")
    public void uselessTest() {
        System.out.println("Just checking");
    }

    @Test
    @Tag("Day3Exercises")
    @DisplayName("Day3 - checkOrangeMethods")
    public void checkOrangeMethods() {

        assertAll("orange",
                () -> assertEquals("August", orange.getTimeToHarvest(),
                        "Orange - supposed to harvest on August"),
                () -> assertTrue(orange.isEatable(), "Orange - eatable"),
                () -> assertEquals("orange", orange.getFruitColor(), "Oranges are orange.")
        );
    }

    @Test
    @Tag("Day3Exercises")
    @DisplayName("Day3 - checkCedarMethods")
    public void checkCedarMethods() {
        assertAll("cedar",
                () -> assertEquals(10, cedar.getNumberOfSpecies(),
                        "The number of Cedar species is not the one expected"),
                () -> assertEquals("Mountain and Mediterranean", cedar.getGrowthEnvironment(),
                        "Cedar growth environment is not correct"),
                () -> assertFalse(cedar.isEatable(), "Cedar - not eatable")
        );
    }

    @Test
    @Tag("Day3Exercises")
    @DisplayName("Day3 - checkPinidaeMethods")
    public void checkPinidaeMethods() {
        assertAll("pinidae",
                () -> assertEquals(50, pinidae.getNumberOfSpecies(),
                        "The number of Pinidae species is not the one expected"),
                () -> assertEquals("Mountain", pinidae.getGrowthEnvironment(),
                        "Pinidae growth environment is not correct")
        );
    }

    @Test
    @Tag("Day3Exercises")
    @DisplayName("Day3 - checkRoseNoOfSpecies")
    public void checkRoseNumberOfSpecies() {
        assertEquals(150, rose.getNumberOfSpecies(),
                "The number of Rose species is not the one expected");
    }

    @Test
    @Tag("Day4Exercises")
    @DisplayName("Day4 - folderNotEmpty")
    public void folderNotEmpty() {
        assertNotEquals(0, path.toFile().length(), "Empty folder");
    }

    @ParameterizedTest()
    @MethodSource({"getPracticeFilesJson"})
    @Tag("Day4Exercises")
    @DisplayName("Day4 - checkJsonReaderIO")
    public void checkJsonReaderIO(String file) {
        assertFalse(Objects.requireNonNull(FileHandling.jsonReaderIO(file)).isEmpty(),
                "Something went wrong. Returned empty JSON object");
    }

    @AfterEach
    public void tearDown() {
    }

    @AfterAll
    public static void tearDownAll() {
    }
}
