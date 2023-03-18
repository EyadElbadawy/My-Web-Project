package steps;

import com.nagwa.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
    @Before
    public static void runsBeforeAnyScenario(){
    }

    @After
    public static void runsAfterAnyScenario() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
