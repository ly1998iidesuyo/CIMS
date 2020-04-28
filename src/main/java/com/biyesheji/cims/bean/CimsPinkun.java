package com.biyesheji.cims.bean;

public class CimsPinkun {
    //贫困编号
    private String CimsPinkunId;
    //所属户籍
    private CimsHuji cimsHuji;
    //平均年收入
    private String CimsPinkunAvgyearincome;
    //贫困原因备注
    private String CimsPinkunReason;

    public String getCimsPinkunId() {
        return CimsPinkunId;
    }

    public void setCimsPinkunId(String cimsPinkunId) {
        CimsPinkunId = cimsPinkunId;
    }

    public CimsHuji getCimsHuji() {
        return cimsHuji;
    }

    public void setCimsHuji(CimsHuji cimsHuji) {
        this.cimsHuji = cimsHuji;
    }

    public String getCimsPinkunAvgyearincome() {
        return CimsPinkunAvgyearincome;
    }

    public void setCimsPinkunAvgyearincome(String cimsPinkunAvgyearincome) {
        CimsPinkunAvgyearincome = cimsPinkunAvgyearincome;
    }

    public String getCimsPinkunReason() {
        return CimsPinkunReason;
    }

    public void setCimsPinkunReason(String cimsPinkunReason) {
        CimsPinkunReason = cimsPinkunReason;
    }
}
