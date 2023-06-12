import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TryTest extends PlaywrightRunner{

    @Test
    public void firstTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        Page page = browserContext.newPage();

        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        Locator menuItem = page.locator("//ul[@class='bottom-nav-left lv']/li/a");
        menuItem.allTextContents();

        for(int i = 0; i < menuItem.count(); i++){
            page.locator("//ul[@class='bottom-nav-left lv']/li/a", new Page.LocatorOptions().setHasText("Credit Cards")).click();
        }

    }
}
