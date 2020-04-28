package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsShequ;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface CimsHujiMapper {

    //通过户籍id查找某户籍
    @Select("select * from cims_huji where cims_huji_id=#{id}")
    @Results({
            @Result(column = "cims_shequ_id",property = "cimsShequ",one=@One(select = "com.biyesheji.cims.mapper.CimsShequMapper.findCimsShequById"))
    })
    public CimsHuji findCimsHujiById(String id);

    //通过户主名查找id
    @Select("select cims_huji_id from cims_huji where cims_huji_name=#{name}")
    public String findCimsHujiIdByName(String name);

    //查找所有户籍
    @Select("select * from cims_huji")
    @Results({
            @Result(column = "cims_shequ_id",property = "cimsShequ",one=@One(select = "com.biyesheji.cims.mapper.CimsShequMapper.findCimsShequById"))
    })
    public Collection<CimsHuji> findAllCimsHuji();

    //添加户籍信息
    @Insert("insert into cims_huji values(#{[cimsHuji].CimsHujiId},#{[cimsShequ].CimsShequId},#{[cimsHuji].CimsHujiName},#{[cimsHuji].CimsHujiPersonnum},#{[cimsHuji].CimsHujiAdress},#{[cimsHuji].CimsHujiPhone},#{[cimsHuji].CimsHujiAdressnow})")
    public int insertCimsHuji(@Param("cimsHuji") CimsHuji cimsHuji, @Param("cimsShequ") CimsShequ cimsShequ);

    //更新户籍信息
    @Update("update cims_huji set cims_huji_name=#{[cimsHuji].CimsHujiName},cims_shequ_id=#{[cimsShequ].CimsShequId},cims_huji_personnum=#{[cimsHuji].CimsHujiPersonnum},cims_huji_phone=#{[cimsHuji].CimsHujiPhone},cims_huji_adressnow=#{[cimsHuji].CimsHujiAdressnow} where cims_huji_id=#{[cimsHuji].CimsHujiId}")
    public int updateCimsHuji(@Param("cimsHuji") CimsHuji cimsHuji,@Param("cimsShequ") CimsShequ cimsShequ);
}
