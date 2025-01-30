import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {


public ExtentSparkReporter sparkReporter;
public ExtentReports extentReports;
public ExtentTest extentTest;



    public void onStart(ITestContext context){

        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "../resources/reports");

        sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report

        sparkReporter.config().setTheme (Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter (sparkReporter);

        extentReports.setSystemInfo("Computer Name", "localhost");
        extentReports.setSystemInfo("Environment", "QA");

        extentReports.setSystemInfo("Tester Name", "Prabhash");
        extentReports.setSystemInfo("os", "Windows11");

        extentReports.setSystemInfo("Browser name", "Chrome");
    }
    public void onTestSuccess(ITestResult result){
        extentTest = extentReports.createTest(result.getName()); // create a new  in the report
        extentTest.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
    }

    public void onTestFailure(ITestResult result){
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL, "Test case FAILED is:" + result.getName());

        extentTest.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result){
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
    }

    public void onFinish(ITestContext context){
        extentReports.flush(); // write all thing report
    }

}
