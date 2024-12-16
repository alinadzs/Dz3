package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement firstHotelCard = $("[data-testid='property-card']:first-child"); // Первая карточка отеля
    private final SelenideElement hotelName = firstHotelCard.$("[data-testid='title']");
    private final SelenideElement hotelStars = firstHotelCard.$(".bui-rating__stars");
    private final SelenideElement hotelRating = firstHotelCard.$(".bui-review-score__badge");
    private final SelenideElement hotelReviews = firstHotelCard.$(".bui-review-score__text");
    private final SelenideElement hotelPrice = firstHotelCard.$(".bui-price-display__value");

    // Навести курсор на первый отель
    public void hoverOverFirstHotel() {
        firstHotelCard.hover(); // Наводим курсор на первую карточку отеля
    }

    // Собрать данные о первом отеле в карту
    public Map<String, String> getFirstHotelData() {
        Map<String, String> hotelData = new HashMap<>();
        hotelData.put("name", hotelName.getText());
        hotelData.put("stars", hotelStars.getAttribute("aria-label")); // Считываем звезды через атрибут
        hotelData.put("rating", hotelRating.getText());
        hotelData.put("reviews", hotelReviews.getText());
        hotelData.put("price", hotelPrice.getText());
        return hotelData; // Возвращаем карту с данными отеля
    }

    // Клик по маркеру карты для первого отеля
    public HotelPage clickOnMapMarker() {
        $("[data-testid='map-trigger']").click(); // Клик по кнопке "Показать на карте"
        return new HotelPage();
    }
}
