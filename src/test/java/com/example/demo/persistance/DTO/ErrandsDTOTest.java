package com.example.demo.persistance.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.TDLproject.persistance.DTO.ErrandsDTO;

@SpringBootTest
public class ErrandsDTOTest {
	private ErrandsDTO ErrandsDTO;

	@Test
	public void setterGetterTest() {
		ErrandsDTO = new ErrandsDTO(1L, "Function to test my DTO", 2, "10-02-2022", null, "Ongoing"); 
		
		Assertions.assertNotNull(ErrandsDTO);
		ErrandsDTO.setErrandId(1L);
		ErrandsDTO.setSummary("Simple task to test my dto");
		ErrandsDTO.setPriority(2);
		ErrandsDTO.setDeadline("01-01-2021");
		ErrandsDTO.setMyList(null);
		ErrandsDTO.setStatus("ongoing");
		Assertions.assertNotNull(ErrandsDTO.getErrandsId());
		Assertions.assertNotNull(ErrandsDTO.getSummary());
		Assertions.assertNotNull(ErrandsDTO.getPriority());
		Assertions.assertNotNull(ErrandsDTO.getDeadline());
		Assertions.assertNull(ErrandsDTO.getMyList());
		Assertions.assertNotNull(ErrandsDTO.getStatus());
		
		
	}
	

}
