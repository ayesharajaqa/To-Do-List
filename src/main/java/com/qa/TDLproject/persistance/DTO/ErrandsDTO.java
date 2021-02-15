package com.qa.TDLproject.persistance.DTO;

import com.qa.TDLproject.persistance.Domain.ToDoListDomain;

public class ErrandsDTO {
	private Long ErrandId;
	private String summary;
	private int priority;
	private String deadline;
	private ToDoListDomain myList;
	private String status;
	
	
	public ErrandsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ErrandsDTO(Long errandID, String summary, int priority, String deadline, ToDoListDomain myList, String status) {
		super();
		this.ErrandId = errandID;
		this.summary = summary;
		this.priority = priority;
		this.deadline = deadline;
		this.myList = myList;
		this.status = status;
	}
	
	public Long getErrandsId() {
		return ErrandId;
	}
	
	public void setErrandId(Long errandID) {
		this.ErrandId = errandID;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public ToDoListDomain getMyList() {
		return myList;
	}
	public void setMyList(ToDoListDomain myList) {
		this.myList = myList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Errandsdomain [ErrandId=" + ErrandId + ", summary=" + summary + ", priority=" + priority + ", deadline="
				+ deadline + ", myList=" + myList + ", status=" + status + "]";
	}
	
	


}
