package com.synectiks.attendance.graphql.types.StudentAttendance;

import com.synectiks.attendance.domain.vo.StudentAttendanceVo;

public class StudentAttendancePayload {
    private final StudentAttendanceVo studentAttendanceVo;

    public StudentAttendancePayload(StudentAttendanceVo studentAttendanceVo) {
        this.studentAttendanceVo = studentAttendanceVo;
    }

    public StudentAttendanceVo getStudentAttendanceVo() {
        return studentAttendanceVo;
    }
}
