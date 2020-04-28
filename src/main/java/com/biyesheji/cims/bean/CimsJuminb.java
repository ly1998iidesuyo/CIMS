package com.biyesheji.cims.bean;

public class CimsJuminb {

    //居民基本信息id
    private String CimsJuminbId;
    //户籍编号
    private CimsHuji cimsHuji;
    //姓名
    private String CimsJuminbName;
    //性别 1代表男，0代表女
    private Integer CimsJuminbSex;
    //年龄
    private Integer CimsJuminbAge;
    //身份证号
    private String CimsJuminbIdcardnum;
    //民族
    private String CimsJuminbNation;
    //籍贯
    private String CimsJuminbAdress;
    //婚姻 1代表已婚，0代表未婚
    private Integer CimsJuminbMarriage;
    //政治面貌
    private String CimsJuminbPoliticaloutlook;
    //文化程度
    private String CimsJuminbEducation;

    public String getCimsJuminbId() {
        return CimsJuminbId;
    }

    public void setCimsJuminbId(String cimsJuminbId) {
        CimsJuminbId = cimsJuminbId;
    }

    public CimsHuji getCimsHuji() {
        return cimsHuji;
    }

    public void setCimsHuji(CimsHuji cimsHujiId) {
        this.cimsHuji = cimsHuji;
    }

    public String getCimsJuminbName() {
        return CimsJuminbName;
    }

    public void setCimsJuminbName(String cimsJuminbName) {
        CimsJuminbName = cimsJuminbName;
    }

    public Integer getCimsJuminbSex() {
        return CimsJuminbSex;
    }

    public void setCimsJuminbSex(Integer cimsJuminbSex) {
        CimsJuminbSex = cimsJuminbSex;
    }

    public Integer getCimsJuminbAge() {
        return CimsJuminbAge;
    }

    public void setCimsJuminbAge(Integer cimsJuminbAge) {
        CimsJuminbAge = cimsJuminbAge;
    }

    public String getCimsJuminbIdcardnum() {
        return CimsJuminbIdcardnum;
    }

    public void setCimsJuminbIdcardnum(String cimsJuminbIdcardnum) {
        CimsJuminbIdcardnum = cimsJuminbIdcardnum;
    }

    public String getCimsJuminbNation() {
        return CimsJuminbNation;
    }

    public void setCimsJuminbNation(String cimsJuminbNation) {
        CimsJuminbNation = cimsJuminbNation;
    }

    public String getCimsJuminbAdress() {
        return CimsJuminbAdress;
    }

    public void setCimsJuminbAdress(String cimsJuminbAdress) {
        CimsJuminbAdress = cimsJuminbAdress;
    }

    public Integer getCimsJuminbMarriage() {
        return CimsJuminbMarriage;
    }

    public void setCimsJuminbMarriage(Integer cimsJuminbMarriage) {
        CimsJuminbMarriage = cimsJuminbMarriage;
    }

    public String getCimsJuminbPoliticaloutlook() {
        return CimsJuminbPoliticaloutlook;
    }

    public void setCimsJuminbPoliticaloutlook(String cimsJuminbPoliticaloutlook) {
        CimsJuminbPoliticaloutlook = cimsJuminbPoliticaloutlook;
    }

    public String getCimsJuminbEducation() {
        return CimsJuminbEducation;
    }

    public void setCimsJuminbEducation(String cimsJuminbEducation) {
        CimsJuminbEducation = cimsJuminbEducation;
    }
}
