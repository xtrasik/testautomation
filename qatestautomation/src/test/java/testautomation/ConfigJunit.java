package testautomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class ConfigJunit {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\n***************BeforeClass*****************\n\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\n***************AfterClass*****************\n\n");
    }

}
