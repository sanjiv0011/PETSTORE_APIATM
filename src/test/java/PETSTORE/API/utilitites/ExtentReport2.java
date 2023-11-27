package PETSTORE.API.utilitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport2 implements ITestListener {

    public static ExtentSparkReporter htmlReporter; // Use ExtentHtmlReporter
    public static ExtentReports extentReports;
   // public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static ExtentTest extentTest;

    String repName;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + repName);
        htmlReporter.config().setDocumentTitle("Rest Assured Automation Project");
        htmlReporter.config().setReportName("Pet Store Users APIs");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Application name", "Pet Store Users APIs");
        extentReports.setSystemInfo("User name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User", "Sanjiv");
    }
    
    public void onTestStart(ITestResult result) {
    	extentTest = extentReports.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.createNode(result.getName());
        
        extentTest.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.createNode(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.createNode(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.SKIP, "Test Skipped");
        extentTest.log(Status.SKIP, result.getThrowable().getMessage());
    }


    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
    
    public static void logPassDetails(String log) {
    	extentTest.pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    
    public static void logFailDetails(String log) {
    	extentTest.fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    	
    }
    
    public static void logSkipDetails(String log) {
    	extentTest.skip(MarkupHelper.createLabel(log, ExtentColor.CYAN));
    	
    }
    
    public static void logWarningDetails(String log) {
    	extentTest.warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    	
    }
    
    public static void logInfoDetails(String log) {
    	extentTest.info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    	
    }
    
    public static void logJson(String json) {
    	extentTest.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    	
    }
}
