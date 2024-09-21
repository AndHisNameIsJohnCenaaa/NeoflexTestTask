package com.neoflex.testtask.to;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class VacationPayTo {

    private final BigDecimal vacationPayAmount;
}
