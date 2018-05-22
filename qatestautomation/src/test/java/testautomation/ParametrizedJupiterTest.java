package testautomation;

import com.jsystems.testautomation.GamePlay;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Junit5 Parametrized")
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParametrizedJupiterTest extends ConfigJunitJupiter {

    private GamePlay gamePlay = new GamePlay();

    @Nested
    @DisplayName("Grupa Parametrized Test")
    public class JupiterParameterizedTest {

        @DisplayName("First Parametrized Test")
        @ParameterizedTest
        @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
        public void ParametrizedFirstStringParam(String tekst, int liczba) {
            System.out.println("Test na true dla phone");
            List<String> listaStringow = Arrays.asList("Hello", "JUnit 5", "Hello, JUnit 5!");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);

            assertTrue(listaStringow.contains(tekst));
            assertTrue(listaIntegerow.contains(liczba));
            assertTrue(listaIntegerow.contains(liczba));
        }

        @DisplayName("Second parametrized test")
        @ParameterizedTest
        @CsvSource({"FirstTest, 5", "SecondTest, 7", "ThirdTest, 15"})
        public void ParametrizedSecondStringParam(String tekst, int length) {
            List<String> listaStringow = Arrays.asList("FirstTest", "SecondTest", "ThirdTest");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);
            System.out.println("Test na true dla phone");

            assertFalse(listaStringow.equals(tekst));
            assertFalse(listaIntegerow.equals(length));
        }

        @DisplayName("Third parametrized test String param")
        @ParameterizedTest
        @CsvSource({"Hello", "'Hello Zbyszek 15!', 7", "Hello World, 15"})
        public void ParametrizedStringParam(String param) {

            assertTrue(param.contains("Hello"));
        }

        @DisplayName("Forth parametrized test String param")
        @ParameterizedTest
        @CsvSource({"15", "20", "25", "55"})
        public void ParametrizedIntegerParam(int param) {

            assertTrue(param % 5 == 0);
        }

         @DisplayName("Fifth parametrized test String and integer param")
        @ParameterizedTest
        @CsvSource({"Hello, 7", "SecondTest, 10", "Hello World, 15"})
        public void ParametrizedMixedParam(String param1, int param2) {

            assertTrue((param1.contains("Hello"))||(param2 % 5 == 0));
        }

        @DisplayName("Sixth parametrized test resources from file")
        @ParameterizedTest
        @CsvFileSource(resources = "/testInput.csv")
        public void ParametrizedInputFromFile(String param1, int param2) {

            assertTrue((param1.contains("Hello"))||(param2 % 5 == 0));
        }

        @DisplayName("Seventh parametrized test resources from Value Source")
        @ParameterizedTest
        @ValueSource(strings = {"Hello, 7", "SecondTest, 10", "Hello World, 15"})
        public void ParametrizedInputFromValueSource(String param1) {

            assertTrue(param1 instanceof String);
        }

        @Test
        @DisplayName("Test sprawdzajacy rzucanie exceptionow")
        public void exceptionTest() {
            assertThrows(IllegalArgumentException.class,
                    () -> {
                        gamePlay.play(0);
                    });
        }

    }
}
