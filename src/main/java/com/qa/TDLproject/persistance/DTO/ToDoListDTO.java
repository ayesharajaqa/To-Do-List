package com.qa.TDLproject.persistance.DTO;

import java.util.List;

import com.qa.TDLproject.persistance.Domain.ErrandsDomain;

public class ToDoListDTO {
	private Long list_id;
	private List<ErrandsDomain> Errandlist;
	private String name;

	public ToDoListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoListDTO(Long list_id, String name) {
		super();
		this.list_id = list_id;
		//this.Errandlist = Errandlist;
		this.name = name;
	}

	public ToDoListDTO(long l, String string, Object object) {
		this.list_id = l;
		this.name = string;
		this.Errandlist = (List<ErrandsDomain>) object;
		// TODO Auto-generated constructor stub
	}

	public Long getList_id() {
		return list_id;
	}

	public void setList_id(Long list_id) {
		this.list_id = list_id;
	}

	public List<ErrandsDomain> getErrandslist() {
		return Errandlist;
	}

	public void setErrandslist(List<ErrandsDomain> Errandslist) {
		this.Errandlist = Errandslist;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ToDoListDomain [list_id=" + list_id + ", Errandslist=" + Errandlist + "]";

	}

	public String getName() {
		return name;

	}

}
