package testautomation;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJunitJupiter {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\n***************BeforeClass*****************\n\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\n***************AfterClass*****************\n\n");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("***************Before*****************\n");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("***************After*****************\n");
    }
}
