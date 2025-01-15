package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RadioButton {
    String label;
    String radioButtonPattern = "//label[contains(normalize-space(.), '%s')]";

    public RadioButton(String label) {
        this.label = label;
    }

    public void select(String text) {
        log.info("Selecting '{}' into {}", text, label);
        $(By.xpath(String.format(radioButtonPattern, text))).click();
    }
}
