package Support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "Definitions",
        plugin = {"json:src/test/resources/report/cucumber_report.json"},
        tags = "@Test",
        monochrome = true
)
public class RunTest {
    @AfterClass
    public static void finish(){
        try{
            System.out.println("Generating Report");
            String[] cmd = {"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Succesful report");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
