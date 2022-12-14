# Задание 1. Команда «Криминальное тестирование»
## Начальные условия (свойства)
- Рассмотрим лодку с двигателем (лодку без двигателя рассматривать не имеет смысла, т.к. мы не сможем перевозить большое количество лошадей и обеспечивать им безопасность). Так как ковбои планируют открыть бизнес по перевозке лошадей на лодках, то в будущем стоит рассмотреть различные виды лодочных моторов, чтобы можно было рассчитать затраты.
- Очень важно рассмотреть материал из которого будет изготовлено судно. От этого зависят затраты ковбоев на открытие бизнеса. Точно не будем рассматривать пластик и резину, так как эти материалы очень дешевые и непрактичные.  
- По условию задачи неизвестна масса одной лошади. Рассмотрим средний (возможный)  вес одной лошади(примерно 500 кг у взрослой особи). Данная информация необходима для понимания того, сколько лошадей можно разместить на одном судне.
- Необходимо задать максимальную грузоподъемность лодки т.к., помимо лошадей, возможна перевозка дополнительного груза.
- Для обеспечения безопасности лошадей, будем считать, что в лодке имеется трюм, где лошади могут находиться во время их транспортировки.  
- Для безопасности перевозки ковбоев и лошадей необходимо, чтобы на судне были борты.
- Для отправки судна в путь, необходимо оценить погодные условия. Предполагаем, что на момент перевозки лошадей, погода приемлемая (без шторма, сильного дождя и т.д.).
---

**Критериями оценки считаем выполнение / невыполнение условий указанных тестов. В случае если тест выполняется, можно оценить результат. 
Основные Test Cases для тестирования лодок будут выглядеть примерно так.**

--- 

## Качество изделия (quality estimation):
- На момент отправления, лодка должна быть полностью осмотрена. На всей поверхности наружней части отсутствуют какие-либо визуальные изъяны: неровности, потеки от краски и т.д.
- Внутри трюма должны отсутствовать все возможные опасные для жизни и здоровья лошадей/ковбоев предметы: например, торчащие гвозди, кусочки материалов от фасада судна и т.д. 
- Лодка должна быть равномерно покрыта лаком снаружи и изнутри, чтобы попадающая вода не могла воздействовать на материал корпуса.
- Двигатель лодки должен соответствовать стандартам качества ДВС, установленным в предполагаемых местах использования лодки.
- Паруса должны быть изготовлены из плотного хорошего материала, без внешних изъянов.


## Удобство использования (usability testing):
- Данный способ транспортировки будет наиболее дешевым, так как можно перевозить сразу большое количество лошадей. Остальные варианты(за исключением воздушного судна) не предоставляет такую возможность. 
- По сравнению с любым наземным транспортом, данный способ перевозки лошадей будет наиболее быстрым.
- Данный метод перевозки будет наиболее удобен, как ковбоям (особенно для более длительных поездок, т.к. будет возможность отдохнуть в отдельном трюме), так и, например, капитану судна. 
- Для безопасности здоровья лошадей, на лодке будут использованы специальные загоны.
## Использование (functional testing):
- Проверим, что лодка держится на воде и не тонет. Для начала поставим её на воду без полезной нагрузки и проверим, что она устойчиво держится, не черпает воду и не кренится больше допустимой нормы. Постепенно начнем добавлять полезную нагрузку. Будем использовать мешки с песком (или любые другие предметы, которые не жалко), чтобы не пострадали лошади. Положим 1 мешок - проверим, что лодка слегка погрузилась в воду, но всё ещё держится на плаву. Будем добавлять груз вплоть до максимальной грузоподъёмности судна.
- Достигнув максимальной грузоподъемности проверим, что ватерлиния лодки находится в пределах нормы.
- Проверим способность лодки к перемещению по воде. Для начала попробуем отчалить от берега и проплыть несколько метров. Дальше запустим двигатель и поплывём поперёк реки. Тест будет успешно пройден, если ложка преодолеет путь от одного берега к другому (~1000-2000м) и вернётся обратно, при этом в процессе тестирования лодка не будет крениться больше нормы и внутри неё не окажется воды (будет сохранена герметичность).
- Лодка изготавливается для переправы по реке, однако существуют солёные реки, а также моря и океаны, плотность воды в которых отличается. Проверим, способна ли лодка оставаться на плаву и передвигаться в солёных водах
- Протестируем защищённость лодки изнутри - при переправе могут выпасть осадки и ложка намокнет изнутри. Вода не должна попасть на перевозимых лошадей - проверим это. Симулируем осадки в виде дождя с помощью шланга и воды, поливая лодку сверху на протяжении 30 минут (средняя продолжительность дождя). По окончании симуляции в трюме, где находятся лошади, должно быть сухо, а сама лодка не должна получить повреждений.
- Экологичность (ECO testing):
- Двигатель, установленный на лодке должен быть экологически безопасен. Во-первых, в нем не должно быть утечек топлива, которое может попасть в реку. Во-вторых, выхлопные газы должны соответствовать экологическим нормам, установленным в планируемых местах использования лодок
- Материалы, из которых изготовлена лодка также должны соответствовать экологическим нормам. Проведем химический анализ лака, которым покрыта лодка снаружи и изнутри


## Безопасность (security testing):
- Перевозимый груз (помимо лошадей) должен быть безопасен для людей, лошадей и других живых существ. Если все же груз может нанести ущерб, например, окружающей среде, то необходимо, чтобы он был герметично упакован. Также можно предусмотреть специальный отсек для дополнительных мер безопасности.
- Материал, из которого лодка изготовлена должен быть безопасен для людей и лошадей. Запросим сертификаты соответствия качества от производителей лака, которым покрыта лодка, проведем химический анализ материалов.
- Проверяем, не может ли лошадь вывалиться из лодки и не может ли на нее попасть вода. Чтобы лошадь не пострадала, используем для теста ростовую куклу, соответствующую параметрам настоящей лошади.
- Проверяем наличие спасательных жилетов для экипажа лодки. Также необходимо провести инструктаж и убедиться,что все из экипажа умеют пользоваться спасательными жилетами. 
- На лодке должен быть якорь или другое тормозящее устройство для безопасной стоянки и причаливания - проверим его наличие.
- Необходимо убедиться, что в загонах для лошадей нет никаких колющих/режущих предметов. Так как по условиям ни одно животное не должно пострадать, то можно предусмотреть дополнительные меры безопасности: например, избегать зрительного контакта с водой, с помощью повязки на глаза.
## Внешний вид
- При открытии такого бизнеса, ковбоям необходимо следить за чистотой внутри и снаружи судна. Для этого можно по определенным датам назначать дежурного, выбранного среди ковбоев. 
- Также можно добавить дополнительную опцию, такую как выбор цвета лодки за отдельную плату. 
- В зависимости от количества перевозимых лошадей, можно выбрать и размер судна. Возможно, ковбой захочет транспортировать всего одну лошадь. 
- Помимо этого стоит обратить внимание на паруса. Все зависит от размера лодки. 
- Обязательное наличие загона, который должен быть внутри достаточно чистым.

## Что могли забыть ковбои
- В связи с тем, что ковбои решили смешать пиво с виски, они могли не предусмотреть возможность свободного передвижения лошадей по лодке. Т.к. это небезопасно, в связи с вероятностью падения лошади в воду, нужно либо найти трезвого ковбоя, который будет наблюдать за лошадьми, либо предусмотреть замок в загоне. 
- Помимо этого нельзя, чтобы лошади попробовали алкоголь, т.к. в нем содержится вода. Поэтому стоит также предусмотреть дополнительные меры безопасности.
- Так как у капитана судна может возникнуть соблазн выпить алкоголь из-за просьбы ковбоев составить им компанию, то стоит ввести проверку на трезвость. Благодаря такой проверке, капитаны вряд ли захотят даже пробовать алкоголь. 