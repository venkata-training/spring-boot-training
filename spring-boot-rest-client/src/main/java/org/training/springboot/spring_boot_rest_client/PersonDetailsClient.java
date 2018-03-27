package org.training.springboot.spring_boot_rest_client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonDetailsClient {
	
	@RequestMapping (method = RequestMethod.GET, value="/address/{name}")
	public @ResponseBody PersonAddress getPersonAddress(@PathVariable String name) {
		
		try {

			RestTemplate restTemplate = new RestTemplateBuilder().build();

			String url = "http://localhost:8080/details/{name}";

			System.out.println("Invoking url:"+url);

			ResponseEntity<PersonDetails> responseEntity = restTemplate.getForEntity(url, PersonDetails.class, name);
			PersonDetails personDetails = responseEntity.getBody();
			System.out.println("Person details:"+personDetails);
			PersonAddress personAddress = new PersonAddress();
			personAddress.setAddress(personDetails.getAddress());

			return personAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return new PersonAddress();
		}
	}
	
	// Create with post

}
