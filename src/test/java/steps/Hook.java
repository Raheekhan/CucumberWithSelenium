package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    /**
     * Define steps just like in CommonAPI for Web Automation.
     * @Before and @After Annotations are from Cucumber Dependency.
     *
     * In some classes I create an object from BaseUtil class,
     * and make a Constructor that passes BaseUtil as signature.
     * This is called Dependency Injection.
     */

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.out.println("Opening The Browser: Chrome");
        System.setProperty("webdriver.chrome.driver", "/Users/ibrahimkhan/IdeaProjects/CucumberPractice/src/test/java/driver/chromedriver");
        base.driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed()) {
            // Take Screenshot
            System.out.println(scenario.getName());
        }
        System.out.println("Closing The Browser: Chrome");
        base.driver.quit();
    }
}
