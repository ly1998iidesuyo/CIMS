package com.biyesheji.cims.service;


import com.biyesheji.cims.bean.CimsPinkun;
import com.biyesheji.cims.bean.CimsPinkunjilu;
import com.biyesheji.cims.mapper.CimsPinkunjiluMapper;
import com.biyesheji.cims.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class CimsPinkunjiluService {


    @Autowired
    CimsPinkunjiluMapper cimsPinkunjiluMapper;

    //查找所有领取记录
    public Collection<CimsPinkunjilu> findAllPinkunjilu(){

        return cimsPinkunjiluMapper.findAllPinkunjilu();
    }

    //通过记录id查找领取记录
    public CimsPinkunjilu findPinkunjiluByJId(String jid){

        return cimsPinkunjiluMapper.findPinkunjiluByJId(jid);
    }

    //通过贫困户id查找其所有领取记录
    public Collection<CimsPinkunjilu> findPinkunjiluById(String id){

        return cimsPinkunjiluMapper.findAllPinkunjiluById(id);
    }

    //添加一条领取记录
    public int addPinkunjilu(CimsPinkunjilu cimsPinkunjilu, CimsPinkun cimsPinkun){

        cimsPinkunjilu.setCimsPinkunjiluId(UuidUtil.CimsPinkunjiluUuid());

        cimsPinkunjilu.setCimsPinkunjiluDate(new Date());


        int a=cimsPinkunjiluMapper.addPinkunjilu(cimsPinkunjilu,cimsPinkun);

        if(a!=0){
            return 1;
        }
        return 0;
    }

    //删除贫困户id所属的所有记录

    public int deletePinkunjiluById(String id){

        int a=cimsPinkunjiluMapper.deletePinkunjiluById(id);
        if(a!=0){
            return 1;
        }
        return 0;
    }
}
