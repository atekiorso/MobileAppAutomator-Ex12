package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;

public class IosSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INPUT_FIELD = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and (following-sibling::XCUIElementTypeButton[@name='Cancel'])]";
        NO_SEARCH_RESULTS = "id:No results found";
        SEARCH_RESULTS_TITLES = "xpath://XCUIElementTypeToolbar[@name='Toolbar']/../.." +
                "/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";
    }

    public IosSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}
