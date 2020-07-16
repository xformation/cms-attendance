package com.synectiks.attendance.domain;
import java.io.Serializable;

public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String batch;
    private Department department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
