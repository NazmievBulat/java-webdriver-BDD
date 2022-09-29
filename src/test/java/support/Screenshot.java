package support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileOutputStream;
import java.io.IOException;

import static support.TestContext.getDriver;

public interface Screenshot {
    default void takeScreenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        byte[] file = screenshot.getScreenshotAs(OutputType.BYTES);
        try (FileOutputStream stream = new FileOutputStream(System.getProperty("user.dir") +
                "/src/test/resources/data/screenshot" + TestContext.getTimestamp() + ".png")){
            stream.write(file);
            stream.flush();
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
