package com.neoflex.testtask.service;

import com.neoflex.testtask.to.VacationPayTo;
import com.neoflex.testtask.util.VacationDayUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class VacationPayCalculateService {

    private static final BigDecimal AVERAGE_MONTH_DAY_NUMBER = BigDecimal.valueOf(29.3);

    public VacationPayTo calculate(BigDecimal averageSalary, int vacationDaysNumber, LocalDate vacationStartDate) {
        return new VacationPayTo(averageSalary.divide(AVERAGE_MONTH_DAY_NUMBER, 2, RoundingMode.HALF_DOWN)
                .multiply(BigDecimal.valueOf(vacationStartDate == null ?
                        vacationDaysNumber : VacationDayUtil.getPaidDaysNumber(vacationDaysNumber, vacationStartDate))));
    }
}
