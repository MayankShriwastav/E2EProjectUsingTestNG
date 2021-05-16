package Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtantReporter {

	static ExtentReports extent;

	public static ExtentReports getReporterObject(){
			String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Report");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);			
			extent.setSystemInfo("Tester", "Mayank Srivastava");

			return extent;
			
	}
	
}
