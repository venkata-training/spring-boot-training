package org.mycompany.test.start_boot;

import org.springframework.stereotype.Component;

@Component
public class YearUtil {
	
	/**
	 * returns true if the birth year is a leap year, else false
	 * @param birthYear
	 * @return true if the birth year is a leap year, else false
	 */
	public boolean isLeapYear(int birthYear) {
		return (birthYear%4 == 0);
	}

}
