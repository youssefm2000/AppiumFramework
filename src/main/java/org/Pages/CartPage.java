package org.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PageBase{
    PageBase js = new PageBase(driver);
    //create automatic super constructor
    public CartPage(AndroidDriver driver) {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id ="com.androidsample.generalstore:id/termsButton")
    WebElement presselement;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement cartpage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$110.0']")
    WebElement priceelement2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$165.0']")
    WebElement priceelement1;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CLOSE']")
    WebElement closelement;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
    WebElement sendeemail;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    WebElement gotowebsite;




    // 1-create method for Long press action

    public void LongPressAction(){
        js.LongPress(presselement);

    }


   //2-create method for check element by text
   public void checkelementactionbytext( String textlele , String valeele){
       js.checkelementbytext(textlele,valeele);

   }

   //3- craete method for check element in cart page by id





   public void closelemeentaction(){

        clickbutton(closelement);
   }

   public void sendok(){

        clickbutton(sendeemail);
   }

   public void websiteok() throws InterruptedException {

        clickbutton(gotowebsite);
       Thread.sleep(5000);
   }


}
