package testautomation;


import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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


public class JunitTest extends ConfigJunit{
    String stringtestowy = "firstTest";

    @Test
    public void aAssertTest() {

        System.out.println("***************Junit4.12*****************\n");
        System.out.println("***************Test asercji*****************\n");

        assertTrue(true == true);
        assertTrue(stringtestowy.equalsIgnoreCase("firstTest"));
        assertTrue("message from assertTrue", 5 == 2 + 3);
        assertFalse("message from assertFalse", 5 == 4 + 3);
        assertFalse("message from assertFalse", stringtestowy.equals("Adam"));
        assertThat(stringtestowy, is("firstTest"));
        assertThat(stringtestowy, is("firstTest"));
        assertThat(stringtestowy, containsString("first"));

        System.out.println("Wynik dzialania 0.2*0.2 = ");
        System.out.println(0.2 * 0.2);
        assertFalse(0.2 * 0.2 == 0.04);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
        assertEquals(true, true);

    }

    @Before
    public void setUp() {
        System.out.println("***************Before*****************\n");
    }

    @Test
    public void bListAssertTest() {
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

    @After
    public void tearDown() {
        System.out.println("***************After*****************\n");
    }

    @Test
    public void cRegExpAssertTest() {
        System.out.println("***************Test RegExpow*****************\n");
        assertThat(stringtestowy, matchesPattern("^first.*"));
        assertThat("123456789", matchesPattern("^[0-9]+"));
    }


}
