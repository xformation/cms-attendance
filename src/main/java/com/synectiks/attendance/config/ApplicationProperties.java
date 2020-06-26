package com.synectiks.attendance.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Attendance.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String imagePath;

    private String influxDbUrl;
    private String influxDb;
    private String influxDbUsername;
    private String influxDbPassword;
    private String influxDbLogLevel;
    private String secSrvUrl;
    private String prefSrvUrl;
    private String cmsBackEndUrl;
    private String kafkaUrl;
    private String indexEventFireUrl;
    private String msAuthenticationUrl;
    private String paymentResponseUrl;
    private String paymentRedirectUrl;
    private String feeSrvUrl;
    private String transportSrvUrl;
    private String stdSrvUrl;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getInfluxDbUrl() {
        return influxDbUrl;
    }

    public void setInfluxDbUrl(String influxDbUrl) {
        this.influxDbUrl = influxDbUrl;
    }

    public String getInfluxDb() {
        return influxDb;
    }

    public void setInfluxDb(String influxDb) {
        this.influxDb = influxDb;
    }

    public String getInfluxDbUsername() {
        return influxDbUsername;
    }

    public void setInfluxDbUsername(String influxDbUsername) {
        this.influxDbUsername = influxDbUsername;
    }

    public String getInfluxDbPassword() {
        return influxDbPassword;
    }

    public void setInfluxDbPassword(String influxDbPassword) {
        this.influxDbPassword = influxDbPassword;
    }

    public String getInfluxDbLogLevel() {
        return influxDbLogLevel;
    }

    public void setInfluxDbLogLevel(String influxDbLogLevel) {
        this.influxDbLogLevel = influxDbLogLevel;
    }

    public String getSecSrvUrl() {
        return secSrvUrl;
    }

    public void setSecSrvUrl(String secSrvUrl) {
        this.secSrvUrl = secSrvUrl;
    }

    public String getPrefSrvUrl() {
        return prefSrvUrl;
    }

    public void setPrefSrvUrl(String prefSrvUrl) {
        this.prefSrvUrl = prefSrvUrl;
    }

    public String getCmsBackEndUrl() {
        return cmsBackEndUrl;
    }

    public void setCmsBackEndUrl(String cmsBackEndUrl) {
        this.cmsBackEndUrl = cmsBackEndUrl;
    }

    public String getKafkaUrl() {
        return kafkaUrl;
    }

    public void setKafkaUrl(String kafkaUrl) {
        this.kafkaUrl = kafkaUrl;
    }

    public String getIndexEventFireUrl() {
        return indexEventFireUrl;
    }

    public void setIndexEventFireUrl(String indexEventFireUrl) {
        this.indexEventFireUrl = indexEventFireUrl;
    }

    public String getMsAuthenticationUrl() {
        return msAuthenticationUrl;
    }

    public void setMsAuthenticationUrl(String msAuthenticationUrl) {
        this.msAuthenticationUrl = msAuthenticationUrl;
    }

    public String getPaymentResponseUrl() {
        return paymentResponseUrl;
    }

    public void setPaymentResponseUrl(String paymentResponseUrl) {
        this.paymentResponseUrl = paymentResponseUrl;
    }

    public String getPaymentRedirectUrl() {
        return paymentRedirectUrl;
    }

    public void setPaymentRedirectUrl(String paymentRedirectUrl) {
        this.paymentRedirectUrl = paymentRedirectUrl;
    }

    public String getFeeSrvUrl() {
        return feeSrvUrl;
    }

    public void setFeeSrvUrl(String feeSrvUrl) {
        this.feeSrvUrl = feeSrvUrl;
    }

    public String getTransportSrvUrl() {
        return transportSrvUrl;
    }

    public void setTransportSrvUrl(String transportSrvUrl) {
        this.transportSrvUrl = transportSrvUrl;
    }

    public String getStdSrvUrl() {
        return stdSrvUrl;
    }

    public void setStdSrvUrl(String stdSrvUrl) {
        this.stdSrvUrl = stdSrvUrl;
    }
}
