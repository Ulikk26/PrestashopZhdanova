package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {

    String label;
    String inputPattern = "//label[contains (text(),'%s')]// following-sibling:: input";

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Write '{}' into {}", text, label);
        $(By.xpath(String.format(inputPattern, label))).sendKeys(text);
    }
}