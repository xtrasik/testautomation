package testautomation;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest {

    @Test
    public void firstTest(){

        String stringtestowy = "firstTest";
       // assertTrue ( true) ;
        assertTrue(stringtestowy.equalsIgnoreCase("firstTest"));

    }

    @Test
    public void secondTest(){
        assertEquals ( true, true) ;
    }

}
