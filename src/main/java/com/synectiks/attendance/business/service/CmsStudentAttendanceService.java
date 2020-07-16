package com.synectiks.attendance.business.service;

import com.synectiks.attendance.config.ApplicationProperties;
import com.synectiks.attendance.domain.StudentAttendance;
import com.synectiks.attendance.domain.vo.StudentAttendanceVo;
import com.synectiks.attendance.graphql.types.StudentAttendance.StudentAttendanceInput;
import com.synectiks.attendance.repository.StudentAttendanceRepository;
import com.synectiks.attendance.service.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class CmsStudentAttendanceService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationProperties applicationProperties;

    public List<StudentAttendanceVo> getStudentAttendanceList(){
        List<StudentAttendance> list = this.studentAttendanceRepository.findAll();
        List<StudentAttendanceVo> ls = changeStudentAttendanceToCmsStudentAttendanceList(list);
        logger.debug("Student Attendance list : "+list);
        return ls;
    }

    public StudentAttendance getStudentAttendance(Long id){
        Optional<StudentAttendance> lb = this.studentAttendanceRepository.findById(id);
        if(lb.isPresent()) {
            logger.debug("StudentAttendance object found for given id : "+id+". StudentAttendance object : "+lb.get());
            return lb.get();
        }
        logger.debug("StudentAttendance object not found for the given id. "+id+". Returning null");
        return null;
    }

    public List<StudentAttendanceVo> getCmsStudentAttendanceList(){
        List<StudentAttendance> list = this.studentAttendanceRepository.findAll();
        List<StudentAttendanceVo> ls = changeStudentAttendanceToCmsStudentAttendanceList(list);
        Collections.sort(ls, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        logger.debug("CmsLibrary list : "+list);
        return ls;
    }

    public StudentAttendanceVo getCmsStudentAttendance(Long id){
        Optional<StudentAttendance> lb = this.studentAttendanceRepository.findById(id);
        if(lb.isPresent()) {
            StudentAttendanceVo vo = CommonUtil.createCopyProperties(lb.get(), StudentAttendanceVo.class);
            logger.debug("CmsStudentAttendance for given id : "+id+". CmsStudentAttendance object : "+vo);
            return vo;
        }
        logger.debug("StudentAttendance object not found for the given id. "+id+". Returning null object");
        return null;
    }

    private List<StudentAttendanceVo> changeStudentAttendanceToCmsStudentAttendanceList(List<StudentAttendance> list) {
        List<StudentAttendanceVo> ls = new ArrayList<>();
        for (StudentAttendance lb : list) {
            StudentAttendanceVo vo = CommonUtil.createCopyProperties(lb, StudentAttendanceVo.class);
            ls.add(vo);
        }
        return ls;
    }

    public StudentAttendanceVo addStudentAttendance(StudentAttendanceInput input) {
        logger.info("Saving studentAttendance");
        StudentAttendanceVo vo = null;
        try {
            StudentAttendance studentAttendance = null;
            if (input.getId() == null) {
                logger.debug("Adding new StudentAttendance");
                studentAttendance = CommonUtil.createCopyProperties(input, StudentAttendance.class);
            } else {
                logger.debug("Updating existing Library");
                studentAttendance = this.studentAttendanceRepository.findById(input.getId()).get();
            }
            studentAttendance.setAttendanceStatus(input.getAttendanceStatus());
            studentAttendance.setComments(input.getComments());
            studentAttendance.setLectureId(input.getLectureId());
            studentAttendance.setStudentId(input.getStudentId());
            studentAttendance = this.studentAttendanceRepository.save(studentAttendance);
            vo = CommonUtil.createCopyProperties(studentAttendance, StudentAttendanceVo.class);
            vo.setExitCode(0L);
            if (input.getId() == null) {
                vo.setExitDescription("studentAttendance is added successfully");
                logger.debug("studentAttendance is added successfully");
            } else {
                vo.setExitDescription("studentAttendance is updated successfully");
                logger.debug("studentAttendance is updated successfully");
            }

        } catch (Exception e) {
            vo = new StudentAttendanceVo();
            vo.setExitCode(1L);
            vo.setExitDescription("Due to some exception, studentAttendance data not be saved");
            logger.error("StudentAttendance save failed. Exception : ", e);
        }
        logger.info("StudentAttendance saved successfully");
        List ls = getStudentAttendanceList();
        vo.setDataList(ls);
        return vo;
    }
}
