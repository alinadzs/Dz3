package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage {

    private final SelenideElement hotelName = $(".hp__hotel-name"); // Название отеля
    private final SelenideElement hotelStars = $(".bui-rating__stars"); // Блок звезд
    private final SelenideElement hotelRating = $(".bui-review-score__badge"); // Средняя оценка
    private final SelenideElement hotelReviews = $(".bui-review-score__text"); // Количество отзывов
    private final SelenideElement hotelPrice = $(".bui-price-display__value"); // Цена

    public void verifyHotelData(Map<String, String> expectedData) {
        hotelName.shouldHave(Condition.text(expectedData.get("name"))); // Сравниваем название
        hotelStars.shouldHave(Condition.attribute("aria-label", expectedData.get("stars"))); // Сравниваем звезды
        hotelRating.shouldHave(Condition.text(expectedData.get("rating"))); // Сравниваем рейтинг
        hotelReviews.shouldHave(Condition.text(expectedData.get("reviews"))); // Сравниваем отзывы
        hotelPrice.shouldHave(Condition.text(expectedData.get("price"))); // Сравниваем стоимость
    }
}
