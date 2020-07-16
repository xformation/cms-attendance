package com.synectiks.attendance.constant;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CmsConstants {

	String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    String SYSTEM_ACCOUNT = "system";
    String ANONYMOUS_USER = "anonymoususer";
    String DEFAULT_LANGUAGE = "en";
    String ZONE_ID = "Asia/Kolkata";
	String DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
	String DATE_FORMAT_dd_MM_yyyy = "dd-MM-yyyy";
	String DATE_FORMAT_MM_dd_yyyy = "MM-dd-yyyy";
	String DATE_FORMAT_d_MMM_yyyy = "dd MMM yyyy";

	String ADD_SUCCESS_MESSAGE = "Records added successfully";
	String ADD_FAILURE_MESSAGE = "Due to some exception, records could no be added.";
	String UPDATE_SUCCESS_MESSAGE = "Records updated successfully";
	String UPDATE_FAILURE_MESSAGE = "Due to some exception, records could no be updated.";

	String INFLUXDB_LOG_LEVEL_BASIC = "BASIC";
	String INFLUXDB_LOG_LEVEL_FULL = "FULL";
	String INFLUXDB_LOG_LEVEL_HEADERS = "HEADERS";
	String INFLUXDB_LOG_LEVEL_NONE = "NONE";

	public static String STATUS_ACTIVE = "ACTIVE";
	public static String STATUS_DEACTIVE = "DEACTIVE";
	public static String STATUS_DRAFT = "DRAFT";
	public static List<String> STATUS_LIST = initStatusList();
    public static List<String> initStatusList(){
    	List<String> s = new ArrayList<>();
    	s.add(STATUS_ACTIVE);
    	s.add(STATUS_DEACTIVE);
    	s.add(STATUS_DRAFT);
    	return s;
    }

    public static String MALE = "MALE";
    public static String FEMALE = "FEMALE";
    public static String BOTH = "BOTH";
    public static List<String> GENDER_LIST = initGenderList();
    public static List<String> initGenderList(){
    	List<String> s = new ArrayList<>();
    	s.add(MALE);
    	s.add(FEMALE);
    	s.add(BOTH);
    	return s;
    }

    public static String STATUS_RECEIVED = "RECEIVED";
    public static String STATUS_FOLLOWUP = "FOLLOWUP";
    public static String STATUS_DECLINED = "DECLINED";
    public static String STATUS_CONVERTED_TO_ADMISSION = "CONVERTED_TO_ADMISSION";
	public static List<String> ENQUIRY_STATUS_LIST = initAdmissionEnquiryStatusList();
    public static List<String> initAdmissionEnquiryStatusList(){
    	List<String> s = new ArrayList<>();
    	s.add(STATUS_RECEIVED);
    	s.add(STATUS_FOLLOWUP);
    	s.add(STATUS_DECLINED);
    	s.add(STATUS_CONVERTED_TO_ADMISSION);
    	return s;
    }

    public static String STATUS_INPROCESS = "INPROCESS";
    public static String STATUS_PARKED = "PARKED";
    public static String STATUS_ADMISSION_GRANTED = "ADMISSION_GRANTED";
    public static List<String> ADMISSION_STATUS_LIST = initAdmissionStatusList();
    public static List<String> initAdmissionStatusList(){
    	List<String> s = new ArrayList<>();
    	s.add(STATUS_RECEIVED);
    	s.add(STATUS_INPROCESS);
    	s.add(STATUS_PARKED);
    	s.add(STATUS_DECLINED);
    	s.add(STATUS_ADMISSION_GRANTED);
    	return s;
    }

    public static String MODE_INPERSON = "INPERSON";
    public static String MODE_TELEPHONE = "TELEPHONE";
    public static String MODE_EMAIL = "EMAIL";
    public static String MODE_ONLINE = "ONLINE";
    public static String MODE_APPLICATION_LETTER = "APPLICATION_LETTER";
    public static List<String> MODE_OF_ENQUIRY_LIST = initModeOfEnquiryStatusList();
    public static List<String> initModeOfEnquiryStatusList(){
    	List<String> s = new ArrayList<>();
    	s.add(MODE_INPERSON);
    	s.add(MODE_TELEPHONE);
    	s.add(MODE_EMAIL);
    	s.add(MODE_ONLINE);
    	s.add(MODE_APPLICATION_LETTER);
    	return s;
    }

    String ERROR_ADMISSIONENQUIRY_ALREADY_EXISTS = "Admission Enquiry already exists. Application allows only one Enquiry.";
    String VALIDATION_FAILURE = "Business validation failed: ";
    String TRANSACTION_SOURCE_ADMISSION_PAGE = "ADMISSION_PAGE";
    String SOURCE_ADMISSION_ENQUIRY = "ADMISSION_ENQUIRY";
    String SOURCE_STUDENT = "STUDENT";

    String YES = "YES";
	String NO = "NO";

	String CMS_IMAGE_FILE_PATH = "college_images/";

	String CMS_COLLEGE_LOGO_FILE_NAME = "college_logo";
	String CMS_COLLEGE_BACKGROUND_IMAGE_FILE_NAME = "dashboard";
	String CMS_LEGAL_ENTITY_LOGO_FILE_NAME = "legalentity_logo";

	String LECTURE_NOT_SCHEDULED = "LECTURE_NOT_SCHEDULED";

	String OS_WINDOWS = "windows";
	String OS_UNIX = "unix";
	String OS_MAC = "mac";
	String OS_SOLARIS = "solaris";
	String COLLEGE_ID_PLACEHOLDER_REPLACER = "college_id_";
	String BRANCH_ID_PLACEHOLDER_REPLACER = "branch_id_";
	String STUDENT_IMAGE_FILE_PATH = CMS_IMAGE_FILE_PATH+ File.separator+"COLLEGE_ID"+ File.separator+"student_images";

	String XLSX_FILE_EXTENSION = "xlsx";
	String XLS_FILE_EXTENSION = "xls";
	int BATCH_SIZE = 100;

	// BillDesk payment gateway specific constants
	String HASH_KEY = "uIZ2iayX70hc";
	String HASH_ALGO = "HmacSHA256";
    String MERCHANT_ID = "HMACUAT";
    String SECURITY_ID = "hmacuat";
//    String RESPONSE_URL = "http://localhost:9091/api/cmspaymentresponse";
	String PAYMENT_STATUS_FAILED = "550";
//	String PAYMENT_REDIRECT_URL = "http://localhost:3000/payment-response";

	String ERROR_COLLEGE_ALREADY_EXISTS = "College alreay exists. Application allows only one college.";
	String PRIVATE = "PRIVATE";
	String PUBLIC = "PUBLIC";
	String SEMI_GOVERNMENT = "SEMI-GOVERNMENT";

    public static String CUSTOMER = "CUSTOMER";
    public static String USER = "USER";
    public static String SUPER = "SUPER";
    public static List<String> TYPES_LIST = initTypeList();
    public static List<String> initTypeList(){
        List<String> s = new ArrayList<>();
        s.add(CUSTOMER);
        s.add(USER);
        s.add(SUPER);
        return s;
    }

    String SUBJECT_TYPE_COMMON = "COMMON";
    String SUBJECT_TYPE_ELECTIVE = "ELECTIVE";

    String STAFF_TYPE_TEACHING = "TEACHING";
    String STAFF_TYPE_NONTEACHING = "NONTEACHING";
    String STAFF_TYPE_GUEST = "GUEST";

    String RELIGION_HINDU = "HINDU";
    String RELIGION_MUSLIM = "MUSLIM";
    String RELIGION_SIKH = "SIKH";
    String RELIGION_CHRISTIAN = "CHRISTIAN";
    String RELIGION_BUDH = "BUDH";
    String RELIGION_PARSIAN = "PARSIAN";

    String CAST_GENERAL = "GENERAL";
    String CAST_SCHEDULED_CASTE = "SC";
    String CAST_SCHEDULED_TRIBE = "ST";
    String CAST_OTHER_BACKWARD_CLASSES="OBC";

    String DESIGNATION_LECTURER = "Lecturer";
    String DESIGNATION_PROFESSOR = "Professor";

    public static Map<String, Integer> initWeekDayMap() {
    	Map<String, Integer> WEEKDAY_MAP = new HashMap<String, Integer>();
        WEEKDAY_MAP.put("MONDAY",0);
        WEEKDAY_MAP.put("TUESDAY",1);
        WEEKDAY_MAP.put("WEDNESDAY",2);
        WEEKDAY_MAP.put("THURSDAY",3);
        WEEKDAY_MAP.put("FRIDAY",4);
        WEEKDAY_MAP.put("SATURDAY",5);
        WEEKDAY_MAP.put("SUNDAY",6);
        return WEEKDAY_MAP;
    }

}
