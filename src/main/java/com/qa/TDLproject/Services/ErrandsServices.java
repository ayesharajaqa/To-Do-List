package com.qa.TDLproject.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.TDLproject.ErrandsRepo;
import com.qa.TDLproject.persistance.DTO.ErrandsDTO;
import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

@Service
public class ErrandsServices {
	private ErrandsRepo repo;
	private ModelMapper mapper;

	@Autowired
	public ErrandsServices(ErrandsRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		
	}

private ErrandsDTO mapDTO(ErrandsDomain model) {
		return this.mapper.map(model, ErrandsDTO.class);

	}
	// GET
	// read One

	public ErrandsDTO readOne(Long id) {
		return mapDTO(this.repo.findById(id).orElseThrow());

	}

	// Read All
	public List<ErrandsDTO> readall() {
		List<ErrandsDomain> dblist = this.repo.findAll();
		List<ErrandsDTO> resultlist = dblist.stream().map(this::mapDTO).collect(Collectors.toList());
		return resultlist;
	}

	// POST

	public ErrandsDTO create(ErrandsDomain cat) {
		return this.mapDTO(this.repo.save(cat));

	}
	// Put

	public ErrandsDTO update(Long id, ErrandsDomain newDetails) {
		ErrandsDomain dbEntry = this.repo.findById(id).orElseThrow();
		newDetails.setErrandId(id);
		ErrandsDTO result = this.mapDTO(this.repo.save(newDetails));
		return result;
	}

	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
