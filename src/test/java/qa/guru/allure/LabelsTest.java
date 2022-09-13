package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    private static final String REPOSITORY = "IrinaRiz/Algorithms";

    @Test
    @Feature("Issue in repository")
    @Story("Issue tab")
    @Owner("IR")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "WebTest", url = "https://github.com")
    @DisplayName("Check if Issue is showing up on repository page")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Issue should be visible on repository page")
        );
        Allure.feature("Issue in repository");
        Allure.story("Issue tab");
        Allure.label("owner", "IR");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
