# HomeWorkServlets
 Домашнее задание по теме "Servlets" (ProductStar)

# Постановка задачи
Скачать код проекта из воркшопа, открыть в любой IDE и сделать следующие доработки.
## Требования
a. Настроить аутентификацию по паролю для всех URL-ов.

b. Реализовать новый endpoint по добавлению дохода (/incomes/add) со следующими условиями:
- для конфигурирования использовать аннотации
- изменить сущность Expense на Transaction для учета как доходов, так и расходов
в summary выводить и доходы, и расходы в порядке их добавления
c. Настроить перенаправление на summary при добавлении дохода или расхода.

d. Добавить перехват всех типов Exception-ов и ошибки 404, формат вывода ошибок на экран: “Error (404) — page not found” или “Error (500) — java.lang.NullPointerException: Income is null”.

## Подключенные зависимости и плагины
- jakarta.servlet-api -стандартизированный API, предназначенный для реализации на сервере и работе с клиентом по схеме запрос-ответ.
- jetty-maven-plugin - плагин сервера - контейнера сервлетов jetty

## Описание основных файлов
- webapp/WEB-INF/web.xml - дескриптор развёртывания веб-приложения, ключевой файл конфигурации в сервлетных приложениях
- webapp/index.html - стартовая html-страница с формой ввода пароля
- LoginServlet.java - сервлет проверки пароля и регистрация для работы (со снятием по таймауту 300 секунд без активности)
- SummaryServlet.java - основной сервлет показа текущей информации по "кошельку"
- DetailsServlet.java - сервлет детальной информации по транзакциям (include для основного сервлета информации)
- ExpensesServlet.java - сервлет для добавления расходов 
- IncomesServlet.java - сервлет для добавления прихода (аннотация)
- ErrorPage.java - сервлет-обработчик(handler) для вывода ошибок (аннотация)
- model/Transaction.java - класс объекта для описания транзакции
- model/FinancialEventType.java - класс для списка операций "Приход" или "Расход"
- model/Expense.java - НЕ ИСПОЛЬЗУЕТСЯ, ОСТАЛОСЬ ОТ НАЧАЛЬНОГО ПРОЕКТА
- listeners/LogAttributeChanges.java - листенер для протоколирования вставки/изменения контекста приложения
- filters/ExpensesFilter.java - фильтр для проверки наличия свободных средств в "кошельке" на текущие расходы (сервлет ExpensesServlet)
- filters/AuthFilter - фильтр для проверки регистрации при работе с функциональными сервлетами кроме LoginServlet (аннотация)
 
- resources/testCommand.tst - файл с набором URL для проверки работы сайта из браузера

Для запуска jetty из IntelliJ IDEA необходимо выбрать в запуске "Edit configuration..." , нажать "+" , выбрать Maven , проставить директорию проекта в качестве рабочей директории,
а в строке запуска прописать "jetty:run" . 