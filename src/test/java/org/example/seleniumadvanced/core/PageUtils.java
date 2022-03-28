package org.example.seleniumadvanced.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class PageUtils {
    private PageUtils() {
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void write(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    public static void select(Select select, String value) {
        select.selectByValue(value);
    }
}
