package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Screenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open the main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Searching repository {repo}" )
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).submit();
    }

    @Step("Clicking on repository's link {repo}" )
    public void clickOnRepository(String repo){
        $(linkText(repo)).click();

    }

    @Step("Checking tab Issues is showing up on repository page" )
    public void checkVisibilityOfTabIssues(){
        $("#issues-tab").should((Condition.visible));
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte [] takeScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
