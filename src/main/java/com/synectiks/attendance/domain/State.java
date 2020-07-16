package com.synectiks.attendance.domain;
import java.io.Serializable;

public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String stateName;
    private String divisionType;
    private String stateCode;
    private Country country;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public State stateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDivisionType() {
        return divisionType;
    }

    public State divisionType(String divisionType) {
        this.divisionType = divisionType;
        return this;
    }

    public void setDivisionType(String divisionType) {
        this.divisionType = divisionType;
    }

    public String getStateCode() {
        return stateCode;
    }

    public State stateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Country getCountry() {
        return country;
    }

    public State country(Country country) {
        this.country = country;
        return this;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        return id != null && id.equals(((State) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "State{" +
            "id=" + getId() +
            ", stateName='" + getStateName() + "'" +
            ", divisionType='" + getDivisionType() + "'" +
            ", stateCode='" + getStateCode() + "'" +
            "}";
    }
}
