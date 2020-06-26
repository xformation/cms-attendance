package com.synectiks.attendance.web.rest;
import com.synectiks.attendance.service.StudentAttendanceService;
import com.synectiks.attendance.web.rest.errors.BadRequestAlertException;
import com.synectiks.attendance.web.rest.util.HeaderUtil;
import com.synectiks.attendance.service.dto.StudentAttendanceDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing StudentAttendance.
 */
@RestController
@RequestMapping("/api")
public class StudentAttendanceResource {

    private final Logger log = LoggerFactory.getLogger(StudentAttendanceResource.class);

    private static final String ENTITY_NAME = "attendanceStudentAttendance";

    private final StudentAttendanceService studentAttendanceService;

    public StudentAttendanceResource(StudentAttendanceService studentAttendanceService) {
        this.studentAttendanceService = studentAttendanceService;
    }

    /**
     * POST  /student-attendances : Create a new studentAttendance.
     *
     * @param studentAttendanceDTO the studentAttendanceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new studentAttendanceDTO, or with status 400 (Bad Request) if the studentAttendance has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/student-attendances")
    public ResponseEntity<StudentAttendanceDTO> createStudentAttendance(@RequestBody StudentAttendanceDTO studentAttendanceDTO) throws URISyntaxException {
        log.debug("REST request to save StudentAttendance : {}", studentAttendanceDTO);
        if (studentAttendanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new studentAttendance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StudentAttendanceDTO result = studentAttendanceService.save(studentAttendanceDTO);
        return ResponseEntity.created(new URI("/api/student-attendances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /student-attendances : Updates an existing studentAttendance.
     *
     * @param studentAttendanceDTO the studentAttendanceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated studentAttendanceDTO,
     * or with status 400 (Bad Request) if the studentAttendanceDTO is not valid,
     * or with status 500 (Internal Server Error) if the studentAttendanceDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/student-attendances")
    public ResponseEntity<StudentAttendanceDTO> updateStudentAttendance(@RequestBody StudentAttendanceDTO studentAttendanceDTO) throws URISyntaxException {
        log.debug("REST request to update StudentAttendance : {}", studentAttendanceDTO);
        if (studentAttendanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StudentAttendanceDTO result = studentAttendanceService.save(studentAttendanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, studentAttendanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /student-attendances : get all the studentAttendances.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of studentAttendances in body
     */
    @GetMapping("/student-attendances")
    public List<StudentAttendanceDTO> getAllStudentAttendances() {
        log.debug("REST request to get all StudentAttendances");
        return studentAttendanceService.findAll();
    }

    /**
     * GET  /student-attendances/:id : get the "id" studentAttendance.
     *
     * @param id the id of the studentAttendanceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the studentAttendanceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/student-attendances/{id}")
    public ResponseEntity<StudentAttendanceDTO> getStudentAttendance(@PathVariable Long id) {
        log.debug("REST request to get StudentAttendance : {}", id);
        Optional<StudentAttendanceDTO> studentAttendanceDTO = studentAttendanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(studentAttendanceDTO);
    }

    /**
     * DELETE  /student-attendances/:id : delete the "id" studentAttendance.
     *
     * @param id the id of the studentAttendanceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/student-attendances/{id}")
    public ResponseEntity<Void> deleteStudentAttendance(@PathVariable Long id) {
        log.debug("REST request to delete StudentAttendance : {}", id);
        studentAttendanceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
