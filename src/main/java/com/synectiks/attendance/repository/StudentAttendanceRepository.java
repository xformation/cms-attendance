package com.synectiks.attendance.repository;

import com.synectiks.attendance.domain.StudentAttendance;
import com.synectiks.attendance.utils.JPASearchRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the StudentAttendance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StudentAttendanceRepository extends JPASearchRepository<StudentAttendance, Long> {

}
