#Тестовое задание по созданию фильтров для перелетов

"Исключите из тестового набора перелёты по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов): Вылет до текущего момента времени. Сегменты с датой прилёта раньше даты вылета. Перелеты, где общее время, проведённое на земле, превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)"

Java ответы на вопросы
Что такое переопределение метода?	Это процесс создание методов в подклассе с тем же именем и сигнатурой, как у метода из его суперкласса, что позволяет изменить его поведение

Какие бывают виды классов?	 Виды классов в Java.
-Обычные - могут содержать поля, методы, конструкторы, инициализационные блоки и вложенные классы. Можно создать объект классов
- Абстрактные классы -  классы, которые могут содержать как обычные методы, так и абстрактные методы. Нельзя создать экземпляр классов.
-Интерфейсы - интерфейсы в Java содержат только константные поля и сигнатуры методов (без их реализации).
- Перечисления (Enums) - специальный тип классов, который ограничивает создание экземпляров до заданного набора значений.

Как и зачем можно использовать модификатор final?	Этот модификатор в Java применяется к классам, методам и переменным. Для классов он предотвращает наследование, для методов — переопределение, а для переменных — изменение значения после инициализации

Какие есть варианты использования ключевого слова try?	В Java ключевое слово try используется для обработки исключений. Оно может быть использовано вместе с блоками catch для обработки исключений или с блоком finally для выполнения кода независимо от исключений.

Какие есть стандартные реализации интерфейса List и в каких ситуациях их нужно использовать?	 В Java стандартными реализациями интерфейса List являются ArrayList и LinkedList. ArrayList хорошо подходит для доступа по индексу, а LinkedList — для вставки/удаления элементов в середине списка.

В чём основная идея стримов из пакета java.util.stream?	Стримы в Java предоставляют удобный и выразительный способ работы с коллекциями объектов. Они позволяют выполнять операции фильтрации, сортировки, отображения и агрегации данных с использованием лямбда-выражений.

Разное
Каким критериям должна удовлетворять «хорошая» хэш-функция?	Хорошая хэш-функция должна равномерно распределять ключи по всему диапазону значений хэша, минимизировать коллизии и быть быстрой в вычислении.

В чём причина популярности и широкого распространения кодировки UTF-8?	UTF-8 широко используется из-за своей универсальности — он поддерживает символы всех языков и позволяет экономно представлять текст на большинстве платформ.

Сравните форматы XML и JSON. Когда какой использовать?	XML структурирован с помощью тегов и может быть более удобным для представления сложных данных с метаданными, в то время как JSON — легковесный и удобен для обмена данными в веб-приложениях и API.

Опишите что будет происходить «под капотом» после ввода адреса сайта в браузере и нажатия Enter?	После ввода адреса сайта в браузер и нажатия Enter происходит следующее: браузер отправляет запрос DNS-серверу для разрешения доменного имени в IP-адрес, затем устанавливается TCP-соединение с веб-сервером, браузер отправляет HTTP-запрос на получение страницы, сервер обрабатывает запрос и отправляет HTML-страницу, браузер получает ответ и отображает страницу пользователю.
