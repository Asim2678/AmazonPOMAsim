package AmazonPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLandingPage {

    WebDriver driver;

    public AmazonLandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By accetpt = By.xpath("//input[@id='sp-cc-accept']");
    By searchbox = By.xpath("//input[@id='twotabsearchtextbox']");
    By searchkey = By.xpath("//input[@id='nav-search-submit-button']");
    By ligibleDelivery = By.xpath("//span[contains(text(),'Eligible for free delivery')]");
    By SonyCheckbox = By.xpath("//li[@id='p_89/Sony']//i[@class='a-icon a-icon-checkbox']");
    By SonyCheckboxtick = By.xpath("//li[@id='p_89/Sony']//i[@class='a-icon a-icon-checkbox']");
    By ScreenSizebox = By.xpath("//li[@id='p_n_size_browse-bin/9591881031']//i[@class='a-icon a-icon-checkbox']");
   By ScreenSizeBoxSelected = By.xpath("//li[@id='p_n_size_browse-bin/9591881031']//i[@class='a-icon a-icon-checkbox']");
    public void acceptCookies() {
        driver.findElement(accetpt).click();
    }

    public void searchTV(String Searchparameter) {
        driver.findElement(searchbox).sendKeys(Searchparameter);
    }

    public void ClickSearch() {
        driver.findElement(searchkey).click();
    }

    public String titleText() {
        String AmzTitle = driver.getTitle();
        return AmzTitle;
    }

    public String TitleTVSearch() {
        String AmzTVSearchTitle = driver.getTitle();
        return AmzTVSearchTitle;
    }

    public void finedeligiblefor_delivery() {
        WebElement DeliveryOption = driver.findElement(ligibleDelivery);
        DeliveryOption.isDisplayed();

    }

    public void SelectSony() throws InterruptedException {

        WebElement SonyButton = driver.findElement(SonyCheckbox);
        SonyButton.click();
        Thread.sleep(2000);

        WebElement SonyButtonSelect = driver.findElement(SonyCheckboxtick);
        SonyButtonSelect.isSelected();

    }

    public void SelectPriceRange()
    {
        WebElement PriceRange = driver.findElement(By.linkText("£1,250 & above"));
        PriceRange.click();

    }

    public void SelectScreenSize() throws InterruptedException {
        WebElement ScreenSize = driver.findElement(ScreenSizebox);
        ScreenSize.click();
        Thread.sleep(2000);

        WebElement ScreenSizeSelected = driver.findElement(ScreenSizeBoxSelected);
        ScreenSizeSelected.isSelected();
        Thread.sleep(2000);
    }

    public String  TvSearchTitle ()
    {
        String TvSearchtitle = driver.getTitle();
        return TvSearchtitle;
    }


}
