package com.synectiks.attendance.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

public class AttendanceMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String desc;
    private Batch batch;
    private Section section;
    private Teach teach;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public AttendanceMaster desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Batch getBatch() {
        return batch;
    }

    public AttendanceMaster batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Section getSection() {
        return section;
    }

    public AttendanceMaster section(Section section) {
        this.section = section;
        return this;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Teach getTeach() {
        return teach;
    }

    public AttendanceMaster teach(Teach teach) {
        this.teach = teach;
        return this;
    }

    public void setTeach(Teach teach) {
        this.teach = teach;
    }


    @Override
    public String toString() {
        return "AttendanceMaster{" +
            "id=" + getId() +
            ", desc='" + getDesc() + "'" +
            "}";
    }
}
