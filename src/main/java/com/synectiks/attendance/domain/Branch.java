package com.synectiks.attendance.domain;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String branchName;
    private String address;
    private String pinCode;
    private String branchHead;
    private String cellPhoneNo;
    private String landLinePhoneNo;
    private String emailId;
    private String faxNo;
    private String isMainBranch;
    private LocalDate startDate;
    private String createdBy;
    private LocalDate createdOn;
    private String updatedBy;
    private LocalDate updatedOn;
    private String status;
    private College college;
    private City city;
    private State state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getBranchHead() {
		return branchHead;
	}
	public void setBranchHead(String branchHead) {
		this.branchHead = branchHead;
	}
	public String getCellPhoneNo() {
		return cellPhoneNo;
	}
	public void setCellPhoneNo(String cellPhoneNo) {
		this.cellPhoneNo = cellPhoneNo;
	}
	public String getLandLinePhoneNo() {
		return landLinePhoneNo;
	}
	public void setLandLinePhoneNo(String landLinePhoneNo) {
		this.landLinePhoneNo = landLinePhoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getIsMainBranch() {
		return isMainBranch;
	}
	public void setIsMainBranch(String isMainBranch) {
		this.isMainBranch = isMainBranch;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id) &&
            Objects.equals(branchName, branch.branchName) &&
            Objects.equals(address, branch.address) &&
            Objects.equals(pinCode, branch.pinCode) &&
            Objects.equals(branchHead, branch.branchHead) &&
            Objects.equals(cellPhoneNo, branch.cellPhoneNo) &&
            Objects.equals(landLinePhoneNo, branch.landLinePhoneNo) &&
            Objects.equals(emailId, branch.emailId) &&
            Objects.equals(faxNo, branch.faxNo) &&
            Objects.equals(isMainBranch, branch.isMainBranch) &&
            Objects.equals(startDate, branch.startDate) &&
            Objects.equals(createdBy, branch.createdBy) &&
            Objects.equals(createdOn, branch.createdOn) &&
            Objects.equals(updatedBy, branch.updatedBy) &&
            Objects.equals(updatedOn, branch.updatedOn) &&
            Objects.equals(status, branch.status) &&
            Objects.equals(college, branch.college) &&
            Objects.equals(city, branch.city) &&
            Objects.equals(state, branch.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchName, address, pinCode, branchHead, cellPhoneNo, landLinePhoneNo, emailId, faxNo, isMainBranch, startDate, createdBy, createdOn, updatedBy, updatedOn, status, college, city, state);
    }

    @Override
    public String toString() {
        return "Branch{" +
            "id=" + id +
            ", branchName='" + branchName + '\'' +
            ", address='" + address + '\'' +
            ", pinCode='" + pinCode + '\'' +
            ", branchHead='" + branchHead + '\'' +
            ", cellPhoneNo='" + cellPhoneNo + '\'' +
            ", landLinePhoneNo='" + landLinePhoneNo + '\'' +
            ", emailId='" + emailId + '\'' +
            ", faxNo='" + faxNo + '\'' +
            ", isMainBranch='" + isMainBranch + '\'' +
            ", startDate=" + startDate +
            ", createdBy='" + createdBy + '\'' +
            ", createdOn=" + createdOn +
            ", updatedBy='" + updatedBy + '\'' +
            ", updatedOn=" + updatedOn +
            ", status='" + status + '\'' +
            ", college=" + college +
            ", city=" + city +
            ", state=" + state +
            '}';
    }
}
