Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculate"

Требования: Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.
API requests
Запрос без даты начала отпуска:
http://localhost:8080/calculate?averageSalary=145000&vacationDaysNumber=15
Response: {"vacationPayAmount":74232.15}
Запрос с указанием даты начала отпуска:
http://localhost:8080/calculate?averageSalary=145000&vacationDaysNumber=15&vacationStartDate=2024-10-28
Response: {"vacationPayAmount":49488.10}
