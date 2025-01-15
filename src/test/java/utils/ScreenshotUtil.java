package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    @Attachment(value = "{screenshotName}", type = "image/png")
    public static byte[] attachScreenshot(String screenshotName) {
        File screenshot = Screenshots.takeScreenShotAsFile();
        if (screenshot != null && screenshot.exists()) {
            try {
                return Files.readAllBytes(screenshot.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }
}