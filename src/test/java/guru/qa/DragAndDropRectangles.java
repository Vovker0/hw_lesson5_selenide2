package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropRectangles {

    @Test
    void dragAndDropRectanglesWithActions() {

        // Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перенесите прямоугольник А на место В
        actions().moveToElement($("#column-a")).clickAndHold().
                moveToElement($("#column-b")).release().perform();

        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropRectanglesWithMethod() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        // В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
    }
}
