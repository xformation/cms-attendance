package com.synectiks.attendance.web.rest;

import com.synectiks.attendance.AttendanceApp;

import com.synectiks.attendance.domain.StudentAttendance;
import com.synectiks.attendance.repository.StudentAttendanceRepository;
import com.synectiks.attendance.service.StudentAttendanceService;
import com.synectiks.attendance.service.dto.StudentAttendanceDTO;
import com.synectiks.attendance.service.mapper.StudentAttendanceMapper;
import com.synectiks.attendance.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;


import static com.synectiks.attendance.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the StudentAttendanceResource REST controller.
 *
 * @see StudentAttendanceResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AttendanceApp.class)
public class StudentAttendanceResourceIntTest {

    private static final String DEFAULT_ATTENDANCE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ATTENDANCE_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS = "BBBBBBBBBB";

    private static final Long DEFAULT_LECTURE_ID = 1L;
    private static final Long UPDATED_LECTURE_ID = 2L;

    private static final Long DEFAULT_STUDENT_ID = 1L;
    private static final Long UPDATED_STUDENT_ID = 2L;

    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;

    @Autowired
    private StudentAttendanceMapper studentAttendanceMapper;

    @Autowired
    private StudentAttendanceService studentAttendanceService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restStudentAttendanceMockMvc;

    private StudentAttendance studentAttendance;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StudentAttendanceResource studentAttendanceResource = new StudentAttendanceResource(studentAttendanceService);
        this.restStudentAttendanceMockMvc = MockMvcBuilders.standaloneSetup(studentAttendanceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static StudentAttendance createEntity(EntityManager em) {
        StudentAttendance studentAttendance = new StudentAttendance()
            .attendanceStatus(DEFAULT_ATTENDANCE_STATUS)
            .comments(DEFAULT_COMMENTS)
            .lectureId(DEFAULT_LECTURE_ID)
            .studentId(DEFAULT_STUDENT_ID);
        return studentAttendance;
    }

    @Before
    public void initTest() {
        studentAttendance = createEntity(em);
    }

    @Test
    @Transactional
    public void createStudentAttendance() throws Exception {
        int databaseSizeBeforeCreate = studentAttendanceRepository.findAll().size();

        // Create the StudentAttendance
        StudentAttendanceDTO studentAttendanceDTO = studentAttendanceMapper.toDto(studentAttendance);
        restStudentAttendanceMockMvc.perform(post("/api/student-attendances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(studentAttendanceDTO)))
            .andExpect(status().isCreated());

        // Validate the StudentAttendance in the database
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepository.findAll();
        assertThat(studentAttendanceList).hasSize(databaseSizeBeforeCreate + 1);
        StudentAttendance testStudentAttendance = studentAttendanceList.get(studentAttendanceList.size() - 1);
        assertThat(testStudentAttendance.getAttendanceStatus()).isEqualTo(DEFAULT_ATTENDANCE_STATUS);
        assertThat(testStudentAttendance.getComments()).isEqualTo(DEFAULT_COMMENTS);
        assertThat(testStudentAttendance.getLectureId()).isEqualTo(DEFAULT_LECTURE_ID);
        assertThat(testStudentAttendance.getStudentId()).isEqualTo(DEFAULT_STUDENT_ID);
    }

    @Test
    @Transactional
    public void createStudentAttendanceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = studentAttendanceRepository.findAll().size();

        // Create the StudentAttendance with an existing ID
        studentAttendance.setId(1L);
        StudentAttendanceDTO studentAttendanceDTO = studentAttendanceMapper.toDto(studentAttendance);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStudentAttendanceMockMvc.perform(post("/api/student-attendances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(studentAttendanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StudentAttendance in the database
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepository.findAll();
        assertThat(studentAttendanceList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllStudentAttendances() throws Exception {
        // Initialize the database
        studentAttendanceRepository.saveAndFlush(studentAttendance);

        // Get all the studentAttendanceList
        restStudentAttendanceMockMvc.perform(get("/api/student-attendances?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(studentAttendance.getId().intValue())))
            .andExpect(jsonPath("$.[*].attendanceStatus").value(hasItem(DEFAULT_ATTENDANCE_STATUS.toString())))
            .andExpect(jsonPath("$.[*].comments").value(hasItem(DEFAULT_COMMENTS.toString())))
            .andExpect(jsonPath("$.[*].lectureId").value(hasItem(DEFAULT_LECTURE_ID.intValue())))
            .andExpect(jsonPath("$.[*].studentId").value(hasItem(DEFAULT_STUDENT_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getStudentAttendance() throws Exception {
        // Initialize the database
        studentAttendanceRepository.saveAndFlush(studentAttendance);

        // Get the studentAttendance
        restStudentAttendanceMockMvc.perform(get("/api/student-attendances/{id}", studentAttendance.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(studentAttendance.getId().intValue()))
            .andExpect(jsonPath("$.attendanceStatus").value(DEFAULT_ATTENDANCE_STATUS.toString()))
            .andExpect(jsonPath("$.comments").value(DEFAULT_COMMENTS.toString()))
            .andExpect(jsonPath("$.lectureId").value(DEFAULT_LECTURE_ID.intValue()))
            .andExpect(jsonPath("$.studentId").value(DEFAULT_STUDENT_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingStudentAttendance() throws Exception {
        // Get the studentAttendance
        restStudentAttendanceMockMvc.perform(get("/api/student-attendances/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStudentAttendance() throws Exception {
        // Initialize the database
        studentAttendanceRepository.saveAndFlush(studentAttendance);

        int databaseSizeBeforeUpdate = studentAttendanceRepository.findAll().size();

        // Update the studentAttendance
        StudentAttendance updatedStudentAttendance = studentAttendanceRepository.findById(studentAttendance.getId()).get();
        // Disconnect from session so that the updates on updatedStudentAttendance are not directly saved in db
        em.detach(updatedStudentAttendance);
        updatedStudentAttendance
            .attendanceStatus(UPDATED_ATTENDANCE_STATUS)
            .comments(UPDATED_COMMENTS)
            .lectureId(UPDATED_LECTURE_ID)
            .studentId(UPDATED_STUDENT_ID);
        StudentAttendanceDTO studentAttendanceDTO = studentAttendanceMapper.toDto(updatedStudentAttendance);

        restStudentAttendanceMockMvc.perform(put("/api/student-attendances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(studentAttendanceDTO)))
            .andExpect(status().isOk());

        // Validate the StudentAttendance in the database
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepository.findAll();
        assertThat(studentAttendanceList).hasSize(databaseSizeBeforeUpdate);
        StudentAttendance testStudentAttendance = studentAttendanceList.get(studentAttendanceList.size() - 1);
        assertThat(testStudentAttendance.getAttendanceStatus()).isEqualTo(UPDATED_ATTENDANCE_STATUS);
        assertThat(testStudentAttendance.getComments()).isEqualTo(UPDATED_COMMENTS);
        assertThat(testStudentAttendance.getLectureId()).isEqualTo(UPDATED_LECTURE_ID);
        assertThat(testStudentAttendance.getStudentId()).isEqualTo(UPDATED_STUDENT_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingStudentAttendance() throws Exception {
        int databaseSizeBeforeUpdate = studentAttendanceRepository.findAll().size();

        // Create the StudentAttendance
        StudentAttendanceDTO studentAttendanceDTO = studentAttendanceMapper.toDto(studentAttendance);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStudentAttendanceMockMvc.perform(put("/api/student-attendances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(studentAttendanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StudentAttendance in the database
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepository.findAll();
        assertThat(studentAttendanceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteStudentAttendance() throws Exception {
        // Initialize the database
        studentAttendanceRepository.saveAndFlush(studentAttendance);

        int databaseSizeBeforeDelete = studentAttendanceRepository.findAll().size();

        // Delete the studentAttendance
        restStudentAttendanceMockMvc.perform(delete("/api/student-attendances/{id}", studentAttendance.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<StudentAttendance> studentAttendanceList = studentAttendanceRepository.findAll();
        assertThat(studentAttendanceList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StudentAttendance.class);
        StudentAttendance studentAttendance1 = new StudentAttendance();
        studentAttendance1.setId(1L);
        StudentAttendance studentAttendance2 = new StudentAttendance();
        studentAttendance2.setId(studentAttendance1.getId());
        assertThat(studentAttendance1).isEqualTo(studentAttendance2);
        studentAttendance2.setId(2L);
        assertThat(studentAttendance1).isNotEqualTo(studentAttendance2);
        studentAttendance1.setId(null);
        assertThat(studentAttendance1).isNotEqualTo(studentAttendance2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StudentAttendanceDTO.class);
        StudentAttendanceDTO studentAttendanceDTO1 = new StudentAttendanceDTO();
        studentAttendanceDTO1.setId(1L);
        StudentAttendanceDTO studentAttendanceDTO2 = new StudentAttendanceDTO();
        assertThat(studentAttendanceDTO1).isNotEqualTo(studentAttendanceDTO2);
        studentAttendanceDTO2.setId(studentAttendanceDTO1.getId());
        assertThat(studentAttendanceDTO1).isEqualTo(studentAttendanceDTO2);
        studentAttendanceDTO2.setId(2L);
        assertThat(studentAttendanceDTO1).isNotEqualTo(studentAttendanceDTO2);
        studentAttendanceDTO1.setId(null);
        assertThat(studentAttendanceDTO1).isNotEqualTo(studentAttendanceDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(studentAttendanceMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(studentAttendanceMapper.fromId(null)).isNull();
    }
}
