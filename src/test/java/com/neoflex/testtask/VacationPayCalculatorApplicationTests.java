package com.neoflex.testtask;

import com.neoflex.testtask.service.VacationPayCalculateService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AllArgsConstructor(onConstructor = @__(@Autowired))
class VacationPayCalculatorApplicationTests {

	private final VacationPayCalculateService service;

    @Test
	void calculateWithoutStartVacationDay() {
		BigDecimal actual = service.calculate(BigDecimal.valueOf(145000), 15, null)
				.getVacationPayAmount();
		BigDecimal expected = BigDecimal.valueOf(74232.15);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void calculateWithStartVacationDayAndHolidays() {
		BigDecimal actual = service.calculate(
				BigDecimal.valueOf(145000), 15, LocalDate.of(2024, 1, 1))
				.getVacationPayAmount();
		BigDecimal expected = BigDecimal.valueOf(24744.05);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void calculateWithStartVacationDayAndWeekends() {
		BigDecimal actual = service.calculate(
						BigDecimal.valueOf(145000), 15, LocalDate.of(2024, 1, 15))
				.getVacationPayAmount();
		BigDecimal expected = BigDecimal.valueOf(54436.91);
		assertThat(actual).isEqualTo(expected);
	}

}
