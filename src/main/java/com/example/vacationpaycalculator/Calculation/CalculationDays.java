package com.example.vacationpaycalculator.Calculation;

import com.example.vacationpaycalculator.Entity.VacationEntity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
//Класс для вычисления дней , за которые положены выплаты
public class CalculationDays implements Calculation{

    @Override
    public int calculate(VacationEntity vacationEntity){
        //Вычисляем количество дней между началом отпуска и концом
        int daysBetweenStartAndFinishVacation=(int) ChronoUnit.DAYS.between(vacationEntity.getDayOfStartVacation(), vacationEntity.getDayOfFinishVacation());
        //Список не рабочих  праздничных дней
        List<LocalDate> NonWorkingDays=getNonWorkingDays();
        //Выходные и праздничные дни в период отпуска
        int daysNonWork=0;
        //Проходим по всем дням между началом и концом отпуска
        for (LocalDate date = vacationEntity.getDayOfStartVacation(); date.isBefore(vacationEntity.getDayOfFinishVacation()); date = date.plusDays(1)) {
            //Если день из отпуска попадает на праздничный день, то прибавляем 1 к количеству нерабочих дней в период отпуска
            for(LocalDate day:NonWorkingDays){
                if(day.compareTo(date)==0){
                    daysNonWork++;
                }
            }
            //Если день из отпуска попадает на выходной  день, то прибавляем 1 к количеству нерабочих дней в период отпуска

            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
                daysNonWork++;
            }
        }
        //возвращаем количество дней за которые положены выплаты

        return daysBetweenStartAndFinishVacation-daysNonWork;
    }
    //Просто список праздничных дней
    private List<LocalDate> getNonWorkingDays(){
        List<LocalDate> NonWorkingDays = new ArrayList<>();
        NonWorkingDays.add(LocalDate.of(2023, 1, 1));
        NonWorkingDays.add(LocalDate.of(2023, 1, 2));
        NonWorkingDays.add(LocalDate.of(2023, 1, 3));
        NonWorkingDays.add(LocalDate.of(2023, 1, 4));
        NonWorkingDays.add(LocalDate.of(2023, 1, 5));
        NonWorkingDays.add(LocalDate.of(2023, 1, 6));
        NonWorkingDays.add(LocalDate.of(2023, 1, 7));
        NonWorkingDays.add(LocalDate.of(2023, 1, 8));
        NonWorkingDays.add(LocalDate.of(2023, 2, 23));
        NonWorkingDays.add(LocalDate.of(2023, 3, 8));
        NonWorkingDays.add(LocalDate.of(2023, 5, 1));
        NonWorkingDays.add(LocalDate.of(2023, 5, 9));
        NonWorkingDays.add(LocalDate.of(2023, 6, 12));
        NonWorkingDays.add(LocalDate.of(2023, 11, 4));
        return NonWorkingDays;
    }
}

