package cucumbersprout.webpage.components;

import cucumbersprout.webpage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridComponent extends BasePage {

    public GridComponent(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By table = By.cssSelector("div#GridFrow2.awe-grid.awe-hh.awe-ltr");
    private final By tableColumnHeaderNames = By.cssSelector("tbody.awe-hrow > tr > td > div.awe-col");
    private final By tableRow = By.cssSelector("tr[data-g].awe-row:not(.awe-nonselect)");
    private final By tableFooter = By.cssSelector("div.awe-footer");
    private final By componentLabel = By.cssSelector("div.example > h2");
    private final By commentsAccordion = By.cssSelector("div.clear > span.tgCmnts");

    public void PrintCellAndColumn(String rowId){
        System.out.println("Input Id number: " + rowId);
        MergeTableHeaderAndRow(rowId).forEach((key, value) -> System.out.println(key + ": " + value.getText()));
    }

    public WebElement ScrollToElement(String label){
        WebElement commentAccordion = wait.until(ExpectedConditions.presenceOfElementLocated(commentsAccordion));
        ScrollIntoView(commentAccordion);

        WebElement eLabel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(componentLabel))
                .stream().filter(l -> l.getText().contains(label)).findFirst().orElse(null);

        return MoveToElement(eLabel);
    }

    public WebElement ScrollToRow(String rowId){
        WebElement row = MoveToElement(driver.findElement(table))
                .findElements(tableRow)
                .stream()
                .filter(e -> e.getAttribute("data-k").equals(rowId)).findAny().get();

        return MoveToElement(row);
    }

    private Map<String, WebElement> MergeTableHeaderAndRow(String rowId){
        List<String> columnNames = driver.findElement(table)
                .findElements(tableColumnHeaderNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<WebElement> rowCells = ScrollToRow(rowId)
                .findElements(By.cssSelector("td"));

        return IntStream.range(0, columnNames.size()).boxed()
                .collect(Collectors.toMap(columnNames::get, rowCells::get, (x, y) -> y, LinkedHashMap::new));
    }

}
