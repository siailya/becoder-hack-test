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
    //public static enum_bad_pronoun enum_bad;



    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver107.exe");
        driver = new ChromeDriver();
        page=new Page(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://javarush.ru/");
    }
    @AfterClass
    public static void clean() {
        driver.close();
    }

    @Test
    public void textTest(){
        String stroka= "o";
        String [] goodPronoun={"я", "мы", "меня", "нас", "нами", "мне ","нам", "мной",
 "Я", "Мы", "Меня", "Нас", "Нами", "Мне ","Нам", "Мной"};
        String [] badPronoun ={"ты", "вы", "тебя", "вас", "тебе", "вам",
                "тобой", "вами", "он", "оно", "она", "они",
                "ее", "их", "её", "ему", "ей", "им", "его",
                "ею", "ими", "нем", "нём", "ней", "них", "Ты", "Вы", "Тебя",
                "Вас", "Тебе", "Вам",
                "Тобой", "Вами", "Он", "Оно", "Она", "Они",
                "Ее", "Их", "Её", "Ему", "Ей", "Им", "Его",
                "Ею", "Ими", "Нем", "Нём", "Ней", "Них"};
        //page.AcceptClick();
        stroka=page.getText();

        String[] strokaArray = stroka.split("\\r?\\n");
        String[] allWords = stroka.toLowerCase().split("\\s+");
        //System.out.println(stroka);
        int count=0;
        int sadCount=0;
        for (String word : allWords) {
            if (Arrays.asList(goodPronoun).contains(word)) {
                count++;
            } else if (Arrays.asList(badPronoun).contains(word)) {
                sadCount++;
            }
        }
        /*or (String item : strokaArray) {
            //System.out.println(item);
             String []  textArray = item.split(" ");
             for(int i=0; i<textArray.length; i++){
                 int countgood=0;
                 int countbad=0;
                 for (int j=0; j<goodPronoun.length;j++){
                     if (textArray[i].equals(goodPronoun[j])){
                         countgood+=1;
                         break;
                     }
                 }
                 if (countgood==0){
                     for (int j=0; j<badPronoun.length; j++){
                         if (textArray[i].equals(badPronoun[j])){
                             countbad+=1;
                             break;
                         }
                     }
                 }
                 sadCount+=countbad;
                 count+=countgood;
             }
        }*/
        System.out.println(count);
        System.out.println(sadCount);

    }
    /*public static boolean findPronoun(String stroka){
        stroka.toLowerCase();

        String [] strokaArray=stroka.split(" ");
        int bad_pronoun=0;
        int good_pronoun =0;
        for(int i=0; i<stroka.length(); i++){

        }

    }*/

}

