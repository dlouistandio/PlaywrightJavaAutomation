package PageObjects;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountPage {
    private final Page createAccountPage;
    private static final String FIRST_NAME = "//input[@id='firstName']";
    private static final String LAST_NAME = "//input[@id='lastName']";
    private static final String EMAIL = "//input[@id='email']";
    private static final String PASSWORD = "//input[@id='fld-p1']";
    private static final String CONFIRM_PASSWORD = "//input[@id='reenterPassword']";
    private static final String VALIDATION_MESSAGE = ".c-input-error-message";
    private static final String PHONE_NUMBER = ".c-input-error-message";
    private static final String RECOVERY_PHONE_CHECKBOX = "//input[@id='is-recovery-phone']";
    private static final String SUBMIT_BUTTON = ".c-button-secondary";


    public CreateAccountPage(Page page){
        this.createAccountPage = page;
    }

    public void createAccount(){
        createAccountPage.locator(FIRST_NAME).fill("First Name");
        createAccountPage.locator(LAST_NAME).fill("Last Name");
        createAccountPage.locator(EMAIL).fill("emailtest@gmail.com");
        createAccountPage.locator(PASSWORD).fill("password123");
        createAccountPage.locator(CONFIRM_PASSWORD).fill("password123");

        assertThat(createAccountPage.locator(VALIDATION_MESSAGE)).containsText("Your passwords match!");

        createAccountPage.locator(PHONE_NUMBER).fill("098318667265");
        createAccountPage.locator(RECOVERY_PHONE_CHECKBOX).check();

        assertThat(createAccountPage.locator(SUBMIT_BUTTON)).isEnabled();
    }
}
