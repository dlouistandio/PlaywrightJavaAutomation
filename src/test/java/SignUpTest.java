import PageObjects.AccountEntries;
import Utils.EnvironmentReaderUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignUpTest extends PlaywrightRunner{

    @Test
    public void signUpTest(){
        page.navigate(getProperty("url"));
        accountNavigationPage.navigateTo(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.createAccount();
    }
}
