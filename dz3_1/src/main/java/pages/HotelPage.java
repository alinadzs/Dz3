package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage {

    private final SelenideElement hotelName = $("//div/h2[@data-testid='header-title'][1]"); // Название отеля
    private final SelenideElement hotelStars = $("//div/span[@data-testid='rating-squares'][1]"); // Блок звезд
    private final SelenideElement hotelRating = $("//ul/li[./a[@data-testid='property-list-map-card']][1]//div[contains(text(),'Оценка')][1]"); // Средняя оценка
    private final SelenideElement hotelReviews = $("//ul/li[./a[@data-testid='property-list-map-card']][1]//div[contains(text(),'отзыв')][1]"); // Количество отзывов
    private final SelenideElement hotelPrice = $("//div/span[@data-testid='price-and-discounted-price'][1]"); // Цена

    public void verifyHotelData(Map<String, String> expectedData) {
        hotelName.shouldHave(Condition.text(expectedData.get("name")));
        hotelStars.shouldHave(Condition.attribute("aria-label", expectedData.get("stars")));
        hotelRating.shouldHave(Condition.text(expectedData.get("rating")));
        hotelReviews.shouldHave(Condition.text(expectedData.get("reviews")));
        hotelPrice.shouldHave(Condition.text(expectedData.get("price")));
    }
}
