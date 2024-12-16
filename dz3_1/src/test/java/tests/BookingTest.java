package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import pages.SearchResultsPage;
import utils.ExtentReportsManager;
import com.codeborne.selenide.Configuration;

import java.util.Map; // Убедитесь, что импорт добавлен

import static com.codeborne.selenide.Selenide.*;

public class BookingTest {

    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        ExtentReportsManager.initReport();
        Configuration.timeout = 20000; // Увеличиваем таймаут для всех ожиданий до 20 секунд
    }

    @Test
    public void testBookingScenario() {
        test = ExtentReportsManager.createTest("Booking.com Automation Test");

        // Step 1: Open home page
        HomePage homePage = new HomePage().openPage();
        test.info("Opened Booking.com homepage");

        // Step 2: Search for a city and set random dates
        homePage.setCity("Paris")
                .setRandomDates()
                .clickSearch();
        test.info("Searched for city and selected random dates");

        // Step 3: Work with search results
        SearchResultsPage searchResultsPage = new SearchResultsPage();

        // Hover over first hotel and retrieve its data
        searchResultsPage.hoverOverFirstHotel();
        Map<String, String> hotelData = searchResultsPage.getFirstHotelData(); // Исправлено
        test.info("Hotel data collected: " + hotelData);

        // Step 4: Click on the corresponding map marker
        HotelPage hotelPage = searchResultsPage.clickOnMapMarker();
        test.info("Navigated to the hotel page via map marker");

        // Step 5: Verify hotel details on the hotel page
        hotelPage.verifyHotelData(hotelData);
        test.pass("Verified hotel details on the hotel page");
    }

    @AfterClass
    public void tearDown() {
        ExtentReportsManager.flushReport();
        closeWebDriver();
    }
}
