package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Класс для парсинга страницы браузера
public class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body")
    private WebElement textField;

    public String getText() {
        String text = textField.getText();
        return text;
    }
}
//page = https://www.weblitera.com/book/?id=205&lng=1&ch=2&l=ru