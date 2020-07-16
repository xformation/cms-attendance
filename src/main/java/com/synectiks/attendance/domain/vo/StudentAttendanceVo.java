package com.synectiks.attendance.domain.vo;

import com.synectiks.attendance.domain.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceVo extends CmsCommonVo implements Serializable {
    private Long id;
    private Long studentId;
    private String studentName;
    private String attendanceStatus;
    private String currentDateStatus;
    private String previousOneDayStatus;
    private String previousTwoDayStatus;
    private String previousThreeDayStatus;
    private String comments;
    private Student student;
    private Long lectureId;
    private List<StudentAttendanceVo> dataList = new ArrayList<StudentAttendanceVo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getAttendanceStatus() {
        return attendanceStatus;
    }
    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getCurrentDateStatus() {
        return currentDateStatus;
    }
    public void setCurrentDateStatus(String currentDateStatus) {
        this.currentDateStatus = currentDateStatus;
    }
    public String getPreviousOneDayStatus() {
        return previousOneDayStatus;
    }
    public void setPreviousOneDayStatus(String previousOneDayStatus) {
        this.previousOneDayStatus = previousOneDayStatus;
    }
    public String getPreviousTwoDayStatus() {
        return previousTwoDayStatus;
    }
    public void setPreviousTwoDayStatus(String previousTwoDayStatus) {
        this.previousTwoDayStatus = previousTwoDayStatus;
    }
    public String getPreviousThreeDayStatus() {
        return previousThreeDayStatus;
    }
    public void setPreviousThreeDayStatus(String previousThreeDayStatus) {
        this.previousThreeDayStatus = previousThreeDayStatus;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentAttendanceVo> getDataList() {
        return dataList;
    }

    public void setDataList(List<StudentAttendanceVo> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "StudentAttendanceVo{" +
            "id=" + id +
            ", studentId=" + studentId +
            ", studentName='" + studentName + '\'' +
            ", attendanceStatus='" + attendanceStatus + '\'' +
            ", currentDateStatus='" + currentDateStatus + '\'' +
            ", previousOneDayStatus='" + previousOneDayStatus + '\'' +
            ", previousTwoDayStatus='" + previousTwoDayStatus + '\'' +
            ", previousThreeDayStatus='" + previousThreeDayStatus + '\'' +
            ", comments='" + comments + '\'' +
            ", student=" + student +
            ", lectureId=" + lectureId +
            '}';
    }
}
