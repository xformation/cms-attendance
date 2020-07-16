package com.synectiks.attendance.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.google.common.collect.Lists;
import com.synectiks.attendance.business.service.CmsStudentAttendanceService;
import com.synectiks.attendance.domain.QueryResult;
import com.synectiks.attendance.domain.vo.StudentAttendanceVo;
import com.synectiks.attendance.filter.StudentAttendance.StudentAttendanceFilterImpl;
import com.synectiks.attendance.filter.StudentAttendance.StudentAttendanceFilterInput;
import com.synectiks.attendance.filter.StudentAttendance.StudentAttendanceUpdateFilter;
import com.synectiks.attendance.graphql.types.StudentAttendance.StudentAttendanceInput;
import com.synectiks.attendance.graphql.types.StudentAttendance.StudentAttendancePayload;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final static Logger logger = LoggerFactory.getLogger(Mutation.class);

    @Autowired
    private StudentAttendanceFilterImpl studentAttendanceFilterImpl;

    @Autowired
    CmsStudentAttendanceService cmsStudentAttendanceService;

    public QueryResult updateStudentAttendanceData(List<StudentAttendanceUpdateFilter> list) throws JSONException, ParseException {
        logger.debug("Mutation to update student attendance data " + list.toString());
        QueryResult res = this.studentAttendanceFilterImpl.updateStudentStatus(list);
        if(res.getStatusCode() == 0) {
            logger.info("Student attendance data updated successfully.");
        }else {
            logger.info("Due to some error student attendance data could not be updated successfully.");
        }
        return res;
    }

    public List<StudentAttendanceVo> getDailyStudentAttendanceData(StudentAttendanceFilterInput filter) throws Exception {
        return Lists.newArrayList(studentAttendanceFilterImpl.getStudenceAttendanceDataForTeacher(filter));
    }

    public List<StudentAttendanceVo> getStudentAttendanceDataForAdmin(StudentAttendanceFilterInput filter) throws Exception {
        return Lists.newArrayList(studentAttendanceFilterImpl.getStudenceAttendanceDataForAdmin(filter));
    }

    public StudentAttendancePayload addStudentAttendance(StudentAttendanceInput cmsStudentAttendance) {
        StudentAttendanceVo vo = this.cmsStudentAttendanceService.addStudentAttendance(cmsStudentAttendance);
        return new StudentAttendancePayload(vo);
    }
}
