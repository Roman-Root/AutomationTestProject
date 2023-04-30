//package myPackage;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Table {
//    private WebDriver tableElement;
//    private WebDriver driver;
//
//    public Table(WebDriver tableElement, WebDriver driver) {
//        this.tableElement = tableElement;
//        this.driver = driver;
//
//    }
//
//
//
//    public List<WebElement> getRows() {
//        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
//        rows.remove(0);
//        return rows;
//    }
//
//    public List<WebElement> getHeadaring() {
//        WebElement headingRow = tableElement.findElement(By.xpath(".//tr[1]"));
//        List<WebElement> headingColums = headingRow.findElements(By.xpath(".//th"));
//        return headingColums;
//    }
//
//    public List<List<WebElement>> getRowsWitchColums() {
//        List<WebElement> rows = getRows();
//        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
//        for (WebElement row : rows) {
//            List<WebElement> rowsWithColumn = row.findElements(By.xpath(".//td"));
//            rowsWithColumns.add(rowsWithColumn);
//        }
//        return rowsWithColumns;
//
//    }
//
//    public List<Map<String, WebElement>> getRowsWithColumnsByHeading() {
//        List<List<WebElement>> rowsWithColumns = getRowsWitchColums();
//        List<Map<String, WebElement>> rowsWithColumnsByHeading = new ArrayList<Map<String, WebElement>>();
//        Map<String, WebElement> rowByHeadings;
//        List<WebElement> headingColumns = getHeadaring();
//
//        for (List<WebElement> row : rowsWithColumns){
//            rowByHeadings = new HashMap<String, WebElement>();
//            for (int i = 0; i < headingColumns.size(); i++) {
//                String heading = headingColumns.get(i).getText();
//                WebElement cell = row.get(i);
//                rowByHeadings.put(heading, cell);
//
//            }
//            rowsWithColumnsByHeading.add(rowByHeadings);
//        }
//        return rowsWithColumnsByHeading;
//    }
//
//
//    public String getValueFromSell ( int rowNumber, int columnNumber){
//        List<List<WebElement>> rowsWithColumns = getRowsWitchColums();
//        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
//        return cell.getText();
//    }
//
//    public String getValueFromSell ( int rowNumber, String columnName){
//        List<Map<String, WebElement>> rowsWithColumnsByHeading = getRowsWithColumnsByHeading();
//        return rowsWithColumnsByHeading.get(rowNumber -1).get(columnName).getText();
//    }
//    //driver.get("https://www.w3schools.com/html/html_tables.asp");
//    //WebElement tableElement = driver.findElement(By.xpath("//*[@id='customers']//"));
//}
