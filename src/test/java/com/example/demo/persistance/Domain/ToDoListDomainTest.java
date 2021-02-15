package com.example.demo.persistance.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.TDLproject.persistance.Domain.ToDoListDomain;

@SpringBootTest
public class ToDoListDomainTest {
	private ToDoListDomain todolist;
	

	@Test
	public void setterGetterTest() {
		todolist = new ToDoListDomain(1L,null, "Test List");
		
		
		Assertions.assertNotNull(todolist);
		todolist.setList_id(1L);
		todolist.setErrandlist(null);
		todolist.setName("Errands List");
		Assertions.assertNotNull(todolist.getList_id());
		Assertions.assertNull(todolist.getErrandlist());
		Assertions.assertNotNull(todolist.getName());
		
		
		
	}

}
