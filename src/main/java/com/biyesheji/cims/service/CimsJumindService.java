package com.biyesheji.cims.service;

import com.biyesheji.cims.bean.CimsJuminb;
import com.biyesheji.cims.bean.CimsJumind;
import com.biyesheji.cims.mapper.CimsJumindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CimsJumindService {


    @Autowired
    CimsJumindMapper cimsJumindMapper;

    //查找详细信息
    public CimsJumind findCimsJumind(String id){

        CimsJumind cimsJumind=cimsJumindMapper.findCimsJumind(id);

        return cimsJumind;
    }

    //更新详细信息
    public int updateCimsJumind(CimsJumind cimsJumind, CimsJuminb cimsJuminb){

        int a=cimsJumindMapper.updateCimsJumind(cimsJumind,cimsJuminb);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    //插入详细信息
    public int addCimsJumind(CimsJumind cimsJumind,CimsJuminb cimsJuminb){

        int a=cimsJumindMapper.addCimsJumind(cimsJuminb,cimsJumind);
        System.out.println(cimsJuminb.getCimsJuminbId());
        if(a!=0){
            return 1;
        }
        return 0;
    }
}
