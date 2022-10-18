package page;

import org.openqa.selenium.WebElement;

public interface Page {
    /**
     * Method return list of elements from each page, which is used to check is page loaded or not
     */
    WebElement[] getPageLoaded();
}
