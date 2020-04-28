package com.biyesheji.cims.service;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsJuminb;
import com.biyesheji.cims.mapper.CimsHujiMapper;
import com.biyesheji.cims.mapper.CimsJuminbMapper;
import com.biyesheji.cims.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CimsJuminbService {

    @Autowired
    CimsJuminbMapper cimsJuminbMapper;
    @Autowired
    CimsHujiMapper cimsHujiMapper;


    //查找所有居民
    public Collection<CimsJuminb> findAllCimsJuminbs(){

        return cimsJuminbMapper.findAllCimsJuminbs();
    }

    //通过id查找居民
    public CimsJuminb findCimsJuminbByInid(String idcardnum){

        return cimsJuminbMapper.findCimsJuminbByInid(idcardnum);
    }

    //添加居民
    public int addCimsJuminb(CimsJuminb cimsJuminb, CimsHuji cimsHuji){

        cimsJuminb.setCimsJuminbId(UuidUtil.CimsJuminbUuid());
        //cimsHuji.setCimsHujiId(cimsHujiMapper.findCimsHujiIdByName(cimsHuji.getCimsHujiName()));
        CimsHuji cimsHuji1=cimsHuji;
        int a=cimsJuminbMapper.addCimsJuminb(cimsJuminb,cimsHuji);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    //更新居民信息
    public int updateCimsJuminb(CimsJuminb cimsJuminb){

        int a = cimsJuminbMapper.updateCimsJuminb(cimsJuminb);
        if(a!=0){
            return 1;
        }
        return 0;
    }
}
