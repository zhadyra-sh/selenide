package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void andreiSolntsevShoulBeTheFirstContributor() {
        // Открыть страницу репозитория селениде
        open("https://github.com/selenide/selenide");
        //подвести мышку к первому элементу из блока Contributors
        //проверка: во всплывающем окне есть текст: Andrei Solntsev
        $("div.Layout-sidebar").$(Selectors.byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
        $$(".Popover").findBy(visible).shouldHave(Condition.text("Andrei Solntsev"));
        sleep(6000);


    }
}
