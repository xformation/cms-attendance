package com.synectiks.attendance.filter.StudentAttendance;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.synectiks.attendance.domain.vo.StudentAttendanceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synectiks.attendance.business.service.CommonService;
import com.synectiks.attendance.constant.CmsConstants;
import com.synectiks.attendance.domain.AttendanceMaster;
import com.synectiks.attendance.domain.Batch;
import com.synectiks.attendance.domain.Branch;
import com.synectiks.attendance.domain.Department;
import com.synectiks.attendance.domain.Lecture;
import com.synectiks.attendance.domain.QueryResult;
import com.synectiks.attendance.domain.Section;
import com.synectiks.attendance.domain.Student;
import com.synectiks.attendance.domain.StudentAttendance;
import com.synectiks.attendance.domain.Teach;
import com.synectiks.attendance.domain.Teacher;
import com.synectiks.attendance.repository.StudentAttendanceRepository;

import com.synectiks.attendance.service.util.DateFormatUtil;


@Repository
public class StudentAttendanceFilterImpl  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private CommonService commonService;

    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;

//    @Autowired
//    private LectureRepository lectureRepository;

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Student attendance data for a teacher role end user
     * @param filter
     * @return
     * @throws Exception
     */
    public List<StudentAttendanceVo> getStudenceAttendanceDataForTeacher(StudentAttendanceFilterInput filter) throws Exception {

        Branch branch = this.commonService.getBranchById(Long.parseLong(filter.getBranchId())); //new Branch();
//    	branch.setId(Long.valueOf(filter.getBranchId()));

        Department department = this.commonService.getDepartmentById(Long.parseLong(filter.getDepartmentId())); // new Department();
//    	department.setId(Long.valueOf(filter.getDepartmentId()));
        Batch batch = this.commonService.getBatchById(Long.parseLong(filter.getBatchId())); //new Batch();
//    	batch.setId(Long.valueOf(filter.getBatchId()));
        Section section = this.commonService.getSectionById(Long.parseLong(filter.getSectionId())); //new Section();
//    	section.setId(Long.valueOf(filter.getSectionId()));

        Teacher thr = this.commonService.getTeacherByEmail(filter.getTeacherId()); //new Teacher();
//        thr.setTeacherEmailAddress(filter.getTeacherId());
//    	Optional<Teacher> oth = this.teacherRepository.findOne(Example.of(thr));
//        Long tid = oth.isPresent() ? oth.get().getId() : 0;
        Long tid = (thr != null) ? thr.getId() : 0;

        Teach teach = this.commonService.getTeachBySubjectAndTeacherId(tid, Long.valueOf(filter.getSubjectId()));
        AttendanceMaster am = this.commonService.getAttendanceMasterByBatchSectionTeach(batch, section, teach);

        List<StudentAttendanceVo> voList = new ArrayList<>();
        List<Student> studentList = this.commonService.getAllStudents(branch, department, batch, section);

        Lecture currentDateLecture = lectureScheduleStatus(filter, am, 0);
        Lecture oneDayPrevLecture = lectureScheduleStatus(filter, am, 1);
        Lecture twoDayPrevLecture = lectureScheduleStatus(filter, am, 2);
        Lecture threeDayPrevLecture = lectureScheduleStatus(filter, am, 3);

        // lecture schedule on current date insert/update all the students in student_attendance table.
        setCurrentDateStatus(voList, studentList, currentDateLecture);
        setHistoryDateStatus(voList, oneDayPrevLecture, 1);
        setHistoryDateStatus(voList, twoDayPrevLecture, 2);
        setHistoryDateStatus(voList, threeDayPrevLecture, 3);

        return voList;
    }


    /**
     * Student attendance data for admin role end user
     * @param filter
     * @return
     * @throws Exception
     */
    public List<StudentAttendanceVo> getStudenceAttendanceDataForAdmin(StudentAttendanceFilterInput filter) throws Exception {

        Branch branch = this.commonService.getBranchById(Long.parseLong(filter.getBranchId())); //new Branch();
        Department department = this.commonService.getDepartmentById(Long.parseLong(filter.getDepartmentId())); // new Department();
        Batch batch = this.commonService.getBatchById(Long.parseLong(filter.getBatchId())); //new Batch();
        Section section = this.commonService.getSectionById(Long.parseLong(filter.getSectionId())); //new Section();

//      Branch branch = new Branch();
//      branch.setId(Long.valueOf(filter.getBranchId()));
//    	Department department = new Department();
//    	department.setId(Long.valueOf(filter.getDepartmentId()));
//    	Batch batch = new Batch();
//    	batch.setId(Long.valueOf(filter.getBatchId()));
//    	Section section = new Section();
//    	section.setId(Long.valueOf(filter.getSectionId()));

        List<StudentAttendanceVo> voList = new ArrayList<>();
        List<Student> studentList = this.commonService.getAllStudents(branch, department, batch, section);

        Lecture lecture = lectureScheduleStatus(filter);

        // lecture schedule on current date insert/update all the students in student_attendance table.
        setCurrentDateStatus(voList, studentList, lecture);

        return voList;
    }


//	private void setCurrentDateStatus(List<DailyAttendanceVo> voList, List<Student> studentList,
//			Lecture currentDateLecture) {
//		if(currentDateLecture != null) {
//        	for(Student st : studentList) {
//        		StudentAttendance sa = getStudentAttendance(st, currentDateLecture);
//        		DailyAttendanceVo vo = new DailyAttendanceVo();
//				if(sa != null) {
//				   	vo.setStudentId(String.valueOf(st.getId()));
//				   	vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
//				   	vo.setCurrentDateStatus(sa.getAttendanceStatus().toString());
//				   	vo.setComments(sa.getComments());
//				}else {
//					// insert record in student_attendance table and mark the status as present by default.
//					sa = new StudentAttendance();
//					sa.setLecture(currentDateLecture);
//					sa.setStudent(st);
//					sa.setAttendanceStatus(AttendanceStatusEnum.PRESENT);
//					sa = this.studentAttendanceRepository.save(sa);
//					vo.setStudentId(String.valueOf(st.getId()));
//					vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
//					vo.setCurrentDateStatus(sa.getAttendanceStatus().toString());
//				}
//				vo.setStudent(st);
//				voList.add(vo);
//        	}
//        }else {
//        	for(Student st : studentList) {
//        		DailyAttendanceVo vo = new DailyAttendanceVo();
//        		vo.setStudentId(String.valueOf(st.getId()));
//        		vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
//        		vo.setStudent(st);
//				vo.setCurrentDateStatus(CmsConstants.LECTURE_NOT_SCHEDULED);
//				voList.add(vo);
//        	}
//        }
//	}

    private void setCurrentDateStatus(List<StudentAttendanceVo> voList, List<Student> studentList, Lecture currentDateLecture) {
        if(currentDateLecture != null) {
            String stIds = "";
            StringBuilder sb = new StringBuilder();
            for(Student st : studentList) {
                sb.append(st.getId()).append(",");
            }
            stIds = sb.toString().substring(0, sb.lastIndexOf(","));
            List<StudentAttendance> saList = getStudentAttendanceByNativeQuery(stIds, currentDateLecture);
            List<StudentAttendance> insList = new ArrayList<>();
            for(Student st : studentList) {
//        		StudentAttendance sa = getStudentAttendance(st, currentDateLecture);
                StudentAttendance sa = null;
                for(StudentAttendance saa: saList) {
                    if(st.getId().compareTo(saa.getStudentId()) == 0) {
                        sa = saa;
                        break;
                    }
                }
                StudentAttendanceVo vo = new StudentAttendanceVo();
                if(sa != null) {
                    vo.setStudentId(st.getId());
                    vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
                    vo.setCurrentDateStatus(sa.getAttendanceStatus().toString());
                    vo.setComments(sa.getComments());
                }else {
                    // insert record in student_attendance table and mark the status as present by default.
                    sa = new StudentAttendance();
//					sa.setLecture(currentDateLecture);
                    sa.setLectureId(currentDateLecture.getId());
                    sa.setStudentId(sa.getStudentId());
                    sa.setAttendanceStatus("PRESENT");
                    insList.add(sa);
//					sa = this.studentAttendanceRepository.save(sa);
                    vo.setStudentId(st.getId());
                    vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
                    vo.setCurrentDateStatus(sa.getAttendanceStatus().toString());
                }
                vo.setStudent(st);
                voList.add(vo);
            }
            insertStudentAttendance(insList);
        }else {
            for(Student st : studentList) {
                StudentAttendanceVo vo = new StudentAttendanceVo();
                vo.setStudentId(st.getId());
                vo.setStudentName(st.getStudentName() + " " + st.getStudentMiddleName() + " " +st.getStudentLastName());
                vo.setStudent(st);
                vo.setCurrentDateStatus(CmsConstants.LECTURE_NOT_SCHEDULED);
                voList.add(vo);
            }
        }
    }

    private void insertStudentAttendance(List<StudentAttendance> insList ) {
        if(insList.size() > 0) {
            this.studentAttendanceRepository.saveAll(insList);
        }
//		for(StudentAttendance sa : insList) {
//			String sql = "INSERT INTO student_attendance (id,attendance_status,student_id, lecture_id) VALUES ((select nextval('hibernate_sequence')), ?, ?, ?) ";
//			Query query = this.entityManager.createNativeQuery(sql);
//			query.setParameter(1, sa.getAttendanceStatus().toString());
//			query.setParameter(2, sa.getStudent().getId());
//			query.setParameter(3, sa.getLecture().getId());
//			query.executeUpdate();
//		}



    }

    private void setHistoryDateStatus(List<StudentAttendanceVo> voList, Lecture historyDateLecture, int day) {
        if(historyDateLecture != null) {

            String stIds = "";
            StringBuilder sb = new StringBuilder();
            for(StudentAttendanceVo vo : voList) {
                sb.append(vo.getStudent().getId()).append(",");
            }
            stIds = sb.toString().substring(0, sb.lastIndexOf(","));
            List<StudentAttendance> saList = getStudentAttendanceByNativeQuery(stIds, historyDateLecture);



            for(StudentAttendanceVo vo : voList) {

                StudentAttendance sa = null;
                for(StudentAttendance saa: saList) {
                    if(vo.getStudent().getId().compareTo(saa.getStudentId()) == 0) {
                        sa = saa;
                        break;
                    }
                }


//        		StudentAttendance sa = getStudentAttendance(vo.getStudent(), historyDateLecture);
                if(sa != null) {
                    if(day == 1) {
                        vo.setPreviousOneDayStatus(sa.getAttendanceStatus().toString());
                    }else if(day == 2) {
                        vo.setPreviousTwoDayStatus(sa.getAttendanceStatus().toString());
                    }else if(day == 3) {
                        vo.setPreviousThreeDayStatus(sa.getAttendanceStatus().toString());
                    }
                }else {
                    if(day == 1) {
                        vo.setPreviousOneDayStatus("ABSENT");
                    }else if(day == 2) {
                        vo.setPreviousTwoDayStatus("ABSENT");
                    }else if(day == 3) {
                        vo.setPreviousThreeDayStatus("ABSENT");
                    }
                }
            }
        }else {
            for(StudentAttendanceVo vo : voList) {
                if(day == 1) {
                    vo.setPreviousOneDayStatus(CmsConstants.LECTURE_NOT_SCHEDULED);
                }else if(day == 2) {
                    vo.setPreviousTwoDayStatus(CmsConstants.LECTURE_NOT_SCHEDULED);
                }else if(day == 3) {
                    vo.setPreviousThreeDayStatus(CmsConstants.LECTURE_NOT_SCHEDULED);
                }
            }
        }
    }


//    private StudentAttendance getStudentAttendance(Student student, Lecture lecture) {
//    	if(null == lecture) return null;
//    	StudentAttendance sa = new StudentAttendance();
//    	sa.student(student);
//    	sa.lecture(lecture);
//    	Example<StudentAttendance> example = Example.of(sa);
//    	Optional<StudentAttendance> nsa = this.studentAttendanceRepository.findOne(example);
//    	if(nsa.isPresent()) {
//    		return nsa.get();
//    	}
//    	return null;
//    }

    private List<StudentAttendance> getStudentAttendanceByNativeQuery(String studentIds, Lecture lecture) {
        String sql = "select id,attendance_status, comments, student_id from student_attendance where student_id in (#STID#) and lecture_id = ?";
        sql = sql.replaceFirst("#STID#", studentIds);
        Query query = this.entityManager.createNativeQuery(sql);
        query.setParameter(1, lecture.getId());
        List<Object[]> ls = query.getResultList();

        List<StudentAttendance> saList = new ArrayList<>();
        for (Object[] result : ls){
            StudentAttendance sa = new StudentAttendance();
            sa.setId(((BigInteger)result[0]).longValue());
            String status = (String)result[1];
            if("ABSENT".equalsIgnoreCase(status)) {
                sa.setAttendanceStatus("ABSENT");
            }else if("PRESENT".equalsIgnoreCase(status)) {
                sa.setAttendanceStatus("PRESENT");
            }
            sa.setComments((String)result[2]);
            Student student = new Student();
            student.setId(((BigInteger)result[3]).longValue());
//            sa.setStudent(student);
//            sa.setLecture(lecture);
            saList.add(sa);
        }

        return saList;
    }
    /**
     * Lecture schedule for teacher role end user
     * @param lectureDate
     * @param attendanceMaster
     * @param days
     * @return
     * @throws ParseException
     * @throws Exception
     */
    private Lecture lectureScheduleStatus(StudentAttendanceFilterInput filter, AttendanceMaster attendanceMaster, int days) throws ParseException, Exception {
        String lectureDate = filter.getAttendanceDate();

        if(days == 0) {
            return this.commonService.getLectureById(Long.parseLong(filter.getLectureId()));
//    		return this.lectureRepository.findById(Long.parseLong(filter.getLectureId())).get();
        }


        Lecture lec = null;
        Date lecDate = DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy, lectureDate);
////    			DateFormatUtil.changeDateFormat(CmsConstants.DATE_FORMAT_dd_MM_yyyy, "dd/MM/yyyy", lectureDate));
        if(days > 0) {
            String sDate = DateFormatUtil.subtractDays(CmsConstants.DATE_FORMAT_dd_MM_yyyy, lecDate, days);
            lec = this.commonService.getLectureByAttendanceMasterAndLectureDate(attendanceMaster.getId(), sDate);
//    		lecDate = DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy,sDate);
        }
//    	LocalDate newLecDate = DateFormatUtil.convertLocalDateFromUtilDate(lecDate);
        return lec;
//    	lec.setLecDate(DateFormatUtil.convertLocalDateFromUtilDate(lecDate));
//    	lec.setAttendancemaster(attendanceMaster);
//    	Example<Lecture> example = Example.of(lec);
//    	List<Lecture> nlec = this.lectureRepository.findAll(example);
//    	if(nlec.size() > 0) {
//    		return nlec.get(0);
//    	}
//    	return null;
    }

    /**
     * Lecture schedule for admin role end user
     * @param lectureDate
     * @return
     * @throws ParseException
     * @throws Exception
     */

    private Lecture lectureScheduleStatus(StudentAttendanceFilterInput filter) throws ParseException, Exception {
//    	Lecture lec = new Lecture();
//    	String dt = filter.getAttendanceDate();
//    	if(dt.contains("/")) {
//    		dt = dt.replaceAll("/", "-");
//    	}
//    	Date lecDate =  DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy, dt);
//
////    	if(days > 0) {
////    		String sDate = DateFormatUtil.subtractDays(CmsConstants.DATE_FORMAT_dd_MM_yyyy, lecDate, days);
////    		lecDate = DateFormatUtil.getUtilDate(CmsConstants.DATE_FORMAT_dd_MM_yyyy,sDate);
////    	}
//    	lec.setLecDate(DateFormatUtil.convertLocalDateFromUtilDate(lecDate));
//    	lec.setId(Long.valueOf(filter.getLectureId()));
////    	lec.setAttendancemaster(attendanceMaster);
//    	Example<Lecture> example = Example.of(lec);
//    	Optional<Lecture> nlec = this.lectureRepository.findOne(example);
//    	if(nlec.isPresent()) {
//    		return nlec.get();
//    	}
//    	return null;

        Lecture lec = this.commonService.getLectureById(Long.parseLong(filter.getLectureId())) ;
        return lec;

    }

//    private List<Student> getStudentList(Branch branch, Department department, Batch batch, Section section){
//    	Student student = new Student();
//    	student.setBranch(branch);
//    	student.setDepartment(department);
//    	student.setBatch(batch);
//    	student.setSection(section);
//    	Example<Student> example = Example.of(student);
//    	List<Student> studentList = this.studentRepository.findAll(example);
//    	return studentList;
//    }

    private List<Student> getStudentListByNativeQuery(Branch branch, Department department, Batch batch, Section section){
        String sql = "select id, student_name, student_middle_name, student_last_name from student where branch_id = ? and department_id = ? and batch_id = ? and section_id = ? ";
        Query query = this.entityManager.createNativeQuery(sql);
        query.setParameter(1, branch.getId());
        query.setParameter(2, department.getId());
        query.setParameter(3, batch.getId());
        query.setParameter(4, section.getId());
        List<Object[]> ls = query.getResultList();

        List<Student> studentList = new ArrayList<>();
        for (Object[] result : ls){
            Student student = new Student();
            student.setId(((BigInteger)result[0]).longValue() );
            student.setStudentName((String)result[1]);
            student.setStudentMiddleName((String)result[2]);
            student.setStudentLastName((String)result[3]);
            studentList.add(student);
        }

        return studentList;
    }

    public List<Student> getStudentListByJpql(Branch branch, Department department, Batch batch, Section section){

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
//    	In<Long> inBatch = cb.in(root.get("batch"));
//    	for (Batch bth : batchList) {
//    		inBatch.value(bth.getId());
//    	}
//    	In<Long> inSection = cb.in(root.get("section"));
//    	for (Section sec : secList) {
//    		inSection.value(sec.getId());
//    	}

        CriteriaQuery<Student> select = query.select(root).where(cb.and(cb.equal(root.get("branch"), branch.getId())),cb.and(cb.equal(root.get("department"), department.getId())),
            cb.and(cb.equal(root.get("batch"), batch.getId())), cb.and(cb.equal(root.get("section"), section.getId())));
        TypedQuery<Student> typedQuery = this.entityManager.createQuery(select);
        List<Student> stList = typedQuery.getResultList();
        logger.debug("Returning list of student for teacher attendance from JPA criteria query. Total records : "+stList.size());
        return stList;
    }

    @Transactional
    public QueryResult updateStudentStatus(List<StudentAttendanceUpdateFilter> list) {
        logger.info("Start updating student attendance data ");
        QueryResult result = new QueryResult();
        result.setStatusCode(0);
        result.setStatusDesc(CmsConstants.UPDATE_SUCCESS_MESSAGE);

        StudentAttendance stObj = new StudentAttendance();
        Student student = null;
        Lecture lecture = null;
        try {
            for(StudentAttendanceUpdateFilter sa: list) {
                String values = sa.getStudentIds();//.split("##delimline##");
                String lectureId = sa.getLectureId();
                if(lecture == null) {
//    				lecture = this.lectureRepository.findById(Long.valueOf(lectureId)).get();
                    lecture = this.commonService.getLectureById(Long.parseLong(lectureId)) ;
                }
//        		for(String val: values) {
                String data[] = values.split("#~#");
                student = this.commonService.getStudentById(Long.valueOf(data[0]));

                stObj.setStudentId(student.getId());
//    			stObj.setLecture(lecture);
                stObj.setLectureId(lecture.getId());
                Example<StudentAttendance> example = Example.of(stObj);
                Optional<StudentAttendance> osa = this.studentAttendanceRepository.findOne((example));
                if(osa.isPresent()) {
                    stObj.setId(osa.get().getId());
                    stObj.setAttendanceStatus(data[1].equalsIgnoreCase("PRESENT") ? "PRESENT" : "ABSENT");
                    if(data.length > 2) {
                        stObj.setComments(data[2]);
                    }else {
                        stObj.setComments(null);
                    }
                    logger.debug("Updating student attendance id : "+osa.get().getId());
                    this.studentAttendanceRepository.save(stObj);
                    stObj.setId(null);
                    stObj.setAttendanceStatus(null);
                    stObj.setComments(null);
                }
//        		}
            }
        }catch(Exception e) {
            logger.error("Method updateStudentStatus. "+CmsConstants.UPDATE_FAILURE_MESSAGE, e);
            result.setStatusCode(1);
            result.setStatusDesc(CmsConstants.UPDATE_FAILURE_MESSAGE);
        }

        return result;
    }

//    private List<DailyAttendanceVo> executeSelectQuery(Query query) {
//        List<DailyAttendanceVo> resultList = new ArrayList<DailyAttendanceVo>();
//
//        List<Object[]> ls = query.getResultList();
//        for (Object[] result : ls){
//            DailyAttendanceVo da = new DailyAttendanceVo();
//            da.setStudentId(String.valueOf((BigInteger)result[0]));
//            da.setStudentName((String)result[1]);
//            da.setCurrentDateStatus((String)result[2]);
//            da.setPreviousOneDayStatus((String)result[3]);
//            da.setPreviousTwoDayStatus((String)result[4]);
//            da.setPreviousThreeDayStatus((String)result[5]);
//            da.setComments((String)result[6]);
//            resultList.add(da);
//        }
//        return resultList;
//    }


}
