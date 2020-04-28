package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsJuminb;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface CimsJuminbMapper {

    //查找所有居民
    @Select("select * from cims_juminb")
    @Results({
            @Result(column = "cims_huji_id",property = "cimsHuji",one=@One(select = "com.biyesheji.cims.mapper.CimsHujiMapper.findCimsHujiById"))
    })
    public Collection<CimsJuminb> findAllCimsJuminbs();

    //通过身份证号查找居民
    @Select("select * from cims_juminb where cims_juminb_idcardnum=#{id}")
    @Results({
            @Result(column = "cims_huji_id",property = "cimsHuji",one=@One(select = "com.biyesheji.cims.mapper.CimsHujiMapper.findCimsHujiById"))
    })
    public CimsJuminb findCimsJuminbByInid(String id);

    //添加居民信息
    @Insert("insert into cims_juminb values("
            +"#{[cimsJuminb].CimsJuminbId},"
            +"#{[cimsHuji].CimsHujiId},"
            +"#{[cimsJuminb].CimsJuminbName},"
            +"#{[cimsJuminb].CimsJuminbSex},"
            +"#{[cimsJuminb].CimsJuminbAge},"
            +"#{[cimsJuminb].CimsJuminbIdcardnum},"
            +"#{[cimsJuminb].CimsJuminbNation},"
            +"#{[cimsJuminb].CimsJuminbAdress},"
            +"#{[cimsJuminb].CimsJuminbMarriage},"
            +"#{[cimsJuminb].CimsJuminbPoliticaloutlook},"
            +"#{[cimsJuminb].CimsJuminbEducation})")
    public int addCimsJuminb(@Param("cimsJuminb") CimsJuminb cimsJuminb, @Param("cimsHuji") CimsHuji cimsHuji);

    //更新居民信息

    @Update("update cims_juminb set cims_juminb_name=#{CimsJuminbName},cims_juminb_age=#{CimsJuminbAge},cims_juminb_idcardnum=#{CimsJuminbIdcardnum},cims_juminb_nation=#{CimsJuminbNation},cims_juminb_adress=#{CimsJuminbAdress},cims_juminb_marriage=#{CimsJuminbMarriage},cims_juminb_politicaloutlook=#{CimsJuminbPoliticaloutlook},cims_juminb_education=#{CimsJuminbEducation} where cims_juminb_id=#{CimsJuminbId}")
    public int updateCimsJuminb(CimsJuminb cimsJuminb);

}
