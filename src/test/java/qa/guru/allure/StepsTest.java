package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "IrinaRiz/Algorithms";

    @Test
    public void testLambdaTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open("https://github.com");
        });
        step ("Searching repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();

        });
        step("Clicking on repository's link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Checking tab Issues is showing up on repository page " + REPOSITORY, () ->{
            $("#issues-tab").should((Condition.visible));
        });
    }

    @Test
    public void testAnnotationStep(){
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.checkVisibilityOfTabIssues();

    }
}
