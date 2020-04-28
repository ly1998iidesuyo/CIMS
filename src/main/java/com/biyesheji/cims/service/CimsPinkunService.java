package com.biyesheji.cims.service;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsPinkun;
import com.biyesheji.cims.mapper.CimsPinkunMapper;
import com.biyesheji.cims.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CimsPinkunService {

    @Autowired
    CimsPinkunMapper cimsPinkunMapper;
    @Autowired
    CimsPinkunjiluService cimsPinkunjiluService;

    //查找所有贫困信息
    public Collection<CimsPinkun> findAllCimsPinkun(){

        return cimsPinkunMapper.findAllCimsPinkun();
    }

    //通过id查找贫困户信息
    public CimsPinkun findCimsPinkunById(String id){

        return cimsPinkunMapper.findCimsPinkunById(id);
    }

    //新增贫困户
    public int addCimsPinkun(CimsPinkun cimsPinkun, CimsHuji cimsHuji){

        cimsPinkun.setCimsPinkunId(UuidUtil.CimsPinkunUuid());
        int a = cimsPinkunMapper.addCimsPinkun(cimsPinkun,cimsHuji);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    //更新贫困户
    public int updateCimsPinkun(CimsPinkun cimsPinkun){
        int a = cimsPinkunMapper.updateCimsPinkun(cimsPinkun);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    //删除贫困资格
    public int deleteCimsPinkun(String id){

        int b = cimsPinkunjiluService.deletePinkunjiluById(id);

        int a = cimsPinkunMapper.deleteCimsPinkun(id);
        if(a!=0&&b!=0){
            return 1;
        }
        return 0;
    }
}
