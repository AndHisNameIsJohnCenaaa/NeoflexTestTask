package com.neoflex.testtask.controller;

import com.neoflex.testtask.service.VacationPayCalculateService;
import com.neoflex.testtask.to.VacationPayTo;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class CalculatorController {

    private final VacationPayCalculateService service;


    @GetMapping("/calculate")
    public ResponseEntity<VacationPayTo> calculate(
            @RequestParam @Positive BigDecimal averageSalary,
            @RequestParam @Positive int vacationDaysNumber,
            @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate vacationStartDate) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.calculate(averageSalary, vacationDaysNumber, vacationStartDate));
    }
}
