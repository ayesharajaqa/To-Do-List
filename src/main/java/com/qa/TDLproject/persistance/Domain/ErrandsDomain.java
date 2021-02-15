package com.qa.TDLproject.persistance.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ErrandsDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ErrandsId;
	
	
	private String summary;
	private int priority;
	private String deadline;
	@ManyToOne
	private ToDoListDomain myList;
	private String status;
	public ErrandsDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrandsDomain(Long ErrandId, String summary, int priority, String deadline, ToDoListDomain myList,
			String status) {
		super();
		ErrandId = ErrandId;
		this.summary = summary;
		this.priority = priority;
		this.deadline = deadline;
		this.myList = myList;
		this.status = status;
	}
	public Long getErrandId() {
		return ErrandsId;
	}
	public void setErrandId(Long ErrandId) {
		ErrandId = ErrandId;
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
		return "Errandsdomain [ErrandId=" + ErrandsId + ", summary=" + summary + ", priority=" + priority + ", deadline="
				+ deadline + ", myList=" + myList + ", status=" + status + "]";
	}

}
