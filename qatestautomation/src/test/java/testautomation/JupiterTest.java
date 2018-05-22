package testautomation;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

@DisplayName("Test Junit5 Jupiter")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JupiterTest extends ConfigJunit {
    String stringtestowy = "secondTest";

    @BeforeEach
    public void setUp() {
        System.out.println("***************Before*****************\n");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("***************After*****************\n");
    }

    @Tag("Repeated")
    @Tag("All")
    @Test
    @DisplayName("Test Asercji - Junit5")
    @RepeatedTest(2)
    public void dJupiterJunitAssertTest() {

        System.out.println("***************Junit5 Jupiter API*****************\n");
        System.out.println("***************Test asercji*****************\n");

        assertTrue(true == true);
        assertTrue(stringtestowy.equalsIgnoreCase("secondTest"));
        assertTrue("message from assertTrue", 5 == 2 + 3);
        assertFalse("message from assertFalse", 5 == 4 + 3);
        assertFalse("message from assertFalse", stringtestowy.equals("Adam"));
        assertThat(stringtestowy, is("secondTest"));
        assertThat(stringtestowy, is("secondTest"));
        assertThat(stringtestowy, containsString("second"));

        System.out.println("Wynik dzialania 0.2*0.2 = ");
        System.out.println(0.2 * 0.2);
        assertFalse(0.2 * 0.2 == 0.04);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
        assertEquals(true, true);

    }



    @Nested
    @DisplayName("Nested Jupiter Test Class")
    public class NestedJupiterClass {
        @Tag("All")
        @Test
        @DisplayName("Nested Test Asercji - Junit5")
        public void eJupiterJunitListAssertTest() {

            System.out.println("***************Test kolekcji*****************\n");
            List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
            List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
            List<String> list3 = Arrays.asList("Ewa", "Adam", "Iwona", "Tomek", "Robert");
            List<String> list4 = Arrays.asList("Ewa", "Adam", "Iwona");
            List<String> list5 = new ArrayList<>();

            assertArrayEquals(list1.toArray(), list2.toArray());
            assertThat(list2.size(), is(5));
            assertThat(list1, hasSize(5));
            assertThat(list1, containsInAnyOrder(3, 2, 1, 4, 5));
            assertThat(list2, hasItem(1));
            assertThat(list5, IsEmptyCollection.empty());
            assertThat(list4, not(IsEmptyCollection.empty()));
            assertTrue("testzawartosci", list3.containsAll(list4));
            assertTrue(list4.contains("Ewa"));

        }

        @Tag("All")
        @Test
        @DisplayName("Nested Test RegExpow - Junit5")
        public void fJupiterJunitRegExpAssertTest() {
            System.out.println("***************Test RegExpow*****************\n");
            assertThat(stringtestowy, matchesPattern("^second.*"));
            assertThat("123456789", matchesPattern("^[0-9]+"));
        }
    }

    @Tag("All")
    @Test
    @DisplayName("Root Test RegExpow - Junit5")
    public void gJupiterJunitRegExpAssertTest() {
        System.out.println("***************Test RegExpow*****************\n");
        assertThat(stringtestowy, matchesPattern("^second.*"));
        assertThat("123456789", matchesPattern("^[0-9]+"));
    }


}
