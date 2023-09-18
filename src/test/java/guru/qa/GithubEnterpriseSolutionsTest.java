package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubEnterpriseSolutionsTest {

    @BeforeAll
    static public void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void githubEnterpriseSolutionsPageTest() {

        // На главной странице GitHub
        open("/");

        // Выберите меню Solutions -> Enterprize с помощью команды hover для Solutions
        $(".HeaderMenu--logged-out").$(byText("Solutions")).
                hover().sibling(0).$(byText("Enterprise")).click();

        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $(".enterprise-deathcat").preceding(0).$("h1").
                shouldHave(text("Build like the best"));
    }
}
