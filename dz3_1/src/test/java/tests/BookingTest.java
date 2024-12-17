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

import java.util.Map;

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

        // Step 3: Open the map and interact with the first hotel
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.clickShowOnMap();
        test.info("Clicked on 'Show on map'");

        // Step 4: Hover over the first hotel on the map and retrieve its data
        searchResultsPage.hoverOverFirstHotelOnMap();
        Map<String, String> hotelDataFromMap = searchResultsPage.getHotelDataFromMap();
        test.info("Hotel data collected from map: " + hotelDataFromMap);

        // Step 5: Click on the first hotel on the map and verify its details on the hotel page
        HotelPage hotelPage = searchResultsPage.clickFirstHotelCardOnMap();
        test.info("Navigated to the hotel page");

        hotelPage.verifyHotelData(hotelDataFromMap);
        test.pass("Verified hotel details on the hotel page");
    }

    @AfterClass
    public void tearDown() {
        ExtentReportsManager.flushReport();
        closeWebDriver();
    }
}
