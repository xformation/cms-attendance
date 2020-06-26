package com.synectiks.attendance.service.impl;

import com.synectiks.attendance.service.StudentAttendanceService;
import com.synectiks.attendance.domain.StudentAttendance;
import com.synectiks.attendance.repository.StudentAttendanceRepository;
import com.synectiks.attendance.service.dto.StudentAttendanceDTO;
import com.synectiks.attendance.service.mapper.StudentAttendanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing StudentAttendance.
 */
@Service
@Transactional
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private final Logger log = LoggerFactory.getLogger(StudentAttendanceServiceImpl.class);

    private final StudentAttendanceRepository studentAttendanceRepository;

    private final StudentAttendanceMapper studentAttendanceMapper;

    public StudentAttendanceServiceImpl(StudentAttendanceRepository studentAttendanceRepository, StudentAttendanceMapper studentAttendanceMapper) {
        this.studentAttendanceRepository = studentAttendanceRepository;
        this.studentAttendanceMapper = studentAttendanceMapper;
    }

    /**
     * Save a studentAttendance.
     *
     * @param studentAttendanceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public StudentAttendanceDTO save(StudentAttendanceDTO studentAttendanceDTO) {
        log.debug("Request to save StudentAttendance : {}", studentAttendanceDTO);
        StudentAttendance studentAttendance = studentAttendanceMapper.toEntity(studentAttendanceDTO);
        studentAttendance = studentAttendanceRepository.save(studentAttendance);
        return studentAttendanceMapper.toDto(studentAttendance);
    }

    /**
     * Get all the studentAttendances.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentAttendanceDTO> findAll() {
        log.debug("Request to get all StudentAttendances");
        return studentAttendanceRepository.findAll().stream()
            .map(studentAttendanceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one studentAttendance by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StudentAttendanceDTO> findOne(Long id) {
        log.debug("Request to get StudentAttendance : {}", id);
        return studentAttendanceRepository.findById(id)
            .map(studentAttendanceMapper::toDto);
    }

    /**
     * Delete the studentAttendance by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StudentAttendance : {}", id);
        studentAttendanceRepository.deleteById(id);
    }
}
