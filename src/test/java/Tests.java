import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    @BeforeAll
    static void configurationBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void closechrome() {
        closeWebDriver();
    }

    @Test
    void demoqaUploadFile() {
        open("/upload-download");
        $x("//div//input[@id='uploadFile']").uploadFromClasspath("eda.tiff");
        $x("//div//p[@id='uploadedFilePath']").shouldHave(text("eda.tiff"));

    }
    @Test
    void webTables() {
        open("/webtables");
        $x("//*[@id='addNewRecordButton']").click();
        $x("//*[@id='firstName']").setValue("Oleg");
        $x("//div//input[@id='lastName']").setValue("Olegov");
        $x("//div//input[@id='userEmail']").setValue("Oleg@mail.ru");
        $x("//div//input[@id='age']").setValue("15");
        $x("//div//input[@id='salary']").setValue("15000");
        $x("//div//input[@id='department']").setValue("Moscow");
        $x("//div//button[@id='submit']").click();
        $x("//*[@class='rt-table']").shouldHave((text("Oleg Olegov")));
        $x("//div//span[@id='delete-record-4']").click();
        $x("//div//span[@id='delete-record-4']").shouldNotBe(visible);
    }
}
