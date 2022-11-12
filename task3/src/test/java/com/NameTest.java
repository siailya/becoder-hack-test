package com;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameTest {
    public static WebDriver driver;
    public static Page page;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver107.exe");
        driver = new ChromeDriver();
        page = new Page(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        TODO: Запросить какой сайт протестить (либо вынести в конфиг какой-нибудь, хз)
        driver.get("https://yandex.ru");
    }

    @AfterClass
    public static void clean() {
        driver.close();
    }

    @Test
    public void textTest() {
        String stroka;

        String[] goodPronoun = {
                "я", "мы", "меня", "нас", "нами", "мне ", "нам", "мной"
        };
        String[] badPronoun = {
                "ты", "вы", "тебя", "вас", "тебе", "вам",
                "тобой", "вами", "он", "оно", "она", "они",
                "ее", "их", "её", "ему", "ей", "им", "его",
                "ею", "ими", "нем", "нём", "ней", "них"
        };

        stroka = page.getText();
        String[] allWords = stroka.toLowerCase().split("\\s+");

        int count = 0;
        int sadCount = 0;

        for (String word : allWords) {
            if (Arrays.asList(goodPronoun).contains(word)) {
                count++;
            } else if (Arrays.asList(badPronoun).contains(word)) {
                sadCount++;
            }
        }

//        TODO: Валить тест если sadCount > count
//        TODO: Красивый вывод (хотя бы подписать при выводе где кол-во 1-го лица, а где остальные)
        System.out.println(count);
        System.out.println(sadCount);
    }
}

