package pages;

import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {

    private final SelenideElement showOnMapButton = $("[data-testid='map-trigger']");

    public SearchResultsPage clickShowOnMap() {
        showOnMapButton.click();
        return this;
    }

    public SelenideElement getFirstHotelCard() {
        return $$("[data-testid='property-card']").first();
    }



    public String selectFirstHotel() {
        return $(".sr_property_block .hotel_name_link").getText(); // Возвращаем название первого отеля
    }
}

