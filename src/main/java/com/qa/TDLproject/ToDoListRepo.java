package com.qa.TDLproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.TDLproject.persistance.Domain.ToDoListDomain;

@Repository
public interface ToDoListRepo extends JpaRepository<ToDoListDomain, Long>{ 

}
