package github;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        // Открыть главную страницу GitHub
        open("https://github.com/");

        // Нажать на кнопку поиска
        $(".header-search-button").click();

        // Ввести "selenide" в поле поиска и нажать Enter
        $("#query-builder-test").setValue("selenide").pressEnter();

        // Ожидать появления списка репозиториев
        $$(".Box-sc-g0xbh4-0.eYhAUV").shouldHave(sizeGreaterThan(0));

        // Кликнуть на первый репозиторий с текстом "selenide/selenide"
        $$(".Box-sc-g0xbh4-0.eYhAUV")

                .findBy(text("selenide/selenide"))
                .$("a")
                .click();
        // Ожидание для проверки
        sleep(5000);
        //проверка слово selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
    }
}
