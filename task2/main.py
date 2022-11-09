import pathlib
from os import listdir
from os.path import isfile, join

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color


# Устанавливает состояние для stylesheet по его имени (включает/выключает)
def get_script_to_toggle_stylesheet(stylesheet_href, disabled):
    return f'''
const stylesheet = document.querySelector('link[rel=stylesheet][href$="{stylesheet_href}"]')
console.log('{stylesheet_href}', stylesheet)
if (stylesheet) {{
    stylesheet.disabled = {disabled}
}}
'''


# JS-скрипт для отключения всех ненужных stylesheet (все кроме header.css)
disable_foreign_stylesheets = '''
const foreign_stylesheets = document.querySelectorAll('link[rel=stylesheet]:not([href$="header.css"])')
Array.from(foreign_stylesheets).forEach(s => {
    s.disabled = true
})
'''

# Список для "плохих" stylesheets, меняющих цвет заголовка
foreign_stylesheets = []

current_dir = pathlib.Path(__file__).parent.resolve()
current_dir_files = list(
    filter(lambda f: f[-5:] == '.html', [f for f in listdir(current_dir) if isfile(join(current_dir, f))]))

if len(current_dir_files) >= 2 or len(current_dir_files) == 0:
    file_to_process = input("Input full path (from the disk) to your file: ")
else:
    file_to_process = join(current_dir, current_dir_files[0])


driver = webdriver.Chrome()
driver.get(f"file:///{file_to_process}")

# Получаем все stylesheets в документе
stylesheets = driver.find_elements(By.CSS_SELECTOR, 'link[rel="stylesheet"]')

# Отключаем все stylesheets в документе, кроме header.css
driver.execute_script(disable_foreign_stylesheets)

# Запоминаем эталонный цвет заголовка h2
h2_elem = driver.find_element(By.TAG_NAME, "h2")
initial_color = Color.from_string(h2_elem.value_of_css_property('color')).hex


for stylesheet in stylesheets:
    short_name = stylesheet.get_attribute("href").split("/")[-1]

    if "header.css" != short_name:
        # По очереди включаем каждый stylesheet
        driver.execute_script(get_script_to_toggle_stylesheet(short_name, 'false'))
        current_color = Color.from_string(h2_elem.value_of_css_property('color')).hex

        # Сравниваем текущий цвет с эталонным (если не совпадает - запоминаем имя)
        if current_color != initial_color:
            foreign_stylesheets.append(short_name)

        # Обратно выключаем stylesheet (чтобы не возникало конфликтов)
        driver.execute_script(get_script_to_toggle_stylesheet(short_name, 'true'))

driver.close()

# Выводим имена неправильных stylesheets
print("Invalid stylesheets:", *foreign_stylesheets)
