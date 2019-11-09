package report;

import com.relevantcodes.extentreports.ExtentReports;



public class ExtentFactory {
    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            //Set HTML reporting file location
            String path = "src\\report.html";
            extent = new ExtentReports(path, true);
        }
        return extent;
    }
}