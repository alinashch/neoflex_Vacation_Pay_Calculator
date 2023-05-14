package com.example.vacationpaycalculator.Controller;

import com.example.vacationpaycalculator.Entity.VacationEntity;
import com.example.vacationpaycalculator.Service.VacationServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@Slf4j
@Data
//Просто контроллер
public class VacationController {
    private final VacationServiceImpl vacationService;
    //Запрос get на вход принимает сущность отпуска VаcationEntity и возвращает итогувую строку
    @GetMapping("/calculate")
    public String getVacation( @RequestBody VacationEntity vacationEntity){
        return vacationService.calculateVacationPayouts(vacationEntity);
    }
}
