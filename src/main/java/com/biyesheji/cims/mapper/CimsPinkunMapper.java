package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsPinkun;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface CimsPinkunMapper {
    //查找所有贫困信息
    @Select("select * from cims_pinkun")
    @Results({
            @Result(column = "cims_huji_id",property = "cimsHuji",one=@One(select = "com.biyesheji.cims.mapper.CimsHujiMapper.findCimsHujiById"))
    })
    public Collection<CimsPinkun> findAllCimsPinkun();

    //通过id查找贫困户信息
    @Select("select * from cims_pinkun where cims_pinkun_id=#{id} ")
    @Results({
            @Result(column = "cims_huji_id",property = "cimsHuji",one=@One(select = "com.biyesheji.cims.mapper.CimsHujiMapper.findCimsHujiById"))
    })
    public CimsPinkun findCimsPinkunById(String id);

    //新增贫困户信息
    @Insert("insert ignore cims_pinkun values(#{[cimsPinkun].CimsPinkunId},#{[cimsHuji].cimsHujiId},#{[cimsPinkun].CimsPinkunAvgyearincome},#{[cimsPinkun].CimsPinkunReason})")
    public int addCimsPinkun(@Param("cimsPinkun") CimsPinkun cimsPinkun,@Param("cimsHuji") CimsHuji cimsHuji);

    //更新贫困户信息
    @Update("update cims_pinkun set cims_pinkun_avgyearincome=#{CimsPinkunAvgyearincome},cims_pinkun_reason=#{CimsPinkunReason} where cims_pinkun_id=#{CimsPinkunId}")
    public int updateCimsPinkun(CimsPinkun cimsPinkun);

    //删除贫困户信息
    @Delete("delete from cims_pinkun where cims_pinkun_id=#{id}")
    public int deleteCimsPinkun(String id);
}
