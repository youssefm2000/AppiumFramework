package TestCases;

import data.FillFormDataReader;
import org.Pages.CartPage;
import org.Pages.FormPage;
import org.Pages.HybridApp;
import org.Pages.ProductsPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndScenarioTest extends TestBase{
    FormPage fp;
    ProductsPage pp;
    CartPage cp;

    HybridApp hp;

    // test case for form login
    @Test(priority= 1)
    public void FillForm() throws IOException, ParseException {

        // to check message error when I do not enter my name

        // String MessageErrorText =driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getText();
        //Assert.assertEquals(MessageErrorText,"Please enter your name");

        FillFormDataReader read = new FillFormDataReader();
        read.jreader();

        fp = new FormPage(driver);
        fp.scrollaction(read.countryname);
        fp.setboxtextaction(read.name);
        fp.genderaction(read.gender);
        fp.submitclickaction();



 
    }

    // test case for product page

    @Test(priority =2)
    public void Products() throws InterruptedException {

        pp = new ProductsPage(driver);
        pp.scrollto("$165.0");
        pp.addedaction(1);
        pp.scrollto("$110.0");
        pp.addedaction(0);
        Thread.sleep(2000);
        try {
            pp.cartaction();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pp.checktitlepage();

    }

    @Test(priority = 3)
    public void Cart() throws InterruptedException {
        cp = new CartPage(driver);
        cp.checkelementactionbytext("$165.0","$165.0");
        cp.checkelementactionbytext("$110.0","$110.0");
        cp.LongPressAction();
        cp.checkelementactionbytext("Terms Of Conditions","Terms Of Conditions");
        cp.closelemeentaction();
        cp.sendok();
        cp.websiteok();



    }
    @Test(priority = 4)
    public void HYBRID() throws InterruptedException {


        hp = new HybridApp(driver);

        hp.switchtoweb();
        hp.switchtomobile();



    }











}
