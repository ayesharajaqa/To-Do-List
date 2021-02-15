package com.example.demo.persistance.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

@SpringBootTest
public class ErrandsDomainTest {
private ErrandsDomain Errand;

	
	@Test
	public void setterGetterTest() {
		Errand = new ErrandsDomain(1L, "Function to test my domain", 2, "10-02-2022", null, "Ongoing");
		
		
		Assertions.assertNotNull(Errand);
		Errand.setErrandId(1L);
		Errand.setSummary("A function to test my domain");
		Errand.setPriority(2);
		Errand.setDeadline("10-02-2022");
		Errand.setMyList(null);
		Errand.setStatus("ongoing");
		Assertions.assertNotNull(Errand.getErrandId());
		Assertions.assertNotNull(Errand.getSummary());
		Assertions.assertNotNull(Errand.getPriority());
		Assertions.assertNotNull(Errand.getDeadline());
		Assertions.assertNull(Errand.getMyList());
		Assertions.assertNotNull(Errand.getStatus());
		
		
		
	}
	

}
