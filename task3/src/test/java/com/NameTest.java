package com;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class NameTest {
    public static WebDriver driver;
    public static Page page;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("pathToChromeDriver"));
        driver = new ChromeDriver();
        page = new Page(driver);
        //Адрес страницы для тестирования прописывается в переменную userURL в resource/conf.properties
        driver.get(ConfProperties.getProperty("userURL"));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void clean() {
        driver.close();
    }

    @Test
    public void textTest() {
        String line;

        String[] goodPronoun = {
                "я", "мы", "меня", "нас", "нами", "мне ", "нам", "мной"
        };
        String[] badPronoun = {
                "ты", "вы", "тебя", "вас", "тебе", "вам",
                "тобой", "вами", "он", "оно", "она", "они",
                "ее", "их", "её", "ему", "ей", "им", "его",
                "ею", "ими", "нем", "нём", "ней", "них"
        };

        line = page.getText();
        String[] allWords = line.toLowerCase().split("\\s+");

        int count = 0;
        int sadCount = 0;

        for (String word : allWords) {
            if (Arrays.asList(goodPronoun).contains(word)) {
                count++;
            } else if (Arrays.asList(badPronoun).contains(word)) {
                sadCount++;
            }
        }
        // Проверка кол-ва местоимений на сайте
        if (sadCount > count) {  //Тест валится в том случае, если местоимений 2 и 3 лица больше местоимений 1 лица
            Assert.fail("\nTest Failed\n" +
                    "Number of personal pronouns of 1-person: " + count + "\n" +
                    "Number of personal pronouns of 2 & 3 person: " + sadCount);
        } else { //Тест пройден, если местоимений 1 лица больше местоимений 2 и 3 лица
            System.out.println("Test passed");
            System.out.println("Number of personal pronouns of 1-person: " + count);
            System.out.println("Number of personal pronouns of 2 & 3 person: " + sadCount);
        }
    }
}

