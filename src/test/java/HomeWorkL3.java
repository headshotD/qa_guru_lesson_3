import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkL3 {
    @BeforeAll
    static void configurationBrowser() {
        Configuration.baseUrl = "https://github.com";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void SearchOnGitHubSelenide() {
        open("/selenide/selenide");
        $x("//*[@id='wiki-tab']").click();
        $x("//*[@id=\"wiki-pages-box\"]/div/div[2]/ul/li[19]/button").click();
        $x("//*[@class='Box Box--condensed color-shadow-small']").shouldHave(text("SoftAssertions"));
        $x("//*[text()='SoftAssertions']").click();
        $x("//div[@id='wiki-content']").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "void test() {\n" +
                "Configuration.assertionMode = SOFT;\n" +
                "open(\"page.html\");\n" +
                "\n" +
                "$(\"#first\").should(visible).click();\n" +
                "$(\"#second\").should(visible).click();\n" +
                "}\n" +
                "}"));


    }
}
