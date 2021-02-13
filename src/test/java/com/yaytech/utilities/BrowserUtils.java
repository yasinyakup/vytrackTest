package com.yaytech.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.List;

public class BrowserUtils {

    public static void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement findfirstAncorbytext(String text){
        String xpath = "(//a[.='"+text+"'])[1]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        return element;
    }


    public static Select getSelectWebElement(WebElement element){
        Select select = new Select(element);
        return select;
    }

    public static WebElement getSelected(Select select){
        return select.getFirstSelectedOption();
    }

    public  List<WebElement> getColumnDataByHead(String tableXPath, String columnHeaderName){
        if (!Driver.getDriver().findElement(By.xpath(tableXPath)).getTagName().toLowerCase().equals("table")){
            throw new UnexpectedTagNameException("table", Driver.getDriver().findElement(By.xpath(tableXPath)).getTagName());
        }
        List<WebElement> headers = Driver.getDriver().findElements(By.xpath(tableXPath+"/thead/tr/th"));
        System.out.println(headers.size());
        headers.forEach(head-> System.out.println(head.getText()));
        List<WebElement> columnData = null;
        for (int i=0 ; i<headers.size(); i++) {
            if(columnHeaderName.equals(headers.get(i).getText())){

               columnData = Driver.getDriver().findElements(By.xpath(tableXPath+"/tbody/tr/td["+(i+1)+"]"));

            }
        }
        return columnData;
    }
}
