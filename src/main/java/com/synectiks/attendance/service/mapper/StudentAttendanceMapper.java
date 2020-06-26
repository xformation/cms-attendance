package com.synectiks.attendance.service.mapper;

import com.synectiks.attendance.domain.*;
import com.synectiks.attendance.service.dto.StudentAttendanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StudentAttendance and its DTO StudentAttendanceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StudentAttendanceMapper extends EntityMapper<StudentAttendanceDTO, StudentAttendance> {



    default StudentAttendance fromId(Long id) {
        if (id == null) {
            return null;
        }
        StudentAttendance studentAttendance = new StudentAttendance();
        studentAttendance.setId(id);
        return studentAttendance;
    }
}
