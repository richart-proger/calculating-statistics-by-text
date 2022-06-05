# Задание: разработать консольное приложение на Java, для расчета статистики по тексту.

***Приложение принимает в командной строке 3 имени файлов.*** 

*  Первый файл – текст для анализа.
* Второй файл – перечень шаблонов для расчета статистики. 
* Третий файл – для вывода результата.

***Шаблоны имеют следующий формат:***
1) а1б2в1 – означает, что слово должно одновременно содержать 1 букву «а», 2 буквы «б» и 1 букву «в»;
2) "абр" – означает, что слово должно содержать последовательность символов в кавычках (например, «швабра»).
Приложение выводит таблицу с количеством подходящих слов по каждому шаблону.

##### Оценивается корректность работы приложения, производительность, оптимальность и качество кода и обработка ошибок. Допускается многопоточная реализация.

Пример входных данных и результата:

| Текст (1й файл)         | Шаблоны (2й файл) | Результат (3й файл)   |
|-------------------------|-------------------|-----------------------|
| Отец мой Андрей         | о2                | о2 2                 |
| Петрович  Гринев в      | т1о1              | т1о1 3               |
| молодости своей         | "ми"              | "ми" 0               |
| служил при графе        | ф2                | ф2 0                 |
| Минихе и вышел в        | 11                | 11 1                 |
| отставку премьер-       | "йо"              | "йо" 1               |
| майором в 17.. году.    | й1о1              | й1о1 3               |
------------

# Запуск и работа приложения

*1. Перед запуском приложения, необходимо разместить на Рабочем столе компьютера 2 файла txt: Текст и Шаблоны (формат файла-Шаблоны - выше).*

*2. Сделайте клон проекта к себе на ПК:*
```
git clone https://github.com/richart-proger/calculating-statistics-by-text.git
```
*3. Соберите проект в вашей любимой IDE или, например, с помощью командной строки (запуск из корня проекта):*
```
mvn clean package
```
*4. Запустите проект в вашей IDE или с помощью командной строки (запуск из папки target):*
```
cd target
java -jar calculating-statistics-by-text-0.0.1-SNAPSHOT.jar
```
>При запуске приложения под Windows OS может возникать подобная ошибка: java.lang.NumberFormatException: For input string:"╛". 
Для ее исправления рекомендуется установить переменную среды: JAVA_TOOL_OPTIONS = -Dfile.encoding=UTF8
(Ссылка на документацию: <https://docs.oracle.com/javase/6/docs/platform/jvmti/jvmti.html#tooloptions>)

*5. Результатом работы приложения будет появившийся третий файл на Рабочем столе вашего компьютера, внутри которого ожидаемая статистика.*