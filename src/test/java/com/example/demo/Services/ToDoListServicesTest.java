package com.example.demo.Services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.TDLproject.ToDoListRepo;
import com.qa.TDLproject.Services.ToDoListServices;
import com.qa.TDLproject.persistance.DTO.ToDoListDTO;
import com.qa.TDLproject.persistance.Domain.ToDoListDomain;

@SpringBootTest
public class ToDoListServicesTest {
	@MockBean
	private ModelMapper mockedMapper;

	@MockBean
	private ToDoListRepo mockedRepo;

	@Autowired
	private ToDoListServices service;

	@Test
	public void create() {
		
		ToDoListDomain testtodolist = new ToDoListDomain(1L, null, "Chocolate");
		ToDoListDTO testdto = new ToDoListDTO(1L, "Chocolate", null);
		
		Mockito.when(this.mockedRepo.save(Mockito.any(ToDoListDomain.class))).thenReturn(testtodolist);
		Mockito.when(this.mockedMapper.map(testtodolist, ToDoListDTO.class)).thenReturn(testdto);
		
		ToDoListDTO result = this.service.create(testtodolist);
		
		assertThat(result);
		assertThat(testdto);
		assertThat(result).usingRecursiveComparison().
		isEqualTo(testdto);

		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(ToDoListDomain.class));
		Mockito.verify(this.mockedMapper, Mockito.times(1)).map(testtodolist, ToDoListDTO.class);
	}

	@Test
	public void delete() {
		Long id = 1l;

		Mockito.when(this.mockedRepo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(1l));

		Mockito.verify(this.mockedRepo, Mockito.times(1)).existsById(id);
	}

	@Test
	public void readById() {
		ToDoListDomain testtodolist = new ToDoListDomain(1L, "Chocolate");
		ToDoListDTO testdto = this.mockedMapper.map(testtodolist, ToDoListDTO.class);

		Mockito.when(this.mockedRepo.findById(testtodolist.getList_id())).thenReturn(Optional.of(testtodolist));
		ToDoListDTO result = this.service.readOne(1L);

		assertThat(result).isEqualTo(testdto);

		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void readAll() {
		Long id = 1L;
		ToDoListDomain testtodolist = new ToDoListDomain(1L, null, "Chocolate");

		testtodolist.setList_id(id);

		List<ToDoListDomain> todolist = this.mockedRepo.findAll();
		ToDoListDTO resultList = this.mockedMapper.map(todolist, ToDoListDTO.class);

		Mockito.when(this.mockedRepo.findAll()).thenReturn(todolist);
		Mockito.when(this.mockedMapper.map(todolist, ToDoListDTO.class)).thenReturn(resultList);

		assertThat(todolist);
		assertThat(this.service.readAll());


		Mockito.verify(this.mockedRepo, Mockito.times(2)).findAll();
	}

	@Test
	public void update() {
		ToDoListDomain testtodolistA = new ToDoListDomain(1L, null, "Chocolate");
		ToDoListDomain testtodolistB = new ToDoListDomain(1L, null, "Chocolate");
		ToDoListDTO testdto = new ToDoListDTO(1L, testtodolistB.getName(), null);

		Mockito.when(this.mockedRepo.findById(1L)).thenReturn(Optional.of(testtodolistA));
		Mockito.when(this.mockedRepo.save(testtodolistB)).thenReturn(testtodolistB);
		Mockito.when(this.mockedMapper.map(testtodolistB, ToDoListDTO.class)).thenReturn(testdto);

		ToDoListDTO result = this.service.update(1L, testtodolistB);

		assertThat(result);
	}

}
