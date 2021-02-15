package com.qa.TDLproject.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TDLproject.ToDoListRepo;
import com.qa.TDLproject.persistance.DTO.ToDoListDTO;
import com.qa.TDLproject.persistance.Domain.ToDoListDomain;

@Service
public class ToDoListServices {

	private ToDoListRepo repo;
	private ModelMapper mapper;

	@Autowired
	public ToDoListServices(ToDoListRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

//Readall
	private ToDoListDTO mapToDto(ToDoListDomain model) {
		return this.mapper.map(model, ToDoListDTO.class);
	}

	// POST
	public ToDoListDTO create(ToDoListDomain model) {
		return this.mapToDto(this.repo.save(model));
	}

	// GET
	public List<ToDoListDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public ToDoListDTO readAssignee(long id) {
		return this.mapToDto(this.repo.findById(id).orElseThrow());
	}

	// DELETE
	public boolean delete(long id) {
		Optional<ToDoListDomain> existingOptional = this.repo.findById(id);

		if (existingOptional.isPresent()) {
			ToDoListDomain existing = existingOptional.get();
			existing.removeTasks();
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		}

		return false;
	}

	// PUT
	public ToDoListDTO update(long id, ToDoListDomain model) {
		Optional<ToDoListDomain> oc = this.repo.findById(id);
		ToDoListDomain existing = oc.orElseThrow();

		existing.setName(model.getName());

		return this.mapToDto(this.repo.save(existing));
	}

	public ToDoListDTO readOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}