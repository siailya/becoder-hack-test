package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public WebDriver driver;
    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    @FindBy(xpath="/html/body")
    private WebElement textField;

    public String getText() {
        String text = textField.getText();
        return text;
    }

    /*@FindBy(xpath="/html/body/div[5]/div[3]/button[1]")
    private WebElement acceptbutttom;

    public void AcceptClick(){
        acceptbutttom.click();}*/
    }
//page = https://www.weblitera.com/book/?id=205&lng=1&ch=2&l=ru