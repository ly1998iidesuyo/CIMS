package com.biyesheji.cims.bean;

import java.util.Date;

public class CimsPinkunjilu {

    private String CimsPinkunjiluId;
    private CimsPinkun cimsPinkun;
    private double CimsPinkunjiluMoney;
    private Date CimsPinkunjiluDate;
    private String CimsPinkunjiluPlace;
    private String CimsPinkunjiluRemarks;

    public String getCimsPinkunjiluId() {
        return CimsPinkunjiluId;
    }

    public void setCimsPinkunjiluId(String cimsPinkunjiluId) {
        CimsPinkunjiluId = cimsPinkunjiluId;
    }

    public CimsPinkun getCimsPinkun() {
        return cimsPinkun;
    }

    public void setCimsPinkun(CimsPinkun cimsPinkun) {
        this.cimsPinkun = cimsPinkun;
    }

    public double getCimsPinkunjiluMoney() {
        return CimsPinkunjiluMoney;
    }

    public void setCimsPinkunjiluMoney(double cimsPinkunjiluMoney) {
        CimsPinkunjiluMoney = cimsPinkunjiluMoney;
    }

    public Date getCimsPinkunjiluDate() {
        return CimsPinkunjiluDate;
    }

    public void setCimsPinkunjiluDate(Date cimsPinkunjiluDate) {
        CimsPinkunjiluDate = cimsPinkunjiluDate;
    }

    public String getCimsPinkunjiluPlace() {
        return CimsPinkunjiluPlace;
    }

    public void setCimsPinkunjiluPlace(String cimsPinkunjiluPlace) {
        CimsPinkunjiluPlace = cimsPinkunjiluPlace;
    }

    public String getCimsPinkunjiluRemarks() {
        return CimsPinkunjiluRemarks;
    }

    public void setCimsPinkunjiluRemarks(String cimsPinkunjiluRemarks) {
        CimsPinkunjiluRemarks = cimsPinkunjiluRemarks;
    }
}
