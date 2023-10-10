package cucumbersprout.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridComp extends BasePage{

    public GridComp(WebDriver driver) {
        super(driver);
    }

    private final By header = By.cssSelector("div.conthead > h1.fgrow");
    private final By table = By.cssSelector("div#Grid1.awe-grid.awe-hh.awe-ltr");
    private final By tableColumnHeaderNames = By.cssSelector("tbody.awe-hrow > tr > td >div");
    private final By tableRow = By.cssSelector("tr[data-g].awe-row");

    public void PrintCellAndColumn(String rowId){
        System.out.println("Input Id number: " + rowId);
        MergeTableHeaderAndRow(rowId).forEach((key, value) -> System.out.println(key + ": " + value.getText()));
    }

    public List<String> GetTableRowCells(String rowId){
        return MergeTableHeaderAndRow(rowId)
                .values()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement ScrollToRow(String rowId){
        WebElement row = ScrollIntoView(driver.findElement(table))
                .findElements(tableRow)
                .stream()
                .filter(e -> e.getAttribute("data-k").equals(rowId)).findAny().get();

        return ScrollIntoView(row);
    }

    private WebElement GetTableRow(String rowId){
        return ScrollToRow(rowId);
    }

    private Map<String, WebElement> MergeTableHeaderAndRow(String rowId){
        List<String> columnNames = driver.findElement(table)
                .findElements(tableColumnHeaderNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<WebElement> rowCells = GetTableRow(rowId)
                .findElements(By.cssSelector("td"));

        return IntStream.range(0, columnNames.size()).boxed()
                .collect(Collectors.toMap(columnNames::get, rowCells::get));
    }

    //TODO: introduce wait
    public String CheckIfPageLoaded(){
        return driver.findElement(header).getText();
    }
}
