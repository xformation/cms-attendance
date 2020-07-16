package com.synectiks.attendance.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;


public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String studentName;
    private String studentMiddleName;
    private String studentLastName;
    private String fatherName;
    private String fatherMiddleName;
    private String fatherLastName;
    private String motherName;
    private String motherMiddleName;
    private String motherLastName;
    private String studentAadharNo;
    private String studentPanNo;
    private String studentSocialSecurityNo;
    private String studentTaxReferenceNo;
    private String studentBplNo;
    private String studentDrivingLicenseNo;
    private String studentPassportNo;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String religion;
    private String caste;
    private String subCaste;
    private Integer age;
    private String sex;
    private String studentLocalAddress;
    private String studentPermanentAddress;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String studentPrimaryCellNumber;
    private String studentAlternateCellNumber;
    private String studentLandLinePhoneNumber;
    private String studentPrimaryEmailId;
    private String studentAlternateEmailId;
    private String relationWithStudent;
    private String emergencyContactName;
    private String emergencyContactMiddleName;
    private String emergencyContactLastName;
    private String emergencyContactCellNumber;
    private String emergencyContactLandLinePhoneNumber;
    private String emergencyContactEmailId;
    private String studentImagePath;
    private String admissionNo;
    private String enrollmentNo;
    private String rollNo;
    private String studentType;
    private String fatherCellNumber;
    private String fatherEmailId;
    private String fatherOccupation;
    private String fatherOfficeEmailId;
    private String fatherOfficeAddress;
    private String fatherOfficeCellNumber;
    private String fatherOfficeLandLinePhoneNumber;
    private String fatherAadharNo;
    private String fatherPanNo;
    private String fatherSocialSecurityNo;
    private String fatherTaxReferenceNo;
    private String fatherBplNo;
    private String fatherDrivingLicenseNo;
    private String fatherPassportNo;
    private String fatherImagePath;
    private String motherCellNumber;
    private String motherEmailId;
    private String motherOccupation;
    private String motherOfficeEmailId;
    private String motherOfficeAddress;
    private String motherOfficeCellNumber;
    private String motherOfficeLandLinePhoneNumber;
    private String motherAadharNo;
    private String motherPanNo;
    private String motherSocialSecurityNo;
    private String motherTaxReferenceNo;
    private String motherBplNo;
    private String motherDrivingLicenseNo;
    private String motherPassportNo;
    private String motherImagePath;
    private String guardianName;
    private String guardianMiddleName;
    private String guardianLastName;
    private String guardianAddress;
    private String guardianCellNumber;
    private String guardianLandLinePhoneNumber;
    private String guardianEmailId;
    private String guardianOccupation;
    private String guardianOfficeEmailId;
    private String guardianOfficeAddress;
    private String guardianOfficeCellNumber;
    private String guardianOfficeLandLinePhoneNumber;
    private String guardianImagePath;
    private String isGuardianSponsorAgency;
    private String sponsorAgencyName;
    private String sponsorAgencyRegistrationNo;
    private String sponsorAgencyAddress;
    private String sponsorAgencyCellNumber;
    private String sponsorAgencyLandLineNumber;
    private String sponsorAgencyEmailId;
    private String sponsorAgencyAppointeeName;
    private String sponsorAgencyAppointeeDesignation;
    private String sponsorAgencyAppointeeCellNumber;
    private String sponsorAgencyAppointeeLandLineNumber;
    private String sponsorAgencyAppointeeEmailId;
    private String sponsorAgencyAppointeeOfficeAddress;
    private String isPhysicallyChallenged;
    private String detailsOfDisability;
    private String disabilityCertificateNo;
    private String disabilityCertificateIssueAuthority;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate disabilityCertificateIssueDate;
    private Integer percentagOfDisability;
    private String bloodGroup;
    private String vaccinationDetails;
    private String otherMedicalDetails;

    private String status;
    private String createdBy;
    private LocalDate createdOn;
    private String updatedBy;
    private LocalDate updatedOn;

    private String comments;
    private Long departmentId;
    private Long branchId;
    private Long sectionId;
    private Long batchId;
    private Long academicYearId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student studentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMiddleName() {
        return studentMiddleName;
    }

    public Student studentMiddleName(String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
        return this;
    }

    public void setStudentMiddleName(String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public Student studentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
        return this;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Student fatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherMiddleName() {
        return fatherMiddleName;
    }

    public Student fatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName;
        return this;
    }

    public void setFatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public Student fatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
        return this;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getMotherName() {
        return motherName;
    }

    public Student motherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherMiddleName() {
        return motherMiddleName;
    }

    public Student motherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
        return this;
    }

    public void setMotherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public Student motherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
        return this;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getStudentAadharNo() {
        return studentAadharNo;
    }

    public Student studentAadharNo(String studentAadharNo) {
        this.studentAadharNo = studentAadharNo;
        return this;
    }

    public void setStudentAadharNo(String studentAadharNo) {
        this.studentAadharNo = studentAadharNo;
    }

    public String getStudentPanNo() {
        return studentPanNo;
    }

    public Student studentPanNo(String studentPanNo) {
        this.studentPanNo = studentPanNo;
        return this;
    }

    public void setStudentPanNo(String studentPanNo) {
        this.studentPanNo = studentPanNo;
    }

    public String getStudentSocialSecurityNo() {
        return studentSocialSecurityNo;
    }

    public Student studentSocialSecurityNo(String studentSocialSecurityNo) {
        this.studentSocialSecurityNo = studentSocialSecurityNo;
        return this;
    }

    public void setStudentSocialSecurityNo(String studentSocialSecurityNo) {
        this.studentSocialSecurityNo = studentSocialSecurityNo;
    }

    public String getStudentTaxReferenceNo() {
        return studentTaxReferenceNo;
    }

    public Student studentTaxReferenceNo(String studentTaxReferenceNo) {
        this.studentTaxReferenceNo = studentTaxReferenceNo;
        return this;
    }

    public void setStudentTaxReferenceNo(String studentTaxReferenceNo) {
        this.studentTaxReferenceNo = studentTaxReferenceNo;
    }

    public String getStudentBplNo() {
        return studentBplNo;
    }

    public Student studentBplNo(String studentBplNo) {
        this.studentBplNo = studentBplNo;
        return this;
    }

    public void setStudentBplNo(String studentBplNo) {
        this.studentBplNo = studentBplNo;
    }

    public String getStudentDrivingLicenseNo() {
        return studentDrivingLicenseNo;
    }

    public Student studentDrivingLicenseNo(String studentDrivingLicenseNo) {
        this.studentDrivingLicenseNo = studentDrivingLicenseNo;
        return this;
    }

    public void setStudentDrivingLicenseNo(String studentDrivingLicenseNo) {
        this.studentDrivingLicenseNo = studentDrivingLicenseNo;
    }

    public String getStudentPassportNo() {
        return studentPassportNo;
    }

    public Student studentPassportNo(String studentPassportNo) {
        this.studentPassportNo = studentPassportNo;
        return this;
    }

    public void setStudentPassportNo(String studentPassportNo) {
        this.studentPassportNo = studentPassportNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Student dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public Student placeOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getReligion() {
        return religion;
    }

    public Student religion(String religion) {
        this.religion = religion;
        return this;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public Student caste(String caste) {
        this.caste = caste;
        return this;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getSubCaste() {
        return subCaste;
    }

    public Student subCaste(String subCaste) {
        this.subCaste = subCaste;
        return this;
    }

    public void setSubCaste(String subCaste) {
        this.subCaste = subCaste;
    }

    public Integer getAge() {
        return age;
    }

    public Student age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public Student sex(String sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentLocalAddress() {
        return studentLocalAddress;
    }

    public Student studentLocalAddress(String studentLocalAddress) {
        this.studentLocalAddress = studentLocalAddress;
        return this;
    }

    public void setStudentLocalAddress(String studentLocalAddress) {
        this.studentLocalAddress = studentLocalAddress;
    }

    public String getStudentPermanentAddress() {
        return studentPermanentAddress;
    }

    public Student studentPermanentAddress(String studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
        return this;
    }

    public void setStudentPermanentAddress(String studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
    }

    public String getCity() {
        return city;
    }

    public Student city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public Student state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public Student country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Student pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStudentPrimaryCellNumber() {
        return studentPrimaryCellNumber;
    }

    public Student studentPrimaryCellNumber(String studentPrimaryCellNumber) {
        this.studentPrimaryCellNumber = studentPrimaryCellNumber;
        return this;
    }

    public void setStudentPrimaryCellNumber(String studentPrimaryCellNumber) {
        this.studentPrimaryCellNumber = studentPrimaryCellNumber;
    }

    public String getStudentAlternateCellNumber() {
        return studentAlternateCellNumber;
    }

    public Student studentAlternateCellNumber(String studentAlternateCellNumber) {
        this.studentAlternateCellNumber = studentAlternateCellNumber;
        return this;
    }

    public void setStudentAlternateCellNumber(String studentAlternateCellNumber) {
        this.studentAlternateCellNumber = studentAlternateCellNumber;
    }

    public String getStudentLandLinePhoneNumber() {
        return studentLandLinePhoneNumber;
    }

    public Student studentLandLinePhoneNumber(String studentLandLinePhoneNumber) {
        this.studentLandLinePhoneNumber = studentLandLinePhoneNumber;
        return this;
    }

    public void setStudentLandLinePhoneNumber(String studentLandLinePhoneNumber) {
        this.studentLandLinePhoneNumber = studentLandLinePhoneNumber;
    }

    public String getStudentPrimaryEmailId() {
        return studentPrimaryEmailId;
    }

    public Student studentPrimaryEmailId(String studentPrimaryEmailId) {
        this.studentPrimaryEmailId = studentPrimaryEmailId;
        return this;
    }

    public void setStudentPrimaryEmailId(String studentPrimaryEmailId) {
        this.studentPrimaryEmailId = studentPrimaryEmailId;
    }

    public String getStudentAlternateEmailId() {
        return studentAlternateEmailId;
    }

    public Student studentAlternateEmailId(String studentAlternateEmailId) {
        this.studentAlternateEmailId = studentAlternateEmailId;
        return this;
    }

    public void setStudentAlternateEmailId(String studentAlternateEmailId) {
        this.studentAlternateEmailId = studentAlternateEmailId;
    }

    public String getRelationWithStudent() {
        return relationWithStudent;
    }

    public Student relationWithStudent(String relationWithStudent) {
        this.relationWithStudent = relationWithStudent;
        return this;
    }

    public void setRelationWithStudent(String relationWithStudent) {
        this.relationWithStudent = relationWithStudent;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public Student emergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactMiddleName() {
        return emergencyContactMiddleName;
    }

    public Student emergencyContactMiddleName(String emergencyContactMiddleName) {
        this.emergencyContactMiddleName = emergencyContactMiddleName;
        return this;
    }

    public void setEmergencyContactMiddleName(String emergencyContactMiddleName) {
        this.emergencyContactMiddleName = emergencyContactMiddleName;
    }

    public String getEmergencyContactLastName() {
        return emergencyContactLastName;
    }

    public Student emergencyContactLastName(String emergencyContactLastName) {
        this.emergencyContactLastName = emergencyContactLastName;
        return this;
    }

    public void setEmergencyContactLastName(String emergencyContactLastName) {
        this.emergencyContactLastName = emergencyContactLastName;
    }

    public String getEmergencyContactCellNumber() {
        return emergencyContactCellNumber;
    }

    public Student emergencyContactCellNumber(String emergencyContactCellNumber) {
        this.emergencyContactCellNumber = emergencyContactCellNumber;
        return this;
    }

    public void setEmergencyContactCellNumber(String emergencyContactCellNumber) {
        this.emergencyContactCellNumber = emergencyContactCellNumber;
    }

    public String getEmergencyContactLandLinePhoneNumber() {
        return emergencyContactLandLinePhoneNumber;
    }

    public Student emergencyContactLandLinePhoneNumber(String emergencyContactLandLinePhoneNumber) {
        this.emergencyContactLandLinePhoneNumber = emergencyContactLandLinePhoneNumber;
        return this;
    }

    public void setEmergencyContactLandLinePhoneNumber(String emergencyContactLandLinePhoneNumber) {
        this.emergencyContactLandLinePhoneNumber = emergencyContactLandLinePhoneNumber;
    }

    public String getEmergencyContactEmailId() {
        return emergencyContactEmailId;
    }

    public Student emergencyContactEmailId(String emergencyContactEmailId) {
        this.emergencyContactEmailId = emergencyContactEmailId;
        return this;
    }

    public void setEmergencyContactEmailId(String emergencyContactEmailId) {
        this.emergencyContactEmailId = emergencyContactEmailId;
    }

    public String getStudentImagePath() {
        return studentImagePath;
    }

    public Student studentImagePath(String studentImagePath) {
        this.studentImagePath = studentImagePath;
        return this;
    }

    public void setStudentImagePath(String studentImagePath) {
        this.studentImagePath = studentImagePath;
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public Student admissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
        return this;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public Student enrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
        return this;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Student rollNo(String rollNo) {
        this.rollNo = rollNo;
        return this;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentType() {
        return studentType;
    }

    public Student studentType(String studentType) {
        this.studentType = studentType;
        return this;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getFatherCellNumber() {
        return fatherCellNumber;
    }

    public Student fatherCellNumber(String fatherCellNumber) {
        this.fatherCellNumber = fatherCellNumber;
        return this;
    }

    public void setFatherCellNumber(String fatherCellNumber) {
        this.fatherCellNumber = fatherCellNumber;
    }

    public String getFatherEmailId() {
        return fatherEmailId;
    }

    public Student fatherEmailId(String fatherEmailId) {
        this.fatherEmailId = fatherEmailId;
        return this;
    }

    public void setFatherEmailId(String fatherEmailId) {
        this.fatherEmailId = fatherEmailId;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public Student fatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
        return this;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getFatherOfficeEmailId() {
        return fatherOfficeEmailId;
    }

    public Student fatherOfficeEmailId(String fatherOfficeEmailId) {
        this.fatherOfficeEmailId = fatherOfficeEmailId;
        return this;
    }

    public void setFatherOfficeEmailId(String fatherOfficeEmailId) {
        this.fatherOfficeEmailId = fatherOfficeEmailId;
    }

    public String getFatherOfficeAddress() {
        return fatherOfficeAddress;
    }

    public Student fatherOfficeAddress(String fatherOfficeAddress) {
        this.fatherOfficeAddress = fatherOfficeAddress;
        return this;
    }

    public void setFatherOfficeAddress(String fatherOfficeAddress) {
        this.fatherOfficeAddress = fatherOfficeAddress;
    }

    public String getFatherOfficeCellNumber() {
        return fatherOfficeCellNumber;
    }

    public Student fatherOfficeCellNumber(String fatherOfficeCellNumber) {
        this.fatherOfficeCellNumber = fatherOfficeCellNumber;
        return this;
    }

    public void setFatherOfficeCellNumber(String fatherOfficeCellNumber) {
        this.fatherOfficeCellNumber = fatherOfficeCellNumber;
    }

    public String getFatherOfficeLandLinePhoneNumber() {
        return fatherOfficeLandLinePhoneNumber;
    }

    public Student fatherOfficeLandLinePhoneNumber(String fatherOfficeLandLinePhoneNumber) {
        this.fatherOfficeLandLinePhoneNumber = fatherOfficeLandLinePhoneNumber;
        return this;
    }

    public void setFatherOfficeLandLinePhoneNumber(String fatherOfficeLandLinePhoneNumber) {
        this.fatherOfficeLandLinePhoneNumber = fatherOfficeLandLinePhoneNumber;
    }

    public String getFatherAadharNo() {
        return fatherAadharNo;
    }

    public Student fatherAadharNo(String fatherAadharNo) {
        this.fatherAadharNo = fatherAadharNo;
        return this;
    }

    public void setFatherAadharNo(String fatherAadharNo) {
        this.fatherAadharNo = fatherAadharNo;
    }

    public String getFatherPanNo() {
        return fatherPanNo;
    }

    public Student fatherPanNo(String fatherPanNo) {
        this.fatherPanNo = fatherPanNo;
        return this;
    }

    public void setFatherPanNo(String fatherPanNo) {
        this.fatherPanNo = fatherPanNo;
    }

    public String getFatherSocialSecurityNo() {
        return fatherSocialSecurityNo;
    }

    public Student fatherSocialSecurityNo(String fatherSocialSecurityNo) {
        this.fatherSocialSecurityNo = fatherSocialSecurityNo;
        return this;
    }

    public void setFatherSocialSecurityNo(String fatherSocialSecurityNo) {
        this.fatherSocialSecurityNo = fatherSocialSecurityNo;
    }

    public String getFatherTaxReferenceNo() {
        return fatherTaxReferenceNo;
    }

    public Student fatherTaxReferenceNo(String fatherTaxReferenceNo) {
        this.fatherTaxReferenceNo = fatherTaxReferenceNo;
        return this;
    }

    public void setFatherTaxReferenceNo(String fatherTaxReferenceNo) {
        this.fatherTaxReferenceNo = fatherTaxReferenceNo;
    }

    public String getFatherBplNo() {
        return fatherBplNo;
    }

    public Student fatherBplNo(String fatherBplNo) {
        this.fatherBplNo = fatherBplNo;
        return this;
    }

    public void setFatherBplNo(String fatherBplNo) {
        this.fatherBplNo = fatherBplNo;
    }

    public String getFatherDrivingLicenseNo() {
        return fatherDrivingLicenseNo;
    }

    public Student fatherDrivingLicenseNo(String fatherDrivingLicenseNo) {
        this.fatherDrivingLicenseNo = fatherDrivingLicenseNo;
        return this;
    }

    public void setFatherDrivingLicenseNo(String fatherDrivingLicenseNo) {
        this.fatherDrivingLicenseNo = fatherDrivingLicenseNo;
    }

    public String getFatherPassportNo() {
        return fatherPassportNo;
    }

    public Student fatherPassportNo(String fatherPassportNo) {
        this.fatherPassportNo = fatherPassportNo;
        return this;
    }

    public void setFatherPassportNo(String fatherPassportNo) {
        this.fatherPassportNo = fatherPassportNo;
    }

    public String getFatherImagePath() {
        return fatherImagePath;
    }

    public Student fatherImagePath(String fatherImagePath) {
        this.fatherImagePath = fatherImagePath;
        return this;
    }

    public void setFatherImagePath(String fatherImagePath) {
        this.fatherImagePath = fatherImagePath;
    }

    public String getMotherCellNumber() {
        return motherCellNumber;
    }

    public Student motherCellNumber(String motherCellNumber) {
        this.motherCellNumber = motherCellNumber;
        return this;
    }

    public void setMotherCellNumber(String motherCellNumber) {
        this.motherCellNumber = motherCellNumber;
    }

    public String getMotherEmailId() {
        return motherEmailId;
    }

    public Student motherEmailId(String motherEmailId) {
        this.motherEmailId = motherEmailId;
        return this;
    }

    public void setMotherEmailId(String motherEmailId) {
        this.motherEmailId = motherEmailId;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public Student motherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
        return this;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getMotherOfficeEmailId() {
        return motherOfficeEmailId;
    }

    public Student motherOfficeEmailId(String motherOfficeEmailId) {
        this.motherOfficeEmailId = motherOfficeEmailId;
        return this;
    }

    public void setMotherOfficeEmailId(String motherOfficeEmailId) {
        this.motherOfficeEmailId = motherOfficeEmailId;
    }

    public String getMotherOfficeAddress() {
        return motherOfficeAddress;
    }

    public Student motherOfficeAddress(String motherOfficeAddress) {
        this.motherOfficeAddress = motherOfficeAddress;
        return this;
    }

    public void setMotherOfficeAddress(String motherOfficeAddress) {
        this.motherOfficeAddress = motherOfficeAddress;
    }

    public String getMotherOfficeCellNumber() {
        return motherOfficeCellNumber;
    }

    public Student motherOfficeCellNumber(String motherOfficeCellNumber) {
        this.motherOfficeCellNumber = motherOfficeCellNumber;
        return this;
    }

    public void setMotherOfficeCellNumber(String motherOfficeCellNumber) {
        this.motherOfficeCellNumber = motherOfficeCellNumber;
    }

    public String getMotherOfficeLandLinePhoneNumber() {
        return motherOfficeLandLinePhoneNumber;
    }

    public Student motherOfficeLandLinePhoneNumber(String motherOfficeLandLinePhoneNumber) {
        this.motherOfficeLandLinePhoneNumber = motherOfficeLandLinePhoneNumber;
        return this;
    }

    public void setMotherOfficeLandLinePhoneNumber(String motherOfficeLandLinePhoneNumber) {
        this.motherOfficeLandLinePhoneNumber = motherOfficeLandLinePhoneNumber;
    }

    public String getMotherAadharNo() {
        return motherAadharNo;
    }

    public Student motherAadharNo(String motherAadharNo) {
        this.motherAadharNo = motherAadharNo;
        return this;
    }

    public void setMotherAadharNo(String motherAadharNo) {
        this.motherAadharNo = motherAadharNo;
    }

    public String getMotherPanNo() {
        return motherPanNo;
    }

    public Student motherPanNo(String motherPanNo) {
        this.motherPanNo = motherPanNo;
        return this;
    }

    public void setMotherPanNo(String motherPanNo) {
        this.motherPanNo = motherPanNo;
    }

    public String getMotherSocialSecurityNo() {
        return motherSocialSecurityNo;
    }

    public Student motherSocialSecurityNo(String motherSocialSecurityNo) {
        this.motherSocialSecurityNo = motherSocialSecurityNo;
        return this;
    }

    public void setMotherSocialSecurityNo(String motherSocialSecurityNo) {
        this.motherSocialSecurityNo = motherSocialSecurityNo;
    }

    public String getMotherTaxReferenceNo() {
        return motherTaxReferenceNo;
    }

    public Student motherTaxReferenceNo(String motherTaxReferenceNo) {
        this.motherTaxReferenceNo = motherTaxReferenceNo;
        return this;
    }

    public void setMotherTaxReferenceNo(String motherTaxReferenceNo) {
        this.motherTaxReferenceNo = motherTaxReferenceNo;
    }

    public String getMotherBplNo() {
        return motherBplNo;
    }

    public Student motherBplNo(String motherBplNo) {
        this.motherBplNo = motherBplNo;
        return this;
    }

    public void setMotherBplNo(String motherBplNo) {
        this.motherBplNo = motherBplNo;
    }

    public String getMotherDrivingLicenseNo() {
        return motherDrivingLicenseNo;
    }

    public Student motherDrivingLicenseNo(String motherDrivingLicenseNo) {
        this.motherDrivingLicenseNo = motherDrivingLicenseNo;
        return this;
    }

    public void setMotherDrivingLicenseNo(String motherDrivingLicenseNo) {
        this.motherDrivingLicenseNo = motherDrivingLicenseNo;
    }

    public String getMotherPassportNo() {
        return motherPassportNo;
    }

    public Student motherPassportNo(String motherPassportNo) {
        this.motherPassportNo = motherPassportNo;
        return this;
    }

    public void setMotherPassportNo(String motherPassportNo) {
        this.motherPassportNo = motherPassportNo;
    }

    public String getMotherImagePath() {
        return motherImagePath;
    }

    public Student motherImagePath(String motherImagePath) {
        this.motherImagePath = motherImagePath;
        return this;
    }

    public void setMotherImagePath(String motherImagePath) {
        this.motherImagePath = motherImagePath;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public Student guardianName(String guardianName) {
        this.guardianName = guardianName;
        return this;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianMiddleName() {
        return guardianMiddleName;
    }

    public Student guardianMiddleName(String guardianMiddleName) {
        this.guardianMiddleName = guardianMiddleName;
        return this;
    }

    public void setGuardianMiddleName(String guardianMiddleName) {
        this.guardianMiddleName = guardianMiddleName;
    }

    public String getGuardianLastName() {
        return guardianLastName;
    }

    public Student guardianLastName(String guardianLastName) {
        this.guardianLastName = guardianLastName;
        return this;
    }

    public void setGuardianLastName(String guardianLastName) {
        this.guardianLastName = guardianLastName;
    }

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public Student guardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
        return this;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress;
    }

    public String getGuardianCellNumber() {
        return guardianCellNumber;
    }

    public Student guardianCellNumber(String guardianCellNumber) {
        this.guardianCellNumber = guardianCellNumber;
        return this;
    }

    public void setGuardianCellNumber(String guardianCellNumber) {
        this.guardianCellNumber = guardianCellNumber;
    }

    public String getGuardianLandLinePhoneNumber() {
        return guardianLandLinePhoneNumber;
    }

    public Student guardianLandLinePhoneNumber(String guardianLandLinePhoneNumber) {
        this.guardianLandLinePhoneNumber = guardianLandLinePhoneNumber;
        return this;
    }

    public void setGuardianLandLinePhoneNumber(String guardianLandLinePhoneNumber) {
        this.guardianLandLinePhoneNumber = guardianLandLinePhoneNumber;
    }

    public String getGuardianEmailId() {
        return guardianEmailId;
    }

    public Student guardianEmailId(String guardianEmailId) {
        this.guardianEmailId = guardianEmailId;
        return this;
    }

    public void setGuardianEmailId(String guardianEmailId) {
        this.guardianEmailId = guardianEmailId;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public Student guardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
        return this;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getGuardianOfficeEmailId() {
        return guardianOfficeEmailId;
    }

    public Student guardianOfficeEmailId(String guardianOfficeEmailId) {
        this.guardianOfficeEmailId = guardianOfficeEmailId;
        return this;
    }

    public void setGuardianOfficeEmailId(String guardianOfficeEmailId) {
        this.guardianOfficeEmailId = guardianOfficeEmailId;
    }

    public String getGuardianOfficeAddress() {
        return guardianOfficeAddress;
    }

    public Student guardianOfficeAddress(String guardianOfficeAddress) {
        this.guardianOfficeAddress = guardianOfficeAddress;
        return this;
    }

    public void setGuardianOfficeAddress(String guardianOfficeAddress) {
        this.guardianOfficeAddress = guardianOfficeAddress;
    }

    public String getGuardianOfficeCellNumber() {
        return guardianOfficeCellNumber;
    }

    public Student guardianOfficeCellNumber(String guardianOfficeCellNumber) {
        this.guardianOfficeCellNumber = guardianOfficeCellNumber;
        return this;
    }

    public void setGuardianOfficeCellNumber(String guardianOfficeCellNumber) {
        this.guardianOfficeCellNumber = guardianOfficeCellNumber;
    }

    public String getGuardianOfficeLandLinePhoneNumber() {
        return guardianOfficeLandLinePhoneNumber;
    }

    public Student guardianOfficeLandLinePhoneNumber(String guardianOfficeLandLinePhoneNumber) {
        this.guardianOfficeLandLinePhoneNumber = guardianOfficeLandLinePhoneNumber;
        return this;
    }

    public void setGuardianOfficeLandLinePhoneNumber(String guardianOfficeLandLinePhoneNumber) {
        this.guardianOfficeLandLinePhoneNumber = guardianOfficeLandLinePhoneNumber;
    }

    public String getGuardianImagePath() {
        return guardianImagePath;
    }

    public Student guardianImagePath(String guardianImagePath) {
        this.guardianImagePath = guardianImagePath;
        return this;
    }

    public void setGuardianImagePath(String guardianImagePath) {
        this.guardianImagePath = guardianImagePath;
    }

    public String getIsGuardianSponsorAgency() {
        return isGuardianSponsorAgency;
    }

    public Student isGuardianSponsorAgency(String isGuardianSponsorAgency) {
        this.isGuardianSponsorAgency = isGuardianSponsorAgency;
        return this;
    }

    public void setIsGuardianSponsorAgency(String isGuardianSponsorAgency) {
        this.isGuardianSponsorAgency = isGuardianSponsorAgency;
    }

    public String getSponsorAgencyName() {
        return sponsorAgencyName;
    }

    public Student sponsorAgencyName(String sponsorAgencyName) {
        this.sponsorAgencyName = sponsorAgencyName;
        return this;
    }

    public void setSponsorAgencyName(String sponsorAgencyName) {
        this.sponsorAgencyName = sponsorAgencyName;
    }

    public String getSponsorAgencyRegistrationNo() {
        return sponsorAgencyRegistrationNo;
    }

    public Student sponsorAgencyRegistrationNo(String sponsorAgencyRegistrationNo) {
        this.sponsorAgencyRegistrationNo = sponsorAgencyRegistrationNo;
        return this;
    }

    public void setSponsorAgencyRegistrationNo(String sponsorAgencyRegistrationNo) {
        this.sponsorAgencyRegistrationNo = sponsorAgencyRegistrationNo;
    }

    public String getSponsorAgencyAddress() {
        return sponsorAgencyAddress;
    }

    public Student sponsorAgencyAddress(String sponsorAgencyAddress) {
        this.sponsorAgencyAddress = sponsorAgencyAddress;
        return this;
    }

    public void setSponsorAgencyAddress(String sponsorAgencyAddress) {
        this.sponsorAgencyAddress = sponsorAgencyAddress;
    }

    public String getSponsorAgencyCellNumber() {
        return sponsorAgencyCellNumber;
    }

    public Student sponsorAgencyCellNumber(String sponsorAgencyCellNumber) {
        this.sponsorAgencyCellNumber = sponsorAgencyCellNumber;
        return this;
    }

    public void setSponsorAgencyCellNumber(String sponsorAgencyCellNumber) {
        this.sponsorAgencyCellNumber = sponsorAgencyCellNumber;
    }

    public String getSponsorAgencyLandLineNumber() {
        return sponsorAgencyLandLineNumber;
    }

    public Student sponsorAgencyLandLineNumber(String sponsorAgencyLandLineNumber) {
        this.sponsorAgencyLandLineNumber = sponsorAgencyLandLineNumber;
        return this;
    }

    public void setSponsorAgencyLandLineNumber(String sponsorAgencyLandLineNumber) {
        this.sponsorAgencyLandLineNumber = sponsorAgencyLandLineNumber;
    }

    public String getSponsorAgencyEmailId() {
        return sponsorAgencyEmailId;
    }

    public Student sponsorAgencyEmailId(String sponsorAgencyEmailId) {
        this.sponsorAgencyEmailId = sponsorAgencyEmailId;
        return this;
    }

    public void setSponsorAgencyEmailId(String sponsorAgencyEmailId) {
        this.sponsorAgencyEmailId = sponsorAgencyEmailId;
    }

    public String getSponsorAgencyAppointeeName() {
        return sponsorAgencyAppointeeName;
    }

    public Student sponsorAgencyAppointeeName(String sponsorAgencyAppointeeName) {
        this.sponsorAgencyAppointeeName = sponsorAgencyAppointeeName;
        return this;
    }

    public void setSponsorAgencyAppointeeName(String sponsorAgencyAppointeeName) {
        this.sponsorAgencyAppointeeName = sponsorAgencyAppointeeName;
    }

    public String getSponsorAgencyAppointeeDesignation() {
        return sponsorAgencyAppointeeDesignation;
    }

    public Student sponsorAgencyAppointeeDesignation(String sponsorAgencyAppointeeDesignation) {
        this.sponsorAgencyAppointeeDesignation = sponsorAgencyAppointeeDesignation;
        return this;
    }

    public void setSponsorAgencyAppointeeDesignation(String sponsorAgencyAppointeeDesignation) {
        this.sponsorAgencyAppointeeDesignation = sponsorAgencyAppointeeDesignation;
    }

    public String getSponsorAgencyAppointeeCellNumber() {
        return sponsorAgencyAppointeeCellNumber;
    }

    public Student sponsorAgencyAppointeeCellNumber(String sponsorAgencyAppointeeCellNumber) {
        this.sponsorAgencyAppointeeCellNumber = sponsorAgencyAppointeeCellNumber;
        return this;
    }

    public void setSponsorAgencyAppointeeCellNumber(String sponsorAgencyAppointeeCellNumber) {
        this.sponsorAgencyAppointeeCellNumber = sponsorAgencyAppointeeCellNumber;
    }

    public String getSponsorAgencyAppointeeLandLineNumber() {
        return sponsorAgencyAppointeeLandLineNumber;
    }

    public Student sponsorAgencyAppointeeLandLineNumber(String sponsorAgencyAppointeeLandLineNumber) {
        this.sponsorAgencyAppointeeLandLineNumber = sponsorAgencyAppointeeLandLineNumber;
        return this;
    }

    public void setSponsorAgencyAppointeeLandLineNumber(String sponsorAgencyAppointeeLandLineNumber) {
        this.sponsorAgencyAppointeeLandLineNumber = sponsorAgencyAppointeeLandLineNumber;
    }

    public String getSponsorAgencyAppointeeEmailId() {
        return sponsorAgencyAppointeeEmailId;
    }

    public Student sponsorAgencyAppointeeEmailId(String sponsorAgencyAppointeeEmailId) {
        this.sponsorAgencyAppointeeEmailId = sponsorAgencyAppointeeEmailId;
        return this;
    }

    public void setSponsorAgencyAppointeeEmailId(String sponsorAgencyAppointeeEmailId) {
        this.sponsorAgencyAppointeeEmailId = sponsorAgencyAppointeeEmailId;
    }

    public String getSponsorAgencyAppointeeOfficeAddress() {
        return sponsorAgencyAppointeeOfficeAddress;
    }

    public Student sponsorAgencyAppointeeOfficeAddress(String sponsorAgencyAppointeeOfficeAddress) {
        this.sponsorAgencyAppointeeOfficeAddress = sponsorAgencyAppointeeOfficeAddress;
        return this;
    }

    public void setSponsorAgencyAppointeeOfficeAddress(String sponsorAgencyAppointeeOfficeAddress) {
        this.sponsorAgencyAppointeeOfficeAddress = sponsorAgencyAppointeeOfficeAddress;
    }

    public String getIsPhysicallyChallenged() {
        return isPhysicallyChallenged;
    }

    public Student isPhysicallyChallenged(String isPhysicallyChallenged) {
        this.isPhysicallyChallenged = isPhysicallyChallenged;
        return this;
    }

    public void setIsPhysicallyChallenged(String isPhysicallyChallenged) {
        this.isPhysicallyChallenged = isPhysicallyChallenged;
    }

    public String getDetailsOfDisability() {
        return detailsOfDisability;
    }

    public Student detailsOfDisability(String detailsOfDisability) {
        this.detailsOfDisability = detailsOfDisability;
        return this;
    }

    public void setDetailsOfDisability(String detailsOfDisability) {
        this.detailsOfDisability = detailsOfDisability;
    }

    public String getDisabilityCertificateNo() {
        return disabilityCertificateNo;
    }

    public Student disabilityCertificateNo(String disabilityCertificateNo) {
        this.disabilityCertificateNo = disabilityCertificateNo;
        return this;
    }

    public void setDisabilityCertificateNo(String disabilityCertificateNo) {
        this.disabilityCertificateNo = disabilityCertificateNo;
    }

    public String getDisabilityCertificateIssueAuthority() {
        return disabilityCertificateIssueAuthority;
    }

    public Student disabilityCertificateIssueAuthority(String disabilityCertificateIssueAuthority) {
        this.disabilityCertificateIssueAuthority = disabilityCertificateIssueAuthority;
        return this;
    }

    public void setDisabilityCertificateIssueAuthority(String disabilityCertificateIssueAuthority) {
        this.disabilityCertificateIssueAuthority = disabilityCertificateIssueAuthority;
    }

    public LocalDate getDisabilityCertificateIssueDate() {
        return disabilityCertificateIssueDate;
    }

    public Student disabilityCertificateIssueDate(LocalDate disabilityCertificateIssueDate) {
        this.disabilityCertificateIssueDate = disabilityCertificateIssueDate;
        return this;
    }

    public void setDisabilityCertificateIssueDate(LocalDate disabilityCertificateIssueDate) {
        this.disabilityCertificateIssueDate = disabilityCertificateIssueDate;
    }

    public Integer getPercentagOfDisability() {
        return percentagOfDisability;
    }

    public Student percentagOfDisability(Integer percentagOfDisability) {
        this.percentagOfDisability = percentagOfDisability;
        return this;
    }

    public void setPercentagOfDisability(Integer percentagOfDisability) {
        this.percentagOfDisability = percentagOfDisability;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public Student bloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getVaccinationDetails() {
        return vaccinationDetails;
    }

    public Student vaccinationDetails(String vaccinationDetails) {
        this.vaccinationDetails = vaccinationDetails;
        return this;
    }

    public void setVaccinationDetails(String vaccinationDetails) {
        this.vaccinationDetails = vaccinationDetails;
    }

    public String getOtherMedicalDetails() {
        return otherMedicalDetails;
    }

    public Student otherMedicalDetails(String otherMedicalDetails) {
        this.otherMedicalDetails = otherMedicalDetails;
        return this;
    }

    public void setOtherMedicalDetails(String otherMedicalDetails) {
        this.otherMedicalDetails = otherMedicalDetails;
    }

    public String getStatus() {
        return status;
    }

    public Student status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Student createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Student createdOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Student updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public Student updatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getComments() {
        return comments;
    }

    public Student comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Student departmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public Student branchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public Student sectionId(Long sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public Student batchId(Long batchId) {
        this.batchId = batchId;
        return this;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getAcademicYearId() {
        return academicYearId;
    }

    public Student academicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
        return this;
    }

    public void setAcademicYearId(Long academicYearId) {
        this.academicYearId = academicYearId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        return id != null && id.equals(((Student) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", studentName='" + getStudentName() + "'" +
            ", studentMiddleName='" + getStudentMiddleName() + "'" +
            ", studentLastName='" + getStudentLastName() + "'" +
            ", fatherName='" + getFatherName() + "'" +
            ", fatherMiddleName='" + getFatherMiddleName() + "'" +
            ", fatherLastName='" + getFatherLastName() + "'" +
            ", motherName='" + getMotherName() + "'" +
            ", motherMiddleName='" + getMotherMiddleName() + "'" +
            ", motherLastName='" + getMotherLastName() + "'" +
            ", studentAadharNo='" + getStudentAadharNo() + "'" +
            ", studentPanNo='" + getStudentPanNo() + "'" +
            ", studentSocialSecurityNo='" + getStudentSocialSecurityNo() + "'" +
            ", studentTaxReferenceNo='" + getStudentTaxReferenceNo() + "'" +
            ", studentBplNo='" + getStudentBplNo() + "'" +
            ", studentDrivingLicenseNo='" + getStudentDrivingLicenseNo() + "'" +
            ", studentPassportNo='" + getStudentPassportNo() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", placeOfBirth='" + getPlaceOfBirth() + "'" +
            ", religion='" + getReligion() + "'" +
            ", caste='" + getCaste() + "'" +
            ", subCaste='" + getSubCaste() + "'" +
            ", age=" + getAge() +
            ", sex='" + getSex() + "'" +
            ", studentLocalAddress='" + getStudentLocalAddress() + "'" +
            ", studentPermanentAddress='" + getStudentPermanentAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", country='" + getCountry() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", studentPrimaryCellNumber='" + getStudentPrimaryCellNumber() + "'" +
            ", studentAlternateCellNumber='" + getStudentAlternateCellNumber() + "'" +
            ", studentLandLinePhoneNumber='" + getStudentLandLinePhoneNumber() + "'" +
            ", studentPrimaryEmailId='" + getStudentPrimaryEmailId() + "'" +
            ", studentAlternateEmailId='" + getStudentAlternateEmailId() + "'" +
            ", relationWithStudent='" + getRelationWithStudent() + "'" +
            ", emergencyContactName='" + getEmergencyContactName() + "'" +
            ", emergencyContactMiddleName='" + getEmergencyContactMiddleName() + "'" +
            ", emergencyContactLastName='" + getEmergencyContactLastName() + "'" +
            ", emergencyContactCellNumber='" + getEmergencyContactCellNumber() + "'" +
            ", emergencyContactLandLinePhoneNumber='" + getEmergencyContactLandLinePhoneNumber() + "'" +
            ", emergencyContactEmailId='" + getEmergencyContactEmailId() + "'" +
            ", studentImagePath='" + getStudentImagePath() + "'" +
            ", admissionNo='" + getAdmissionNo() + "'" +
            ", enrollmentNo='" + getEnrollmentNo() + "'" +
            ", rollNo='" + getRollNo() + "'" +
            ", studentType='" + getStudentType() + "'" +
            ", fatherCellNumber='" + getFatherCellNumber() + "'" +
            ", fatherEmailId='" + getFatherEmailId() + "'" +
            ", fatherOccupation='" + getFatherOccupation() + "'" +
            ", fatherOfficeEmailId='" + getFatherOfficeEmailId() + "'" +
            ", fatherOfficeAddress='" + getFatherOfficeAddress() + "'" +
            ", fatherOfficeCellNumber='" + getFatherOfficeCellNumber() + "'" +
            ", fatherOfficeLandLinePhoneNumber='" + getFatherOfficeLandLinePhoneNumber() + "'" +
            ", fatherAadharNo='" + getFatherAadharNo() + "'" +
            ", fatherPanNo='" + getFatherPanNo() + "'" +
            ", fatherSocialSecurityNo='" + getFatherSocialSecurityNo() + "'" +
            ", fatherTaxReferenceNo='" + getFatherTaxReferenceNo() + "'" +
            ", fatherBplNo='" + getFatherBplNo() + "'" +
            ", fatherDrivingLicenseNo='" + getFatherDrivingLicenseNo() + "'" +
            ", fatherPassportNo='" + getFatherPassportNo() + "'" +
            ", fatherImagePath='" + getFatherImagePath() + "'" +
            ", motherCellNumber='" + getMotherCellNumber() + "'" +
            ", motherEmailId='" + getMotherEmailId() + "'" +
            ", motherOccupation='" + getMotherOccupation() + "'" +
            ", motherOfficeEmailId='" + getMotherOfficeEmailId() + "'" +
            ", motherOfficeAddress='" + getMotherOfficeAddress() + "'" +
            ", motherOfficeCellNumber='" + getMotherOfficeCellNumber() + "'" +
            ", motherOfficeLandLinePhoneNumber='" + getMotherOfficeLandLinePhoneNumber() + "'" +
            ", motherAadharNo='" + getMotherAadharNo() + "'" +
            ", motherPanNo='" + getMotherPanNo() + "'" +
            ", motherSocialSecurityNo='" + getMotherSocialSecurityNo() + "'" +
            ", motherTaxReferenceNo='" + getMotherTaxReferenceNo() + "'" +
            ", motherBplNo='" + getMotherBplNo() + "'" +
            ", motherDrivingLicenseNo='" + getMotherDrivingLicenseNo() + "'" +
            ", motherPassportNo='" + getMotherPassportNo() + "'" +
            ", motherImagePath='" + getMotherImagePath() + "'" +
            ", guardianName='" + getGuardianName() + "'" +
            ", guardianMiddleName='" + getGuardianMiddleName() + "'" +
            ", guardianLastName='" + getGuardianLastName() + "'" +
            ", guardianAddress='" + getGuardianAddress() + "'" +
            ", guardianCellNumber='" + getGuardianCellNumber() + "'" +
            ", guardianLandLinePhoneNumber='" + getGuardianLandLinePhoneNumber() + "'" +
            ", guardianEmailId='" + getGuardianEmailId() + "'" +
            ", guardianOccupation='" + getGuardianOccupation() + "'" +
            ", guardianOfficeEmailId='" + getGuardianOfficeEmailId() + "'" +
            ", guardianOfficeAddress='" + getGuardianOfficeAddress() + "'" +
            ", guardianOfficeCellNumber='" + getGuardianOfficeCellNumber() + "'" +
            ", guardianOfficeLandLinePhoneNumber='" + getGuardianOfficeLandLinePhoneNumber() + "'" +
            ", guardianImagePath='" + getGuardianImagePath() + "'" +
            ", isGuardianSponsorAgency='" + getIsGuardianSponsorAgency() + "'" +
            ", sponsorAgencyName='" + getSponsorAgencyName() + "'" +
            ", sponsorAgencyRegistrationNo='" + getSponsorAgencyRegistrationNo() + "'" +
            ", sponsorAgencyAddress='" + getSponsorAgencyAddress() + "'" +
            ", sponsorAgencyCellNumber='" + getSponsorAgencyCellNumber() + "'" +
            ", sponsorAgencyLandLineNumber='" + getSponsorAgencyLandLineNumber() + "'" +
            ", sponsorAgencyEmailId='" + getSponsorAgencyEmailId() + "'" +
            ", sponsorAgencyAppointeeName='" + getSponsorAgencyAppointeeName() + "'" +
            ", sponsorAgencyAppointeeDesignation='" + getSponsorAgencyAppointeeDesignation() + "'" +
            ", sponsorAgencyAppointeeCellNumber='" + getSponsorAgencyAppointeeCellNumber() + "'" +
            ", sponsorAgencyAppointeeLandLineNumber='" + getSponsorAgencyAppointeeLandLineNumber() + "'" +
            ", sponsorAgencyAppointeeEmailId='" + getSponsorAgencyAppointeeEmailId() + "'" +
            ", sponsorAgencyAppointeeOfficeAddress='" + getSponsorAgencyAppointeeOfficeAddress() + "'" +
            ", isPhysicallyChallenged='" + getIsPhysicallyChallenged() + "'" +
            ", detailsOfDisability='" + getDetailsOfDisability() + "'" +
            ", disabilityCertificateNo='" + getDisabilityCertificateNo() + "'" +
            ", disabilityCertificateIssueAuthority='" + getDisabilityCertificateIssueAuthority() + "'" +
            ", disabilityCertificateIssueDate='" + getDisabilityCertificateIssueDate() + "'" +
            ", percentagOfDisability=" + getPercentagOfDisability() +
            ", bloodGroup='" + getBloodGroup() + "'" +
            ", vaccinationDetails='" + getVaccinationDetails() + "'" +
            ", otherMedicalDetails='" + getOtherMedicalDetails() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedOn='" + getUpdatedOn() + "'" +
            ", comments='" + getComments() + "'" +
            ", departmentId=" + getDepartmentId() +
            ", branchId=" + getBranchId() +
            ", sectionId=" + getSectionId() +
            ", batchId=" + getBatchId() +
            ", academicYearId=" + getAcademicYearId() +
            "}";
    }


}
