package com.example.vacationpaycalculator.TestCalculation;

import com.example.vacationpaycalculator.Entity.VacationEntity;
import com.example.vacationpaycalculator.Service.VacationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class VacationPayCalculatorTest {
    //Тест при подаче на вход количества дней и зарплаты
    @Test
    void canGetVacationWhenExpectDaysAndSalary() {

        VacationServiceImpl vacationService=new VacationServiceImpl();
        VacationEntity entity = new VacationEntity(10, 10000.0);
        String actual = vacationService.calculateVacationPayouts(entity);
        assertThat(actual).isEqualTo("Your payments 3413");
    }
    //Тест при подаче на вход количества , равном нулю, дней и зарплаты. Ожидается ошибка

    @Test
    void canGetVacationWhenExpectDaysNullAndSalary() {

        VacationServiceImpl vacationService=new VacationServiceImpl();
        VacationEntity entity = new VacationEntity(0, 10000.0);
        String actual = vacationService.calculateVacationPayouts(entity);
        assertThat(actual).isEqualTo("Error! The number of vacation days cannot be less than or equal to zero");
    }
    //Тест при подаче на вход  зарплаты и точных дат отпуска

    @Test
    void canGetVacationWhenExpectExactDaysAndSalary() {

        VacationServiceImpl vacationService=new VacationServiceImpl();
        VacationEntity entity = new VacationEntity( 10000.0, LocalDate.of(2023,05,01),  LocalDate.of(2023,05,10));
        String actual = vacationService.calculateVacationPayouts(entity);
        assertThat(actual).isEqualTo("Your payments 1706");
    }
    //Тест при подаче на вход  зарплаты и точных дат отпуска, но одна из них нулевая.Ожидается ошибка

    @Test
    void canGetVacationWhenExpectExactDaysNullAndSalary() {

        VacationServiceImpl vacationService=new VacationServiceImpl();
        VacationEntity entity = new VacationEntity( 10000.0, null,  LocalDate.of(2023,05,10));
        String actual = vacationService.calculateVacationPayouts(entity);
        assertThat(actual).isEqualTo("Error! The number of vacation days cannot be less than or equal to zero");
    }
}
