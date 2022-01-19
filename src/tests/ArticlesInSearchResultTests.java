package tests;

import org.openqa.selenium.WebElement;
import utils.Platform;
import ui.*;
import ui.factories.*;

import java.util.List;

public class ArticlesInSearchResultTests extends CoreTestCase {
    private WelcomePageObject welcomePageObject;
    private MainPageObject mainPageObject;
    private SearchPageObject searchPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        welcomePageObject = WelcomePageObjectFactory.get(this.driver);
        mainPageObject = MainPageObjectFactory.get(this.driver);
        searchPageObject = SearchPageObjectFactory.get(this.driver);
    }

    public void testFirstThreeResultsTitles() throws Exception {
        final String searchText = "warcraft";
        final int expectedMinResultsCount = 3;

        // Закрываем приветственный экран
        if (Platform.getInstance().isIOS()) {
            welcomePageObject.clickSkipButton();
        }

        // Выполняем поиск и проверяем наличие результатов поиска
        mainPageObject.clickSearchField();
        searchPageObject.sendKeysToSearchInputField(searchText);
        searchPageObject.isSearchResultsPresent();

        // Проверяем, что заголовки первых трех статей в результатах поиска содержат ожидаемый текст
        List<WebElement> elements = searchPageObject.getResultsTitles();

        int resultsCount = elements.size();
        assertTrue("Результаты поиска '" + searchText + "' содержат количество статей: " + resultsCount +
                ", что меньше ожидаемых " + expectedMinResultsCount + "!",
                resultsCount >= expectedMinResultsCount);

        for (int i = 0; i < expectedMinResultsCount; i++) {
            String title = elements.get(i).getText();
            assertTrue("Заголовок статьи № " + (i + 1) + ": '" + title +
                    "' в результатах поиска не содержит ожидаемый текст: '" + searchText + "'",
                    title.toLowerCase().contains(searchText));
        }
    }
}
