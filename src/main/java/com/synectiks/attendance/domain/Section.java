package com.synectiks.attendance.domain;
import java.io.Serializable;

public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String section;
    private Batch batch;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}


}
