package org.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends PageBase{




    //craete  automatic super constructor
    public ProductsPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Find elements  by AndroidFindBy annotation
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement cartelement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    List<WebElement> addtocart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$165.0']")
    WebElement priceelement1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$110.0']")
    WebElement priceelement2;





    //1- create method to add elemets to cart
    public void addedaction(int index){

        addtocart.get(index).click();

    }

   //2-create method to click on cart button

    public void cartaction() throws InterruptedException {

        cartelement.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

  public void checktitlepage() throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
      // for performance
      Thread.sleep(2000);

  }






}
