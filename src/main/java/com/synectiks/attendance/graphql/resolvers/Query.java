package com.synectiks.attendance.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.synectiks.attendance.business.service.CmsStudentAttendanceService;
import com.synectiks.attendance.business.service.CommonService;
import com.synectiks.attendance.domain.*;
import com.synectiks.attendance.domain.vo.CmsLectureVo;
import com.synectiks.attendance.domain.vo.CmsTermVo;
import com.synectiks.attendance.domain.vo.StudentAttendanceVo;
import com.synectiks.attendance.filter.StudentAttendance.StudentAttendanceFilterImpl;
import com.synectiks.attendance.repository.StudentAttendanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final static Logger logger = LoggerFactory.getLogger(Query.class);
    private final StudentAttendanceRepository studentAttendanceRepository;

    public Query(StudentAttendanceRepository studentAttendanceRepository) {
        this.studentAttendanceRepository = studentAttendanceRepository;
    }

    @Autowired
    private StudentAttendanceFilterImpl studentAttendanceFilterImpl;

    @Autowired
    private CommonService commonService;

    @Autowired
    private CmsStudentAttendanceService cmsStudentAttendanceService;


    public StudentAttendanceCache createStudentAttendanceCache(String branchId, String academicYearId, String teacherId, String lectureDate) throws Exception{
        StudentAttendanceCache cache = new StudentAttendanceCache();
        if(branchId == null || "null".equalsIgnoreCase(branchId) || "undefined".equalsIgnoreCase(branchId)
            || academicYearId == null || "null".equalsIgnoreCase(academicYearId) || "undefined".equalsIgnoreCase(academicYearId)
            || teacherId == null || "null".equalsIgnoreCase(teacherId) || "undefined".equalsIgnoreCase(teacherId)) {

            logger.warn("Either branch/academic year or teacher id is null. Return empty cache");
//    		cache.setDepartments(new ArrayList<Department>());
            cache.setBatches(new ArrayList<Batch>());
            cache.setSubjects(new ArrayList<Subject>());
            cache.setSections(new ArrayList<Section>());
            cache.setLectures(new ArrayList<CmsLectureVo>());
//            cache.setSemesters(new ArrayList<CmsSemesterVo>());
            cache.setTerms(new ArrayList<CmsTermVo>());
            cache.setAttendanceMasters(new ArrayList<AttendanceMaster>());
            return cache;
        }

//    	Teacher thr = new Teacher();
//        thr.setTeacherEmailAddress(teacherId);
//    	Optional<Teacher> oth = this.teacherRepository.findOne(Example.of(thr));
//        Long tid = oth.isPresent() ? oth.get().getId() : 0;

        Teacher thr = this.commonService.getTeacherByEmail(teacherId);
        Long tid = (thr != null) ? thr.getId() : 0;

        if(Long.parseLong(branchId) == 0 || Long.parseLong(academicYearId) == 0 || tid == 0) {
            logger.warn("Either branch/academic year or teacher id is not provided. Return empty cache");
//    		cache.setDepartments(new ArrayList<Department>());
            cache.setBatches(new ArrayList<Batch>());
            cache.setSubjects(new ArrayList<Subject>());
            cache.setSections(new ArrayList<Section>());
            cache.setLectures(new ArrayList<CmsLectureVo>());
//            cache.setSemesters(new ArrayList<CmsSemesterVo>());
            cache.setTerms(new ArrayList<CmsTermVo>());
            cache.setAttendanceMasters(new ArrayList<AttendanceMaster>());
            cache.setTeaches(new ArrayList<Teach>());
            return cache;
        }

//    	List<Department> dept = this.commonService.getDepartmentsByBranchAndAcademicYear(Long.parseLong(branchId), Long.parseLong(academicYearId));
        List<Batch> batchList = this.commonService.getAllBatches();// getBatchForCriteria(dept); //batches();
        List<Subject> subjectList = this.commonService.getAllSubject(); //getSubjectForCriteria(dept, bth); //subjects();
        List<Section> sectionList = this.commonService.getAllSections(); // getSectionForCriteria(bth); //sections();
        List<Teach> teachList = this.commonService.getAllTeach(); //getTeachForCriteria(sub, tid); //teaches();
        List<AttendanceMaster> attendanceMasterList = this.commonService.getAllAttendanceMaster(); //   getAttendanceMasterForCriteria(bth, sec, teach);// attendanceMasters();
        List<Subject> selectedSubjectList = new ArrayList<>();

        for(Subject subject: subjectList) {
            for(Teach th: teachList) {
                logger.debug("Subject id : "+subject.getId()+", teach-subject id : "+th.getSubject().getId());
                if(subject.getId().compareTo(th.getSubject().getId()) == 0 ) {
                    logger.debug("Selected subject id : "+subject.toString());
                    selectedSubjectList.add(subject);
                }

            }
        }


//    	List<Lecture> lec =  this.commonService.getLectureForCriteria(attendanceMasterList, lectureDate); //lectures();
//    	List<CmsLectureVo> cmsLec = new ArrayList<>();
//    	for(Lecture lecture : lec) {
//    		CmsLectureVo vo = CommonUtil.createCopyProperties(lecture, CmsLectureVo.class);
//    		vo.setStrLecDate(DateFormatUtil.changeLocalDateFormat(lecture.getLecDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
//    		vo.setLecDate(null);
//    		cmsLec.add(vo);
//    	}

        List<CmsLectureVo> cmsLec = this.commonService.getAllCurrentDateCmsLectureForTeacher(tid, lectureDate);

//        List<CmsSemesterVo> sem = this.commonService.getAllCmsSemesters();

//    	cache.setDepartments(dept);
        cache.setBatches(batchList);
        cache.setSubjects(selectedSubjectList);
        cache.setSections(sectionList);
        cache.setLectures(cmsLec);
//        cache.setSemesters(sem);
        cache.setTeaches(teachList);
        cache.setAttendanceMasters(attendanceMasterList);
        return cache;
    }


    /**
     * Cache for admin attendance
     * @param branchId
     * @param academicYearId
     * @param lectureDate
     * @return
     * @throws Exception
     */
    public StudentAttendanceCache createStudentAttendanceCacheForAdmin(String branchId, String departmentId, String academicYearId, String lectureDate) throws Exception{
        StudentAttendanceCache cache = new StudentAttendanceCache();
        if(branchId == null || "null".equalsIgnoreCase(branchId) || "undefined".equalsIgnoreCase(branchId)
            || academicYearId == null || "null".equalsIgnoreCase(academicYearId) || "undefined".equalsIgnoreCase(academicYearId)) {
            logger.warn("Either branch or academic year id is null. Return empty cache");
//    		cache.setDepartments(new ArrayList<Department>());
            cache.setBatches(new ArrayList<Batch>());
            cache.setSubjects(new ArrayList<Subject>());
            cache.setSections(new ArrayList<Section>());
            cache.setLectures(new ArrayList<CmsLectureVo>());
//            cache.setSemesters(new ArrayList<CmsSemesterVo>());
            cache.setTerms(new ArrayList<CmsTermVo>());
            cache.setAttendanceMasters(new ArrayList<AttendanceMaster>());
            return cache;
        }
        if(Long.parseLong(branchId) == 0 || Long.parseLong(academicYearId) == 0) {
            logger.warn("Either branch or academic year id is not provided. Return empty cache");
//    		cache.setDepartments(new ArrayList<Department>());
            cache.setBatches(new ArrayList<Batch>());
            cache.setSubjects(new ArrayList<Subject>());
            cache.setSections(new ArrayList<Section>());
            cache.setLectures(new ArrayList<CmsLectureVo>());
//            cache.setSemesters(new ArrayList<CmsSemesterVo>());
            cache.setTerms(new ArrayList<CmsTermVo>());
            cache.setAttendanceMasters(new ArrayList<AttendanceMaster>());
            return cache;
        }

//        List<Department> dept = this.commonService.getDepartmentsByBranchAndAcademicYear(Long.parseLong(branchId), Long.parseLong(academicYearId));
        List<Batch> bth = this.commonService.getAllBatches(); //getBatchForCriteria(dept);
        List<Subject> sub = this.commonService.getAllSubject(); //getSubjectForCriteria(dept, bth);
        List<Section> sec = this.commonService.getAllSections();// getSectionForCriteria(bth);
        List<AttendanceMaster> attendanceMaster = this.commonService.getAllAttendanceMaster();     //getAttendanceMasterForCriteria(bth, sec);
        List<CmsTermVo> term = this.commonService.getTermsByAcademicYear(Long.parseLong(academicYearId));

//    	List<Lecture> lec =  this.commonService.getLectureForAdminCriteria(attendanceMaster);
//    	List<CmsLectureVo> cmsLec = new ArrayList<>();
//    	for(Lecture lecture : lec) {
//    		CmsLectureVo vo = CommonUtil.createCopyProperties(lecture, CmsLectureVo.class);
//    		vo.setStrLecDate(DateFormatUtil.changeLocalDateFormat(lecture.getLecDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
//    		//            vo.setStrLecDate(DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_yyyy_MM_dd, DateFormatUtil.converUtilDateFromLocaDate(lecture.getLecDate()))));
//    		vo.setLecDate(null);
//    		cmsLec.add(vo);
//    	}

        List<CmsLectureVo> cmsLec = this.commonService.getAllCmsLectures(Long.parseLong(branchId), Long.parseLong(departmentId), Long.parseLong(academicYearId));


//        List<CmsSemesterVo> sem = this.commonService.getAllCmsSemesters();

//    	cache.setDepartments(dept);
        cache.setBatches(bth);
        cache.setSubjects(sub);
        cache.setSections(sec);
        cache.setLectures(cmsLec);
//        cache.setSemesters(sem);
//    	cache.setTeaches(teach);
        cache.setTerms(term);
        cache.setAttendanceMasters(attendanceMaster);
        return cache;
    }

    public List<StudentAttendanceVo> getStudentAttendanceList() throws Exception {
        logger.debug("Query - getStudentAttendanceList :");
        return this.cmsStudentAttendanceService.getStudentAttendanceList();
    }


}
