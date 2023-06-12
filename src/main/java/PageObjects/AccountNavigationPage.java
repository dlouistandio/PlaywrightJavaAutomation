package PageObjects;

import com.microsoft.playwright.Page;

public class AccountNavigationPage {
    private final Page accountNavigationPage;
    private static final String ACCOUNT_BUTTON = "//button[@id='account-menu-account-button']";
    private static final String ACCOUNT_LINKS = "//div[@class='account-menu']//a[text() = '%s']";

    public AccountNavigationPage(Page page){
        this.accountNavigationPage = page;
    }

    public void navigateTo(AccountEntries accountEntries){
        accountNavigationPage.locator(ACCOUNT_BUTTON).click();
        accountNavigationPage.locator(String.format(ACCOUNT_LINKS, accountEntries.getDisplayName())).click();
    }
}
