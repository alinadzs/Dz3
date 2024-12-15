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

        // Step 2: Search for a city and set dates
        homePage.setCity("Paris")
                .setRandomDates()
                .clickSearch();
        test.info("Searched for city and selected random dates");

        // Step 3: Wait for search results to load
        SearchResultsPage searchResultsPage = new SearchResultsPage();
    }
}
