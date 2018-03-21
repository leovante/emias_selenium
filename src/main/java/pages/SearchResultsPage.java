package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void openBookFromResultsBy(String bookTitle) {
        //webDriver.findElement(By.linkText(bookTitle)).click();
        List<WebElement> books = webDriver.findElement(By.className("top"))
                .findElements(By.tagName("tr"));
        for (WebElement book : books) {
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getAttribute("title").contains(bookTitle)) {
                bookLink.click();
                break;
            }
        }
    }
}
