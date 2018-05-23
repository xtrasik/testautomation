import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class FrontendMainPageTest extends FrontendConfig{
    @Test
    @DisplayName("First UI Test of content main page")
    public void contentMainPageTest(){
        driver.get("https://wordpress.com/");
        MainPage mainPage = new MainPage(driver);
        mainPage.isContentPresent();
    }
}

