package com.synectiks.attendance.service;

import com.synectiks.attendance.service.dto.StudentAttendanceDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing StudentAttendance.
 */
public interface StudentAttendanceService {

    /**
     * Save a studentAttendance.
     *
     * @param studentAttendanceDTO the entity to save
     * @return the persisted entity
     */
    StudentAttendanceDTO save(StudentAttendanceDTO studentAttendanceDTO);

    /**
     * Get all the studentAttendances.
     *
     * @return the list of entities
     */
    List<StudentAttendanceDTO> findAll();


    /**
     * Get the "id" studentAttendance.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<StudentAttendanceDTO> findOne(Long id);

    /**
     * Delete the "id" studentAttendance.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
