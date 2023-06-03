package org.Pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PageBase {

      AndroidDriver driver;



    //create constructor
    public PageBase(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

        // methods that can we use it in project

    //create method for click button
    public void clickbutton(WebElement element){

        element.click();

    }

    //method for scroll to element in list

    public void scrollto(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

    }

    public void checkelementbytext(  String text , String valueexpected){

        String checke = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+text+"']")).getText();
        Assert.assertEquals(checke, valueexpected);
    }





    // methods we can use it in future project (unused methods in my project )



    // method for LongPress on button
    public void LongPress(WebElement ele){

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)ele).getId(),"duration",3000));

    }


    // method for scroll to element
    public void ScrollToAction() throws InterruptedException {

        // scroll by Google Engine way
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
        Thread.sleep(1000);

    }


    // method to Swipe to element

    public void SwipeToAction(WebElement focus) {

        ((JavascriptExecutor) driver).executeScript("mobile:  swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)focus).getId(),
                "direction", "left",
                "percent", 0.73
        ));

    }


    //method to Drag&Drop element to another element

    public void DragDropAction( WebElement source) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 641,
                "endY", 544
        ));


    }









}
