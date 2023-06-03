package ReportsNG;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports extent;
    static ExtentSparkReporter reporter;

    // method for Report
    public  static ExtentReports getreporter(){

        // ExtentReports  is main class that attach to helper calss , ExtentSparkReporter is helper class
        //ExtentSparkReporter
        String path = System.getProperty("user.dir")+"//report//index.html";
        reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Mobile Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        // ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Youssef Elshemy");
        return extent;




    }

}
