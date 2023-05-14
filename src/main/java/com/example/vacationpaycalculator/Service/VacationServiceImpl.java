package com.example.vacationpaycalculator.Service;

import com.example.vacationpaycalculator.Calculation.Calculation;
import com.example.vacationpaycalculator.Calculation.CalculationDays;
import com.example.vacationpaycalculator.Calculation.CalculationPayments;
import com.example.vacationpaycalculator.Entity.VacationEntity;
import lombok.Data;
import org.springframework.stereotype.Service;




//Реализация интерфейса
@Service
@Data
public class VacationServiceImpl implements VacationServiceInterface {
    //Для вычисления дней отпуска
    private final Calculation calculationDays = new CalculationDays();
    //Для вычисления выплат за отпуск
    private final Calculation calculationPayments = new CalculationPayments();

    //Главная функция вычисления
    @Override
    public String calculateVacationPayouts(VacationEntity vacationEntity) {
        //Если зарплата меньше или равна нулю, то вычислений дальше нет и будет ошибка
        if(vacationEntity.getSalary()<=0  ){
            return "Error! The salary cannot be less than or equal to zero";
        }
        //Если количество дней тпуска меньше нуля(допустим пользователь ввел по ошибке -10 вместо 10). Также тут проверяется, чтобы  пользователь ввел либо количество дней, либо даты
        if( vacationEntity.getVacationDays()<=0 && (vacationEntity.getDayOfStartVacation()==null || vacationEntity.getDayOfFinishVacation()==null )){
            return "Error! The number of vacation days cannot be less than or equal to zero";
        }
        //Вычисляем количество дней, за которые положены выплаты в период отпуска при указании точных дат(т.е с учетом праздников и выходных)

        if (vacationEntity.getDayOfStartVacation()!=null || vacationEntity.getDayOfFinishVacation()!=null ) {

            vacationEntity.setVacationDays(calculationDays.calculate(vacationEntity));
        }
        //Вычисляем выплаты за отпуск только по дням
        int roundPayment=calculationPayments.calculate(vacationEntity);

        return "Your payments "+roundPayment ;
    }


}
