# neoflex_Vacation_Pay_Calculator

Протестируем GET запросы при помощи postman.
Отправим первый запрос, на который ожидается корректный ответ. Как видно, все работает корректно
{
    
    "salary": "100000.0",
    "vacationDays":"10"
}
![image](https://github.com/alinashch/neoflex_Vacation_Pay_Calculator/assets/83130878/5f308f63-6062-46d2-8490-cddede60ac9b)

 
Теперь зададим зарплату, дату начала и дату конца отпуска. Ожидается корректный ответ. Из скрина видно, что это действительно так. 
{
    
    "salary": "100000.0",
    "dayOfStartVacation":"2023-05-01",
    "dayOfFinishVacation":"2023-05-10" 
}
![image](https://github.com/alinashch/neoflex_Vacation_Pay_Calculator/assets/83130878/51adcff7-505d-4850-8a40-c84eb7da61a8)

 
Попробуем отправить нулевую зарплату(Например, если пользователь отправил по ошибке 0)
{
    
    "salary": "0",
    "dayOfStartVacation":"2023-05-01",
    "dayOfFinishVacation":"2023-05-10" 
}

 ![image](https://github.com/alinashch/neoflex_Vacation_Pay_Calculator/assets/83130878/2cecc079-7201-4b4d-9bf8-2bc15c72b665)

И для запроса с количеством дней
{
    
    "salary": "0",
    "vacationDays":"10"
}

![image](https://github.com/alinashch/neoflex_Vacation_Pay_Calculator/assets/83130878/533e0383-fffe-429e-8faf-73e9f46790c8)

 
Попробуем теперь количество дней задать равным 0
{
    
    "salary": "100000.0",
    "vacationDays":"0"
}
![image](https://github.com/alinashch/neoflex_Vacation_Pay_Calculator/assets/83130878/85f07b8d-0e00-4f3b-89df-2579ec9ae308)


 
