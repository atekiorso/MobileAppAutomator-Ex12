package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INPUT_FIELD = "id:org.wikipedia:id/search_src_text";
        NO_SEARCH_RESULTS = "id:org.wikipedia:id/search_empty_text";
        SEARCH_RESULTS_TITLES = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";
    }

    public AndroidSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
