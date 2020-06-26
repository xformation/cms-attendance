package com.synectiks.attendance.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the StudentAttendance entity.
 */
public class StudentAttendanceDTO implements Serializable {

    private Long id;

    private String attendanceStatus;

    private String comments;

    private Long lectureId;

    private Long studentId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StudentAttendanceDTO studentAttendanceDTO = (StudentAttendanceDTO) o;
        if (studentAttendanceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), studentAttendanceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StudentAttendanceDTO{" +
            "id=" + getId() +
            ", attendanceStatus='" + getAttendanceStatus() + "'" +
            ", comments='" + getComments() + "'" +
            ", lectureId=" + getLectureId() +
            ", studentId=" + getStudentId() +
            "}";
    }
}
