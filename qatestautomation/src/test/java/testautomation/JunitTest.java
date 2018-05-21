package testautomation;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest {

    @Test
    public void firstTest(){
        assertTrue ( true) ;
    }

    @Test
    public void secondTest(){
        assertEquals ( true, true) ;
    }

}
