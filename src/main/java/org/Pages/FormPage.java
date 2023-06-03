package org.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends PageBase{
     //create automatic super constructor
    public FormPage(AndroidDriver driver) {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    //1-Find Elements by AnndroidFindBy annotation


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Afghanistan']")
    WebElement countryselect;

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    WebElement namefield;

    @AndroidFindBy(id ="com.androidsample.generalstore:id/radioMale")
    WebElement maleoption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    WebElement femaleoption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    WebElement login;


    // 1-craete method to scrolling action

    public void scrollaction(String countryname){
        countryselect.click();
        scrollto(countryname);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+countryname+"']")).click();


    }

    //2-create method for settextbox action
    public void setboxtextaction( String value ){
        setboxtext(value);

    }
      //3- create method for select genderaction
    public void genderaction(String gendervalue){

        if (gendervalue.contains("female"))
            femaleoption.click();
       else
           maleoption.click();


    }

    //4-craete method for submit click
    public void submitclickaction(){

        clickbutton(login);

    }



    // other Methods

    //create method for choice  between two gender




    //create method setboxtext for send keys
    public void setboxtext(  String value){
       namefield.sendKeys(value);

    }










}
