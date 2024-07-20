# Streamline Your Selenium Automation with Data Structures Using Java Streams
Sample Project for a Cucumber-Selenium Integrated Framework with Maven, Showcasing the Leverage of Streams to Collect WebElements When Treating Them as a Data Structure.

**Treating WebElements as Data Structures with Streams:**
When you use Java Streams, we can process collections of WebElements more efficiently and with more readable code. Here’s how using Streams can help treat WebElements as data structures:

- **Filtering Elements**: You can filter elements based on specific criteria.
- **Mapping Elements**: You can transform elements into other types or extract specific data.
- **Reducing Elements**: You can aggregate elements into a single result.
- **Processing Elements**: You can perform bulk operations on collections of elements.

## Sample Snippets
### Looking for a matching label by finding all instance of the Labels WebElement then traverses through it using filter()
```
WebElement eLabel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(componentLabel))
                .stream().filter(l -> l.getText().contains(label)).findFirst().orElse(null);
```

### Want to get all the labels as text? try using map() and return it as List<String>
```
List<String> eLabelValues = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(componentLabel))
                .stream().map(l -> l.getText()).collect(Collectors.toList());
```
to make it more concise, we can replace the Lambda expression with Method reference:
```
List<String> eLabelValues = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(componentLabel))
                .stream().map(WebElement::getText).collect(Collectors.toList());
```
