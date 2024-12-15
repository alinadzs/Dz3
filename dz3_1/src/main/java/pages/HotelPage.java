package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HotelPage {

    private final SelenideElement hotelName = $("h2.hp__hotel-name");
    private final SelenideElement stars = $(".bui-review-score__title");
    private final SelenideElement rating = $(".bui-review-score__badge");
    private final SelenideElement reviews = $(".bui-review-score__text");
    private final SelenideElement price = $(".bui-price-display__value");

    public String getHotelName() {
        return hotelName.getText().trim();
    }

    public String getStars() {
        return stars.getText().trim();
    }

    public String getRating() {
        return rating.getText().trim();
    }

    public String getReviews() {
        return reviews.getText().trim();
    }

    public String getPrice() {
        return price.getText().trim();
    }


}
