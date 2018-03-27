package org.mycompany.test.start_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	protected AgeService ageService;
	
	@Autowired
	private YearUtil yearUtil;

	@RequestMapping(method = RequestMethod.GET, value = "/hello/{name}/{year}")
	public @ResponseBody String sayHello(@PathVariable String name, @PathVariable int year) {
		boolean isLeapYear = yearUtil.isLeapYear(year);
		int age = ageService.calculateAge(year);
		return "Dear " + name + ", your age is " + age +". Leap year? " + isLeapYear;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/details/{id}")
	// includes JAXB in classloader
	// Introspects the response object for XML root annotation
	// Creates String representation of the object starting at the root element
	public @ResponseBody PersonDetails getPersonDetails(@PathVariable String id //,
			//@RequestParam (defaultValue="DEF", required=false) String type,
			//@RequestHeader ("CorrelationId") String encoding,
			//@RequestHeader ("User-Agent") String userAgent
			) {
		PersonDetails details = new PersonDetails();
		
		details.setLastName("Washington");
		details.setFirstname("George");
		details.setAddress("100 Princeton St, San Francisco, CA 91232");
		//details.setEncoding(encoding + "," + userAgent);
		//details.setType(type);
		
		if(id.equals("GW")) {
			return details;
		}
		
		return new PersonDetails();
	}

	/**
	 * @param ageService
	 *            the ageService to set
	 */
	public void setAgeService(AgeService ageService) {
		this.ageService = ageService;
	}

	/**
	 * @param yearUtil the yearUtil to set
	 */
	public void setYearUtil(YearUtil yearUtil) {
		this.yearUtil = yearUtil;
	}

}

