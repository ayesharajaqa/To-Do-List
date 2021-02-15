package com.qa.TDLproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.TDLproject.Services.ErrandsServices;
import com.qa.TDLproject.persistance.DTO.ErrandsDTO;
import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

@Controller
@RequestMapping("/Tasks")
public class ErrandsController {
	
	private ErrandsServices service;
	@Autowired
	public ErrandsController(ErrandsServices service) {
		super();
		this.service = service;
	}
	
	// GET read all
	@GetMapping("/readAll")
	public ResponseEntity<List<ErrandsDTO>> readAll() {

		return new ResponseEntity<List<ErrandsDTO>>(this.service.readall(), HttpStatus.OK);
	}

	// Get read by id
	@GetMapping("/read/{id}")
	public ResponseEntity<ErrandsDTO> readOne(@PathVariable("id") Long id) {
		return new ResponseEntity<ErrandsDTO>(this.service.readOne(id), HttpStatus.OK);
	}

//POST
	@PostMapping("/create")
	public ResponseEntity<ErrandsDTO> create(@RequestBody ErrandsDomain task) {
		return new ResponseEntity<ErrandsDTO>(this.service.create(task), HttpStatus.CREATED);

	}

//PUT
	@PutMapping("/replace/{id}")
	public ResponseEntity<ErrandsDTO> replace(@PathVariable Long id, @RequestBody ErrandsDomain task) {
		return new ResponseEntity<ErrandsDTO>(this.service.update(id,task), HttpStatus.ACCEPTED);
	}
	

//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		return this.service.delete(id)?
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
