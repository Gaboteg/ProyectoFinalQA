package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import pages.Homepage;
import utilities.DriverManager;

import java.awt.*;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;


public class Hooks {

    Homepage homepage = new Homepage(DriverManager.getDriver().driver);

    private static ScreenRecorder screenRecorder;

    @AfterAll
    public static void afterAll(){
        DriverManager.getDriver().driver.close();
    }

    @Before
    public void beforeScenarios(Scenario scenario) throws IOException, AWTException {
        startVideoRecording();
    }

    @After
    public void afterScenarios(Scenario scenario) throws IOException, AWTException {
        stopVideoRecording();
    }

    public void startVideoRecording() throws IOException, AWTException {
        GraphicsConfiguration gconfig = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new ScreenRecorder(gconfig,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                        ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (int) (15 * 60)),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey,"black", FrameRateKey, Rational.valueOf(30)), null);
        screenRecorder.start();
    }

    public void stopVideoRecording() throws IOException, AWTException {
        screenRecorder.stop();
    }

    @After("@LogoutRequired")
    public void afterscenario(){
        homepage.clickOnUserTab();
        homepage.clickOnLogout();
    }

}
