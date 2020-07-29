package com.synectiks.attendance.business.service;

import com.synectiks.attendance.config.ApplicationProperties;
import com.synectiks.attendance.constant.CmsConstants;
import com.synectiks.attendance.domain.*;
import com.synectiks.attendance.domain.vo.CmsLectureVo;
import com.synectiks.attendance.domain.vo.CmsTermVo;
import com.synectiks.attendance.service.util.CommonUtil;
import com.synectiks.attendance.service.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CommonService {

    private final static Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    RestTemplate restTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public Branch getBranchById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBranchUrl = prefUrl+"/api/branch-by-id/"+id;
        Branch temp = this.restTemplate.getForObject(prefBranchUrl, Branch.class);
        return temp;
    }

    public Branch findBranchById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBranchUrl = prefUrl+"/api/branch-by-id/"+id;
        Branch temp = this.restTemplate.getForObject(prefBranchUrl, Branch.class);
        return temp;
    }

    public List<Branch> findAllBranch() {
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBranchUrl = prefUrl+"/api/branch-by-filters";
        Branch[] temp = this.restTemplate.getForObject(prefBranchUrl, Branch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Branch> branchList = Arrays.asList(temp);
        Collections.sort(branchList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return branchList;
    }

    public Department getDepartmentById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefDepartmentUrl = prefUrl+"/api/department-by-id/"+id;
        Department temp = this.restTemplate.getForObject(prefDepartmentUrl, Department.class);
        return temp;
    }

    public List<Department> findAllDepartment() {
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefDepartmentUrl = prefUrl+"/api/department-by-filters";
        Department[] temp = this.restTemplate.getForObject(prefDepartmentUrl, Department[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Department> departmentList = Arrays.asList(temp);
        Collections.sort(departmentList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return departmentList;
    }

    public List<Department> findAllDepartmentByBranchAndAcademicYear(Long branchId, Long academicYearId) {
        logger.debug("Getting department based on branch id : "+branchId+", and academicYearId : "+academicYearId);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefDepartmentUrl = prefUrl+"/api/department-by-filters?branchId="+branchId+"&academicYearId="+academicYearId;
        Department[] temp = this.restTemplate.getForObject(prefDepartmentUrl, Department[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Department> departmentList = Arrays.asList(temp);
        Collections.sort(departmentList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return departmentList;
    }

    public Batch getBatchById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-id/"+id;
        Batch temp = this.restTemplate.getForObject(prefBatchUrl, Batch.class);
        return temp;
    }

    public List<Batch> findAllBatchByDepartment(Long departmentId) {
        logger.debug("Getting batch based on department id : "+departmentId);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-filters?departmentId="+departmentId;
        Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Batch> batchList = Arrays.asList(temp);
        Collections.sort(batchList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return batchList;
    }

    public List<Batch> findAllBatchByBatchAndDepartment(Long departmentId, Long batchId) {
        logger.debug("Getting batch based on department id : "+departmentId);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-filters?departmentId="+departmentId+"&id="+batchId;
        Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Batch> batchList = Arrays.asList(temp);
        Collections.sort(batchList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return batchList;
    }

    public List<Batch> getAllBatches() {
        logger.debug("Getting all Batches ");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-filters";
        Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Batch> batchList = Arrays.asList(temp);
        Collections.sort(batchList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return batchList;
    }
    public List<Batch> findAllBatches() {
        logger.debug("Retrieving all Batches ");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefBatchUrl = prefUrl+"/api/batch-by-filters";
        Batch[] temp = this.restTemplate.getForObject(prefBatchUrl, Batch[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Batch> batchList = Arrays.asList(temp);
        Collections.sort(batchList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return batchList;
    }

    public Section getSectionById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-id/"+id;
        Section temp = this.restTemplate.getForObject(prefSectionUrl, Section.class);
        return temp;
    }

    public List<Section> findAllSectionByBatch(Long batchId) {
        logger.debug("Getting section based on batch id : "+batchId);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-filters?batchId="+batchId;
        Section[] temp = this.restTemplate.getForObject(prefSectionUrl, Section[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Section> sectionList = Arrays.asList(temp);
        Collections.sort(sectionList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return sectionList;
    }

    public List<Section> findAllSectionByBatchAndSection(Long batchId, Long sectionId) {
        logger.debug("Getting section based on batch id : "+batchId);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-filters?batchId="+batchId+"&id="+sectionId;
        Section[] temp = this.restTemplate.getForObject(prefSectionUrl, Section[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Section> sectionList = Arrays.asList(temp);
        Collections.sort(sectionList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return sectionList;
    }

    public List<Section> getAllSections() {
        logger.debug("Getting all Section");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-filters";
        Section[] temp = this.restTemplate.getForObject(prefSectionUrl, Section[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Section> sectionList = Arrays.asList(temp);
        Collections.sort(sectionList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sectionList;
    }
    public List<Section> findAllSections() {
        logger.debug("Retrieving all Section");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSectionUrl = prefUrl+"/api/section-by-filters";
        Section[] temp = this.restTemplate.getForObject(prefSectionUrl, Section[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Section> sectionList = Arrays.asList(temp);
        Collections.sort(sectionList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sectionList;
    }

    public Teacher getTeacherByEmail(String teacherEmailAddress) {
        logger.debug("Getting teacher based on email id : "+teacherEmailAddress);
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefTeacherUrl = prefUrl+"/api/teacher-by-filters?teacherEmailAddress="+teacherEmailAddress;
        Teacher[] temp = this.restTemplate.getForObject(prefTeacherUrl, Teacher[].class);
        if(temp.length == 0) {
            return null;
        }
        return temp[0];
    }

    public Teach getTeachBySubjectAndTeacherId(Long thrId, Long subId) {
        if(thrId == null || subId == null) {
            return null;
        }

        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefTeachUrl = prefUrl+"/api/teach-by-filters?teacherId="+thrId+"&subjectId="+subId;
        Teach[] temp = this.restTemplate.getForObject(prefTeachUrl, Teach[].class);
        if(temp.length == 0) {
            return null;
        }
        List<Teach> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list.get(0);


    }

    public AttendanceMaster getAttendanceMasterByBatchSectionTeach(Batch bt, Section sc, Teach th) {
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/attendancemaster-by-filters?batchId="+bt.getId()+"&sectionId="+sc.getId()+"&teachId="+th.getId();
        AttendanceMaster[] temp = this.restTemplate.getForObject(prefUrl, AttendanceMaster[].class);
        if(temp.length == 0) {
            return null;
        }
        List<AttendanceMaster> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list.get(0);

    }



    public List<Lecture> getAllCurrentDateLectureForTeacher(Long teacherId){
        logger.debug("Getting today's lectures of a teacher id : "+teacherId);
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/todays-lectures-by-teacher-id?teacherId="+teacherId;
        Lecture[] temp = this.restTemplate.getForObject(prefUrl, Lecture[].class);
        if(temp.length == 0) {
            logger.warn("No lecture found for teacher id : "+teacherId);
            return Collections.emptyList();
        }
        List<Lecture> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<Lecture> getLectureForCriteria(List<AttendanceMaster> atndMstrList, String lectureDate) throws Exception{
        if(atndMstrList.size() == 0) {
            logger.warn("Attendance master list is empty. Returning empty lecture list.");
            return Collections.emptyList();
        }
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Lecture> query = cb.createQuery(Lecture.class);
        Root<Lecture> root = query.from(Lecture.class);
        CriteriaBuilder.In<Long> inAtndMstr = cb.in(root.get("attendancemaster"));
        for (AttendanceMaster am : atndMstrList) {
            inAtndMstr.value(am.getId());
        }
//        Date dt = DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy, lectureDate);
        LocalDate dt = DateFormatUtil.convertStringToLocalDate(lectureDate, CmsConstants.DATE_FORMAT_dd_MM_yyyy);

        CriteriaQuery<Lecture> select = query.select(root).where(cb.and(inAtndMstr), cb.and(cb.equal(root.get("lecDate"), dt)));
        TypedQuery<Lecture> typedQuery = this.entityManager.createQuery(select);
        List<Lecture> lectureList = typedQuery.getResultList();
        logger.debug("Returning list of lectures from JPA criteria query. Total records : "+lectureList.size());
        return lectureList;
    }

    public List<Lecture> getLectureForAdminCriteria(List<AttendanceMaster> atndMstrList) throws Exception {
        if (atndMstrList.size() == 0) {
            logger.warn("Attendance master list is empty. Returning empty lecture list.");
            return Collections.emptyList();
        }
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Lecture> query = cb.createQuery(Lecture.class);
        Root<Lecture> root = query.from(Lecture.class);
        CriteriaBuilder.In<Long> inAtndMstr = cb.in(root.get("attendancemaster"));
        for (AttendanceMaster am : atndMstrList) {
            inAtndMstr.value(am.getId());
        }
//    	Date dt = DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy, lectureDate);
        CriteriaQuery<Lecture> select = query.select(root).where(inAtndMstr);
        TypedQuery<Lecture> typedQuery = this.entityManager.createQuery(select);
        List<Lecture> lectureList = typedQuery.getResultList();
        logger.debug("Returning list of lectures from JPA criteria query. Total records : " + lectureList.size());
        return lectureList;
    }

    public Lecture getLectureById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/lecture-by-id/"+id;
        Lecture temp = this.restTemplate.getForObject(prefUrl, Lecture.class);
        return temp;
    }

    public Lecture findLectureById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/lecture-by-id/"+id;
        Lecture temp = this.restTemplate.getForObject(prefUrl, Lecture.class);
        return temp;
    }

    public Lecture getLectureByAttendanceMasterAndLectureDate(Long attendanceMasterId, String lectureDate) {
        if(attendanceMasterId == null || CommonUtil.isNullOrEmpty(lectureDate)) {
            return null;
        }
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/lecture-by-attendancemaster-and-date?attendanceMasterId="+attendanceMasterId+"&lectureDate="+lectureDate;
        Lecture temp = null;
        try {
            temp = this.restTemplate.getForObject(prefUrl, Lecture.class);
        }catch(Exception e) {
            logger.warn("Exception. ",e.getMessage());
        }
        return temp;
    }

    public Student getStudentById(Long id) {
        if(id == null) {
            return null;
        }
        String prefUrl = applicationProperties.getStdSrvUrl()+"/api/student-by-id/"+id;
        Student temp = this.restTemplate.getForObject(prefUrl, Student.class);
        return temp;
    }

    public List<Subject> getAllSubject() {
        logger.debug("Getting all subjects ");
        String prefUrl = applicationProperties.getPrefSrvUrl();
        String prefSubjectUrl = prefUrl+"/api/subject-by-filters";
        Subject[] temp = this.restTemplate.getForObject(prefSubjectUrl, Subject[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Subject> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<Teach> getAllTeach() {
        logger.debug("Getting all teach objects");
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/teach-by-filters";;
        Teach[] temp = this.restTemplate.getForObject(prefUrl, Teach[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Teach> list = Arrays.asList(temp);
//	    Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<AttendanceMaster> getAllAttendanceMaster() {
        logger.debug("Getting all attendancemaster objects ");
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/attendancemaster-by-filters";
        AttendanceMaster[] temp = this.restTemplate.getForObject(prefUrl, AttendanceMaster[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<AttendanceMaster> list = Arrays.asList(temp);
//	    Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<Student> getAllStudents(Long branchId, Long departmentId, Long batchId, Long sectionId) {
        logger.debug("Getting all Students ");
        String stUrl = applicationProperties.getStdSrvUrl()+"/api/student-by-filters?branchId="+branchId+"&departmentId="+departmentId+"&batchId="+batchId+"&sectionId="+sectionId;
        Student[] temp = this.restTemplate.getForObject(stUrl, Student[].class);
        if(temp.length == 0) {
            return Collections.emptyList();
        }
        List<Student> list = Arrays.asList(temp);
//	    Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<CmsLectureVo> getAllCurrentDateCmsLectureForTeacher(Long teacherId, String lectureDate){
        logger.debug("Getting today's cms lectures of a teacher id : "+teacherId);
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/todays-cmslectures-by-teacher-id?teacherId="+teacherId+"&lectureDate="+lectureDate;
        CmsLectureVo[] temp = this.restTemplate.getForObject(prefUrl, CmsLectureVo[].class);
        if(temp.length == 0) {
            logger.warn("No cms lecture found for teacher id : "+teacherId);
            return Collections.emptyList();
        }
        List<CmsLectureVo> list = new ArrayList<>();
        for(CmsLectureVo vo: temp) {
            vo.setStrLecDate(DateFormatUtil.changeLocalDateFormat(vo.getLecDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
            vo.setLecDate(null);
            list.add(vo);
        }
//	    List<CmsLectureVo> list = Arrays.asList(temp);
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }

    public List<CmsTermVo> getTermsByAcademicYear(Long academicYearId) throws Exception{
        logger.debug("Getting terms based on academicYearId : "+academicYearId);
        if(academicYearId == null) {
            logger.info("academic year id is null. Returning empty term list");
            return Collections.emptyList();
        }

        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/cmsterm-by-filters?academicYearId="+academicYearId+"&status=ACTIVE";
        CmsTermVo[] temp = this.restTemplate.getForObject(prefUrl, CmsTermVo[].class);
        if(temp.length == 0) {
            logger.info("No term found for the given academic year. Returning empty term list");
            return Collections.emptyList();
        }
        List<CmsTermVo> termList = Arrays.asList(temp);
        Collections.sort(termList, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return termList;

    }

    public List<CmsLectureVo> getAllCmsLectures(Long branchId, Long departmentId, Long academicYearId){
        logger.debug("Getting all cms lectures of branch id : "+branchId+", departmentId : "+departmentId+", academicYearId : "+academicYearId);
        String prefUrl = applicationProperties.getPrefSrvUrl()+"/api/cmslectures?academicYearId="+academicYearId+"&branchId="+branchId+"&departmentId="+departmentId;
        CmsLectureVo[] temp = this.restTemplate.getForObject(prefUrl, CmsLectureVo[].class);
        if(temp.length == 0) {
            logger.warn("No cms lecture found for given criteria. Returning empty list");
            return Collections.emptyList();
        }
        List<CmsLectureVo> list = new ArrayList<>();
        for(CmsLectureVo vo: temp) {
            vo.setStrLecDate(DateFormatUtil.changeLocalDateFormat(vo.getLecDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
            vo.setLecDate(null);
            list.add(vo);
        }
        Collections.sort(list, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return list;
    }


}
