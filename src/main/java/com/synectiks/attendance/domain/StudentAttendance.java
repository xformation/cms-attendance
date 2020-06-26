package com.synectiks.attendance.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A StudentAttendance.
 */
@Entity
@Table(name = "student_attendance")
public class StudentAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "attendance_status")
    private String attendanceStatus;

    @Column(name = "comments")
    private String comments;

    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "student_id")
    private Long studentId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public StudentAttendance attendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
        return this;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getComments() {
        return comments;
    }

    public StudentAttendance comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public StudentAttendance lectureId(Long lectureId) {
        this.lectureId = lectureId;
        return this;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public StudentAttendance studentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentAttendance studentAttendance = (StudentAttendance) o;
        if (studentAttendance.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), studentAttendance.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StudentAttendance{" +
            "id=" + getId() +
            ", attendanceStatus='" + getAttendanceStatus() + "'" +
            ", comments='" + getComments() + "'" +
            ", lectureId=" + getLectureId() +
            ", studentId=" + getStudentId() +
            "}";
    }
}
