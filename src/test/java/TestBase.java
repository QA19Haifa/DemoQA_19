import helpers.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase implements ApplicationManager{



    @BeforeSuite
    public void setUp() throws IOException {
        init();
    }


    @AfterSuite
    public void stop(){
//        app.tearDown();
    }

}
