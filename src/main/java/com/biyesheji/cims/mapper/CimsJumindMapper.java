package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsJuminb;
import com.biyesheji.cims.bean.CimsJumind;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CimsJumindMapper {


    //通过基本信息的id查找详细信息
    @Select("select * from cims_jumind where cims_juminb_id=#{id}")
    public CimsJumind findCimsJumind(String id);

    //更新详细信息
    @Update("update cims_jumind set cims_jumind_weight=#{cimsJumind.CimsJumindWeight},cims_jumind_height=#{cimsJumind.CimsJumindHeight},cims_jumind_adressnow=#{cimsJumind.CimsJumindAdressnow},cims_jumind_vocation=#{cimsJumind.CimsJumindVocation},cims_jumind_phone=#{cimsJumind.CimsJumindPhone},cims_jumind_remarks=#{cimsJumind.CimsJumindRemarks} where cims_juminb_id=#{cimsJuminb.CimsJuminbId}")
    public int updateCimsJumind(@Param("cimsJumind") CimsJumind cimsJumind,@Param("cimsJuminb") CimsJuminb cimsJuminb);

    //新增信息
    @Insert("insert into cims_jumind values(#{cimsJuminb.CimsJuminbId},#{cimsJumind.CimsJumindWeight},#{cimsJumind.CimsJumindHeight},#{cimsJumind.CimsJumindAdressnow},#{cimsJumind.CimsJumindVocation},#{cimsJumind.CimsJumindPhone},#{cimsJumind.CimsJumindRemarks})")
    public int addCimsJumind(@Param("cimsJuminb") CimsJuminb cimsJuminb,@Param("cimsJumind") CimsJumind cimsJumind);
}


