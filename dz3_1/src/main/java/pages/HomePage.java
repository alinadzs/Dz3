package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement searchField = $("#ss");
    private final SelenideElement checkInDate = $("[data-placeholder='Дата заезда']");
    private final SelenideElement checkOutDate = $("[data-placeholder='Дата отъезда']");
    private final SelenideElement searchButton = $(".sb-searchbox__button");

    public HomePage openPage() { // Переименуйте метод, чтобы избежать конфликта
        open("https://www.booking.com/");
        return this;
    }

    public HomePage setCity(String city) {
        searchField.setValue(city);
        return this;
    }

    public HomePage setRandomDates() {
        checkInDate.click();
        $("[data-date='2024-12-20']").click(); // Замените на генерацию случайных дат
        $("[data-date='2024-12-25']").click();
        return this;
    }

    public SearchResultsPage clickSearch() {
        searchButton.click();
        return new SearchResultsPage();
    }
}
