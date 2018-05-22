package testautomation;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test Junit5 Parametrized")
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParametrizedJupiterTest extends ConfigJunitJupiter {
    @Nested
    @DisplayName("Grupa Parametrized Test")
    public class JupiterParameterizedTest {


        @DisplayName("First Parametrized Test")
        @Disabled
        @ParameterizedTest
        @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
        public void shouldPhoneIsTrue(String tekst, int liczba) {
            System.out.println("Test na true dla phone");
            List<String> listaStringow = Arrays.asList("Hello", "JUnit 5", "Hello, JUnit 5!");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);

            assertTrue(listaStringow.contains(tekst));
            assertTrue(listaIntegerow.contains(liczba));
            assertTrue(listaIntegerow.contains(liczba));
        }

        @DisplayName("Second parametrized test")
        @Disabled
        @ParameterizedTest
        @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
        public void ShouldPhoneIsFalse(String tekst, int length) {
            List<String> listaStringow = Arrays.asList("Hello", "JUnit 5", "Hello, JUnit 5!");
            List<Integer> listaIntegerow = Arrays.asList(5, 7, 15);
            System.out.println("Test na true dla phone");

            assertFalse(listaStringow.equals(tekst));
            assertFalse(listaIntegerow.equals(length));
        }
    }
}
