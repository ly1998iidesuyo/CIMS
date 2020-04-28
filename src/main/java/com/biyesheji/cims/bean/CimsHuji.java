package com.biyesheji.cims.bean;

public class CimsHuji {

    //户籍id标识
    private String CimsHujiId;
    //户籍属于的社区
    private CimsShequ cimsShequ;
    //户主姓名
    private String CimsHujiName;
    //家庭成员人数
    private String CimsHujiPersonnum;
    //籍贯地址
    private String CimsHujiAdress;
    //联系方式
    private String CimsHujiPhone;
    //现住址
    private String CimsHujiAdressnow;

    public String getCimsHujiId() {
        return CimsHujiId;
    }

    public void setCimsHujiId(String cimsHujiId) {
        CimsHujiId = cimsHujiId;
    }

    public CimsShequ getCimsShequ() {
        return cimsShequ;
    }

    public void setCimsShequ(CimsShequ cimsShequ) {
        this.cimsShequ = cimsShequ;
    }

    public String getCimsHujiName() {
        return CimsHujiName;
    }

    public void setCimsHujiName(String cimsHujiName) {
        CimsHujiName = cimsHujiName;
    }

    public String getCimsHujiPersonnum() {
        return CimsHujiPersonnum;
    }

    public void setCimsHujiPersonnum(String cimsHujiPersonnum) {
        CimsHujiPersonnum = cimsHujiPersonnum;
    }

    public String getCimsHujiAdress() {
        return CimsHujiAdress;
    }

    public void setCimsHujiAdress(String cimsHujiAdress) {
        CimsHujiAdress = cimsHujiAdress;
    }

    public String getCimsHujiPhone() {
        return CimsHujiPhone;
    }

    public void setCimsHujiPhone(String cimsHujiPhone) {
        CimsHujiPhone = cimsHujiPhone;
    }

    public String getCimsHujiAdressnow() {
        return CimsHujiAdressnow;
    }

    public void setCimsHujiAdressnow(String cimsHujiAdressnow) {
        CimsHujiAdressnow = cimsHujiAdressnow;
    }
}
