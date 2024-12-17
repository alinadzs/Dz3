package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BookingPage {
    private SelenideElement searchInput = $("input[name='ss']");
    private SelenideElement searchButton = $("button[type='submit']");
    private SelenideElement filter5Stars = $x("//div[@data-filters-group='class']//div[@data-filters-item='class:class=5']");
    private SelenideElement destinationHeader = $x("//div/input['value="Анталья"']");
    private ElementsCollection hotelStars = $$x("//div[contains(@aria-label, '5 из 5')]");
    private ElementsCollection hotelCards = $$x("//div[@data-testid='property-card']");

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
        // Получаем коллекцию всех карточек отелей на странице
        //ElementsCollection hotelCards = $$x("//div[@data-testid='property-card']");

        // Проверяем, что есть хотя бы одна карточка отеля
        hotelCards.shouldHave(sizeGreaterThan(0));

        // Проверяем, что у всех карточек есть элемент "5 из 5 звезд"
        hotelStars.shouldHave(size(hotelCards.size()));

        return this;
    }
}

