import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SelenideTest {

    @BeforeEach
    public void setupTest() {
        open("http://localhost:9999");
    }
    
    @Test
    void shouldDeliveryCard() {
        open("http://localhost:9999");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=city] input").setValue("Чебоксары");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys("12.12.2022");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=phone] input").setValue("+79999999999");
        form.$("[data-test-id=agreement]").click();
        form.$(byText("Забронировать")).click();
        $(byText("Успешно!"))
                .shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldDeliveryCardSecond() {
        open("http://localhost:9999");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=city] input").setValue("Воронеж");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys("15.12.2022");
        form.$("[data-test-id=name] input").setValue("Иванов-Петров Иван");
        form.$("[data-test-id=phone] input").setValue("+79999999999");
        form.$("[data-test-id=agreement]").click();
        form.$(byText("Забронировать")).click();
        $(byText("Успешно!"))
                .shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldDeliveryCardThird() {
        open("http://localhost:9999");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=city] input").setValue("Барнаул");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys("14.12.2022");
        form.$("[data-test-id=name] input").setValue("Иванов Иван Младший");
        form.$("[data-test-id=phone] input").setValue("+79999999999");
        form.$("[data-test-id=agreement]").click();
        form.$(byText("Забронировать")).click();
        $(byText("Успешно!"))
                .shouldBe(visible, Duration.ofSeconds(15));
    }


}

