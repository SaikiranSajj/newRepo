package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

 public   class ExtentReporterNg {
 
	public static ExtentReports  getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\extentReport\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("standalonereport");
		reporter.config().setDocumentTitle("TestResult");
		reporter.config().setTheme(Theme.DARK);
		// explore klov afterwards;
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saikiran");
		return extent;
	}
}
