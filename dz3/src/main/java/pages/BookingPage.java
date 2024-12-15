package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*; // добавляем правильный импорт

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BookingPage {
    private SelenideElement searchInput = $("input[name='ss']");
    private SelenideElement searchButton = $("button[type='submit']");
    private SelenideElement filter5Stars = $x("//div[@data-filters-group='class']//label[contains(., '5 звезд')]");
    private SelenideElement destinationHeader = $x("//h1[contains(text(),'Анталья')]");
    private ElementsCollection hotelStars = $$x("//span[contains(@aria-label, '5 звезд')]");

    public BookingPage openPage() {
        open("https://booking.com/");
        return this;
    }

    public BookingPage searchCity(String city) {
        searchInput.setValue(city);
        searchButton.click();
        return this;
    }

    public BookingPage verifySearchResult(String city) {
        destinationHeader.shouldHave(text(city));
        return this;
    }

    public BookingPage apply5StarFilter() {
        filter5Stars.scrollIntoView(true).click();
        return this;
    }

    public BookingPage verifyAllHotelsAre5Stars() {
        // исправленный код
        hotelStars.shouldHave(sizeGreaterThan(0)); // проверяем, что коллекция отелей не пустая
        hotelStars.forEach(star -> star.shouldBe(visible)); // проверяем, что каждый отель имеет 5 звезд
        return this;
    }
}
