package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.*;
import pages.BookingPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BookingTest {
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeAll
    static void setupReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("booking_test_report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterAll
    static void tearDownReport() {
        extent.flush();
    }

    @BeforeEach
    void setup() {
        test = extent.createTest("Booking Test");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка поиска и фильтрации на Booking.com")
    void bookingAutomationTest() {
        BookingPage bookingPage = new BookingPage();

        try {
            // Открываем сайт
            test.info("Открываем Booking.com");
            bookingPage.openPage();

            // Выполняем поиск города
            test.info("Ищем город Анталья");
            bookingPage.searchCity("Анталья");

            // Проверяем, что поиск выполнен корректно
            test.info("Проверяем, что отображается Анталья в результатах");
            bookingPage.verifySearchResult("Анталья");

            // Применяем фильтр "5 звёзд"
            test.info("Применяем фильтр '5 звёзд'");
            bookingPage.apply5StarFilter();

            // Проверяем, что все отели имеют 5 звёзд
            test.info("Проверяем, что все отели на странице имеют 5 звёзд");
            bookingPage.verifyAllHotelsAre5Stars();

            test.pass("Тест успешно выполнен!");
        } catch (Exception e) {
            test.fail("Тест провален: " + e.getMessage());
            throw e;
        }
    }
}

