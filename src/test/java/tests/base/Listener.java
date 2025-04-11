package tests.base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Listener implements TestWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        LOGGER.info("Test {} - DISABLED. Reason: {}", context.getTestMethod().get().getName(), reason.orElse("No reason"));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        LOGGER.info("Test {} - PASSED", context.getTestMethod().get().getName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - ABORTED", context.getTestMethod().get().getName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - FAILED", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() +
                "_" + System.currentTimeMillis();

        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) context.getRequiredTestInstance()).driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(source, new File("build/reports/tests/" + screenshotName + ".png"));
            LOGGER.info("Screenshot saved: {}.png", screenshotName);
        } catch (IOException e) {
            LOGGER.error("Error while saving screenshot!", e);
        }
    }
}

