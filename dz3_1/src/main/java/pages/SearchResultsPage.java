package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement showOnMapButton = $("//div[@data-testid='map-trigger-with-static-map']"); // Кнопка "Показать на карте"
    private final SelenideElement firstHotelCardOnMap = $("//ul/li[./a[@data-testid='property-list-map-card']][1]"); // Первая карточка на карте
    private final SelenideElement hotelNameOnMap = firstHotelCardOnMap.$("//div/h2[@data-testid='header-title'][1]");
    private final SelenideElement hotelStarsOnMap = firstHotelCardOnMap.$("//div/span[@data-testid='rating-squares'][1]");
    private final SelenideElement hotelRatingOnMap = firstHotelCardOnMap.$("//ul/li[./a[@data-testid='property-list-map-card']][1]//div[contains(text(),'Оценка')][1]");
    private final SelenideElement hotelReviewsOnMap = firstHotelCardOnMap.$("//ul/li[./a[@data-testid='property-list-map-card']][1]//div[contains(text(),'отзыв')][1]");
    private final SelenideElement hotelPriceOnMap = firstHotelCardOnMap.$("//div/span[@data-testid='price-and-discounted-price'][1]");

    // Нажать на кнопку "Показать на карте"
    public void clickShowOnMap() {
        showOnMapButton.click();
    }

    // Навести курсор на первую карточку отеля на карте
    public void hoverOverFirstHotelOnMap() {
        firstHotelCardOnMap.hover();
    }

    // Собрать данные об отеле с карты
    public Map<String, String> getHotelDataFromMap() {
        Map<String, String> hotelData = new HashMap<>();
        hotelData.put("name", hotelNameOnMap.getText());
        hotelData.put("stars", hotelStarsOnMap.getAttribute("aria-label"));
        hotelData.put("rating", hotelRatingOnMap.getText());
        hotelData.put("reviews", hotelReviewsOnMap.getText());
        hotelData.put("price", hotelPriceOnMap.getText());
        return hotelData;
    }

    // Кликнуть на первую карточку отеля на карте
    public HotelPage clickFirstHotelCardOnMap() {
        firstHotelCardOnMap.click();
        return new HotelPage();
    }
}
