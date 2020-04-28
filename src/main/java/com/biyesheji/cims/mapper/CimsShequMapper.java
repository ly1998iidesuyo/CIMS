package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsShequ;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;

@Mapper
public interface CimsShequMapper {


    //通过id查询社区
    @Select("select * from cims_shequ where cims_shequ_id=#{id}")
    public CimsShequ findCimsShequById(String id);

    //查找所有社区
    @Select("select * from cims_shequ")
    public Collection<CimsShequ> findAllCimsShequ();

    //添加社区
    @Insert("insert into cims_shequ values(#{CimsShequId},#{CimsShequName})")
    public int addCimsShequ(CimsShequ cimsShequ);

    //更新社区
    @Update("update cims_shequ set cims_shequ_name=#{CimsShequName} where cims_shequ_id=#{CimsShequId}")
    public int updateCimShequ(CimsShequ cimsShequ);
}
