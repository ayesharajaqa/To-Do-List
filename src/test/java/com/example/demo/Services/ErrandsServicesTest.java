package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.TDLproject.ErrandsRepo;
import com.qa.TDLproject.Services.ErrandsServices;
import com.qa.TDLproject.persistance.DTO.ErrandsDTO;
import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

@SpringBootTest
public class ErrandsServicesTest {
	@MockBean
	private ModelMapper mockedMapper;
	
	@MockBean
	private ErrandsRepo mockedRepo;
	
	@Autowired
	private ErrandsServices service;
	@Test
	public void create() {
		
		ErrandsDomain testtask = new ErrandsDomain(1L, "Function to test my domain", 2, "10-02-2022", null, "Ongoing");
		ErrandsDTO testdto = new ErrandsDTO(1L, "Function to test my domain", 2, "10-02-2022", null, "Ongoing");
		
		Mockito.when(this.mockedRepo.save(Mockito.any(ErrandsDomain.class))).thenReturn(testtask);
		Mockito.when(this.mockedMapper.map(testtask, ErrandsDTO.class)).thenReturn(testdto);
		
		ErrandsDTO result = this.service.create(testtask);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result,testdto);
		Assertions.assertEquals(result,testdto);
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(ErrandsDomain.class));
		Mockito.verify(this.mockedMapper, Mockito.times(1)).map(testtask, ErrandsDTO.class);
	}
	
	@Test
	public void delete() {
		Long id = 1l;
		
		Mockito.when(this.mockedRepo.existsById(id)).thenReturn(false);
		
		Assertions.assertTrue(this.service.delete(id));
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).existsById(id);
	}
	
	@Test
	public void readById() {
		ErrandsDomain testtask = new ErrandsDomain(1L, "Simple task to test my domain", 2, "01-01-2021", null, "Ongoing");
		ErrandsDTO testdto = this.mockedMapper.map(testtask, ErrandsDTO.class);
		
		Mockito.when(this.mockedRepo.findById(testtask.getErrandId())).thenReturn(Optional.of(testtask));
		ErrandsDTO result = this.service.readOne(1L);
		
		Assertions.assertEquals(result,testdto);
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		}
	
	@Test
	public void readAll() {
		Long id = 1L;
		ErrandsDomain testtask = new ErrandsDomain(1L, "Function to test my domain", 2, "10-02-2022", null, "Ongoing");
		
		
		testtask.setErrandId(id);
		
		List<ErrandsDomain>tasks = this.mockedRepo.findAll();
		ErrandsDTO resultList = this.mockedMapper.map(tasks, ErrandsDTO.class);
		
		Mockito.when(this.mockedRepo.findAll()).thenReturn(tasks);
		Mockito.when(this.mockedMapper.map(tasks, ErrandsDTO.class)).thenReturn(resultList);
		

		
		Assertions.assertNotNull(tasks);
		Assertions.assertEquals(this.service.readall(),tasks);
		
		Mockito.verify(this.mockedRepo, Mockito.times(2)).findAll();
		

	}
	
	@Test
	public void update() {
		ErrandsDomain testtaskA = new ErrandsDomain(1L, "Simple task to test my domain", 2, "01-01-2021", null, "Ongoing");
		ErrandsDomain testtaskB = new ErrandsDomain(1L, "Simple task to test my domain", 2, "01-01-2021", null, "Ongoing");
		ErrandsDTO testdto = new ErrandsDTO(1L, testtaskB.getSummary(), testtaskB.getPriority(), testtaskB.getDeadline(), null, testtaskB.getStatus());
		
		Mockito.when(this.mockedRepo.findById(1L)).thenReturn(Optional.of(testtaskA));
		Mockito.when(this.mockedRepo.save(testtaskB)).thenReturn(testtaskB);
		Mockito.when(this.mockedMapper.map(testtaskB, ErrandsDTO.class)).thenReturn(testdto);
		
		ErrandsDTO result = this.service.update(1L, testtaskB);
		
		Assertions.assertEquals(result,testdto);
	}
	

}
