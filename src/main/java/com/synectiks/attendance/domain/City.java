package com.synectiks.attendance.domain;
import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cityName;
    private String cityCode;
    private String stdCode;
    private State state;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public City cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public City cityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStdCode() {
        return stdCode;
    }

    public City stdCode(String stdCode) {
        this.stdCode = stdCode;
        return this;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public State getState() {
        return state;
    }

    public City state(State state) {
        this.state = state;
        return this;
    }

    public void setState(State state) {
        this.state = state;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        return id != null && id.equals(((City) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "City{" +
            "id=" + getId() +
            ", cityName='" + getCityName() + "'" +
            ", cityCode='" + getCityCode() + "'" +
            ", stdCode='" + getStdCode() + "'" +
            "}";
    }
}
