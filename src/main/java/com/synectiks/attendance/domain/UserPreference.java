package com.synectiks.attendance.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A UserPreference.
 */
@Entity
@Table(name = "user_preference")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserPreference implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "academic_year_id")
    private Long academicYearId;

    @Column(name = "college_id")
    private Long collegeId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "batch_id")
    private Long batchId;

    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "class_id")
    private Long classId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public UserPreference userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAcademicYearId() {
        return academicYearId;
    }

    public UserPreference academicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
        return this;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public UserPreference collegeId(Long collegeId) {
        this.collegeId = collegeId;
        return this;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public UserPreference branchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public UserPreference departmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public UserPreference courseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public UserPreference semesterId(Long semesterId) {
        this.semesterId = semesterId;
        return this;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public UserPreference batchId(Long batchId) {
        this.batchId = batchId;
        return this;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public UserPreference sectionId(Long sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getClassId() {
        return classId;
    }

    public UserPreference classId(Long classId) {
        this.classId = classId;
        return this;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserPreference)) {
            return false;
        }
        return id != null && id.equals(((UserPreference) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", academicYearId=" + getAcademicYearId() +
            ", collegeId=" + getCollegeId() +
            ", branchId=" + getBranchId() +
            ", departmentId=" + getDepartmentId() +
            ", courseId=" + getCourseId() +
            ", semesterId=" + getSemesterId() +
            ", batchId=" + getBatchId() +
            ", sectionId=" + getSectionId() +
            ", classId=" + getClassId() +
            "}";
    }
}
