package org.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HybridApp extends PageBase{
    //create automatic super constructor
    public HybridApp(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

 // method to switch from mobile to web in mobile application
  public void switchtoweb() throws InterruptedException {

      // switch from native app to web browser by  method called contexthandles
      Set<String> contexts = driver.getContextHandles();
      for (String contextname : contexts) {
          System.out.println(contextname);
      }

      driver.context("WEBVIEW_com.androidsample.generalstore");
      Thread.sleep(1000);
      driver.findElement(By.name("q")).sendKeys("amazon");
      Thread.sleep(2000);
      driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
      Thread.sleep(2000);
      driver.findElement(By.className("yIn8Od")).click();
      Thread.sleep(5000);
      driver.pressKey(new KeyEvent(AndroidKey.BACK));
      Thread.sleep(2000);
  }

    // switch from web browser to native app
  public void switchtomobile(){

      driver.context("NATIVE_APP");
  }

}
