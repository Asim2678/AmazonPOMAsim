package AmazonTests;

import AmazonPO.AmazonLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SearchProduct {
    ChromeOptions chromeOptions;
    WebDriver driver;
    String appurl;

    @BeforeTest
    public void LaunchBrowser() {
        System.out.println("Launch browser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabassra.SCT\\Downloads\\Drivers\\chromedriver.exe");
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        appurl = "https://www.amazon.co.uk/";
    }

    @AfterTest
    public void CloseBrowser() {
        System.out.println("Close browser");
        driver.close();
    }

    @Test(priority = 1)
    public void OpenAmazon() throws InterruptedException {

        driver.get(appurl);

        AmazonLandingPage amz = new AmazonLandingPage(driver);
        amz.acceptCookies();
        Thread.sleep(2000);

        String expectedTitle = "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";
        String actualText = amz.titleText();

        Assert.assertEquals(expectedTitle, actualText, "Title are not matching");

    }

    @Test(priority = 2)
    public void SearchProduct() {

        AmazonLandingPage amz = new AmazonLandingPage(driver);
        amz.searchTV("TV");
        amz.ClickSearch();


        String expectedTvSearchTitle = "Amazon.co.uk : TV";
        String ActualTVSearchTitle = amz.TitleTVSearch();
        Assert.assertEquals(expectedTvSearchTitle, ActualTVSearchTitle, "TV search Title of Page does not match");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(true, true, "This is true");

        amz.finedeligiblefor_delivery();

    }

    @Test(priority = 3)
    public void SelectSonyTV() throws InterruptedException {
        AmazonLandingPage amz = new AmazonLandingPage(driver);
        amz.SelectSony();

        amz.SelectPriceRange();


        amz.SelectScreenSize();

       System.out.println(driver.getTitle());

       String expectedTvSearchTitle = "Amazon.co.uk: TV - £1,250 & Above / Sony / 70 In (177 Cm) & Above / TVs / Home Cinema, TV & Vi...: Electronics & Photo";
       String actualTvSearchTitle = amz.TvSearchTitle();
       Assert.assertEquals(expectedTvSearchTitle, actualTvSearchTitle, "Search Sony TV does not match");
    }

}
