package com.example.vacationpaycalculator.Entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


//Основной класс сущности отпуск
@Data
@NoArgsConstructor

public class VacationEntity {
    //количество дней
    private  int vacationDays;
    //Зарплата
    private double salary;
    //Начало отпуска
    private LocalDate dayOfStartVacation;
    //Конец отпуска
    private LocalDate dayOfFinishVacation;

    //Пользователь может ввести либо количество дней и зарплату
    public VacationEntity(int vacationDays, double salary) {
        this.vacationDays = vacationDays;
        this.salary = salary;
    }
    //Либо зарплату и точные даты начала и конца
    public VacationEntity(double salary, LocalDate dayOfStartVacation, LocalDate dayOfFinishVacation) {
        this.salary = salary;
        this.dayOfStartVacation = dayOfStartVacation;
        this.dayOfFinishVacation = dayOfFinishVacation;
    }


}
