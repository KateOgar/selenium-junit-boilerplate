package matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class IsElementClickable extends TypeSafeMatcher<WebElement> {

    @Override
    protected boolean matchesSafely(WebElement element) {
        return Boolean.parseBoolean(element.getAttribute("clickable"));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.format("element not clickable"));
    }
}
