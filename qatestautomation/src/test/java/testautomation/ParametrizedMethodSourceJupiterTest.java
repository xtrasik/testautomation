package testautomation;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

@DisplayName("Test Junit5 Parametrized MethodSource")
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParametrizedMethodSourceJupiterTest extends ConfigJunitJupiter {

    @ParameterizedTest
    @DisplayName("Root of Parametrized Tests")
    @MethodSource("generateData")
    void shouldGetDataBit(int first, String second, List<String> third) {
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(1, "foo", Arrays.asList("a", "b", "c")),
                Arguments.of(2, "bar", Arrays.asList("x", "y", "z"))
        );
    }

    @DisplayName("Parametrized Display name")
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
    @CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
    void testWithCustomDisplayNames(String first, int second) {
    }
}
