package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class SearchPageObject extends CorePageObject {
    protected static String
            SEARCH_INPUT_FIELD,
            NO_SEARCH_RESULTS,
            SEARCH_RESULTS_TITLES;

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void sendKeysToSearchInputField(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_INPUT_FIELD, searchText);
    }

    public void isSearchResultsPresent() {
        this.waitForElementNotPresent(NO_SEARCH_RESULTS);
    }

    public List<WebElement> getResultsTitles() {
        return this.getElements(SEARCH_RESULTS_TITLES);
    }
}
