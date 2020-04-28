package com.biyesheji.cims.mapper;

import com.biyesheji.cims.bean.CimsPinkun;
import com.biyesheji.cims.bean.CimsPinkunjilu;
import org.apache.ibatis.annotations.*;

import java.util.Collection;


@Mapper
public interface CimsPinkunjiluMapper {

    //查找所有低保领取记录
    @Select("select * from cims_pinkunjilu")
    @Results({
            @Result(column = "cims_pinkun_id",property = "cimsPinkun",one=@One(select = "com.biyesheji.cims.mapper.CimsPinkunMapper.findCimsPinkunById"))
    })
    public Collection<CimsPinkunjilu> findAllPinkunjilu();

    //通过领取记录id查找记录
    @Select("select * from cims_pinkunjilu where cims_pinkunjilu_id=#{id}")
    @Results({
            @Result(column = "cims_pinkun_id",property = "cimsPinkun",one=@One(select = "com.biyesheji.cims.mapper.CimsPinkunMapper.findCimsPinkunById"))
    })
    public CimsPinkunjilu findPinkunjiluByJId(String jid);

    //通过贫困户id查找所有记录
    @Select("select * from cims_pinkunjilu where cims_pinkun_id=#{id}")
    @Results({
            @Result(column = "cims_pinkun_id",property = "cimsPinkun",one=@One(select = "com.biyesheji.cims.mapper.CimsPinkunMapper.findCimsPinkunById"))
    })
    public Collection<CimsPinkunjilu> findAllPinkunjiluById(String id);

    //添加一条领取记录
    @Insert("insert into cims_pinkunjilu values(#{cimsPinkunjilu.CimsPinkunjiluId},#{cimsPinkun.CimsPinkunId},#{cimsPinkunjilu.CimsPinkunjiluMoney},#{cimsPinkunjilu.CimsPinkunjiluDate},#{cimsPinkunjilu.CimsPinkunjiluPlace},#{cimsPinkunjilu.CimsPinkunjiluRemarks})")
    public int addPinkunjilu(@Param("cimsPinkunjilu") CimsPinkunjilu cimsPinkunjilu,@Param("cimsPinkun") CimsPinkun cimsPinkun);

    //删除所属贫困id的所有记录
    @Delete("delete from cims_pinkunjilu where cims_pinkun_id=#{id}")
    public int deletePinkunjiluById(String id);
}
