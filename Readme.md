# Команда «Криминальное тестирование»  

#### Состав команды:  

Алексей - alex1976212@gmail.com  
Аня - anka98-98@mail.ru  
Илья - sia.ilya.dev@gmail.com  
Юля - jyliakuz@gmail.com   

---

### Задача 1:
Гугл Документ с решением: https://docs.google.com/document/d/1CjisPjGH6Po-C3AerLcuxrecLBsaoHQREb0c1TrRDSQ/edit?usp=sharing  

_Копия документа в формате .md и .docx находится в директории task1_

### Задача 2:
Представляет из себя автотест на python + Selenium

Для запуска необходимо установить SeleniumWebDriver и Chrome 60+:

```shell
pip install selenium
```

Для тест-кейсов использовались mock-данные, которые также представлены в папке с заданием (test2)

Для тестирования на произвольном файле с диска необходимо удалить index.html из папки задания
и запиустить программу. Будет предложено ввести полный путь до тестового файла (начиная с тома диска)

Запуск кода:

```shell
python3 main.py
```

### Задача 3:

**Адрес тестируемого сайта настраивается в файле `src/test/java/resources/conf.properties` (переменная `userURL`)**

Задача 3 выполнена в виде Java-теста с использованием JUnit и Selenium WebDriver.
Для запуска необходим JDK (просерялось на v19) и Maven (проверялось на 3.8)

Чтобы хапустить тест, необходимо последовательно выполнить следующие команды:

```shell
mvn clean
```
```shell
mvn test
```