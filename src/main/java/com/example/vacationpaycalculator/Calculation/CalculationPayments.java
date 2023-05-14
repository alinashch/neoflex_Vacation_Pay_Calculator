package com.example.vacationpaycalculator.Calculation;

import com.example.vacationpaycalculator.Entity.VacationEntity;
//Класс для вычисления выплат
public class CalculationPayments implements Calculation{
    //среднее количество дней в месяц
    private static final double average_number_of_days_in_a_month = 29.3;
    //Вычисляем
    @Override
    public int calculate(VacationEntity vacationEntity){
        return (int) Math.round((vacationEntity.getSalary() / average_number_of_days_in_a_month) * vacationEntity.getVacationDays());
    }

}
