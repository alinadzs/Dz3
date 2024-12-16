package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private final SelenideElement searchField = $("input[name='ss']");
    private SelenideElement searchButton = $("button[type='submit']");

    public HomePage openPage() {
        open("https://booking.com/");
        return this;
    }

    public HomePage setCity(String city) {
        searchField.setValue(city);
        return this;
    }

    public HomePage setRandomDates() {
        LocalDate today = LocalDate.now();
        Random random = new Random();

        LocalDate checkIn = today.plusDays(random.nextInt(30) + 1); // Случайная дата в пределах месяца
        LocalDate checkOut = checkIn.plusDays(random.nextInt(5) + 1); // От 1 до 5 ночей

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        searchButton.click();
        $("[data-date='" + checkIn.format(formatter) + "']").click();
        $("[data-date='" + checkOut.format(formatter) + "']").click();

        return this;
    }

    public HomePage clickSearch() {
        searchButton.click();
        return this;
    }
}
