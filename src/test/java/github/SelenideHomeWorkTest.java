package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHomeWorkTest {
    @Test
    void openWikiTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$("a").findBy(Condition.text("Soft assertions")).click();
        $("div.markdown-body").shouldHave(Condition.text("JUnit5"));

    }
}
