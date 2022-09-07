package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    private static final String REPOSITORY = "IrinaRiz/Algorithms";

    @Step("Open the main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Searching repository " + REPOSITORY )
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Clicking on repository's link " + REPOSITORY)
    public void clickOnRepository(String repo){
        $(linkText("IrinaRiz/Algorithms")).click();

    }

    @Step("Checking tab Issues is showing up on repository page " + REPOSITORY)
    public void checkVisibilityOfTabIssues(){
        $("#issues-tab").should((Condition.visible));
    }
}
