package org.mycompany.test.start_boot;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class AgeService {
	
	/**
	 * calculates the age, in years
	 * @param birthYear year of birth
	 * @return age in years
	 */
	public int calculateAge(int birthYear) {
		
		if(Calendar.getInstance().get(Calendar.YEAR) < birthYear) {
			throw new IllegalArgumentException(""+birthYear);
		}
		
		return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
	}

}
