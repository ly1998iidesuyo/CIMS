package com.biyesheji.cims.service;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsShequ;
import com.biyesheji.cims.mapper.CimsHujiMapper;
import com.biyesheji.cims.mapper.CimsShequMapper;
import com.biyesheji.cims.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CimsHujiService {

    @Autowired
    CimsHujiMapper cimsHujiMapper;

    @Autowired
    CimsShequMapper cimsShequMapper;


    /**
     * 通过id查找单个户籍
     * @param id 户籍id
     * @return 单个户籍对象
     */
    public CimsHuji findCimsHujiById(String id){

        //System.out.println(cimsHujiMapper.findCimsHujiById(id).getCimsShequ().getCimsShequName());

        return cimsHujiMapper.findCimsHujiById(id);

    }

    /**
     * 查找所有户籍
     * @return 返回户籍对象集合容器
     */
    public Collection<CimsHuji> findAllCimsHuji(){


        return cimsHujiMapper.findAllCimsHuji();
    }

    /**
     * 添加户籍
     * @param cimsHuji 从前端传入的数据绑定的户籍对象，主键工具类生成主键
     * @return 添加成功返回1,失败返回0
     */
    public int addCimsHuji(CimsHuji cimsHuji,CimsShequ cimsShequ){

        //主键随机生成
        cimsHuji.setCimsHujiId(UuidUtil.CimsHujiUuid());
        int a = cimsHujiMapper.insertCimsHuji(cimsHuji,cimsShequ);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    /**
     * 更新户籍信息
     * @param cimsHuji 从前端传入的数据绑定的户籍对象
     * @return 成功返回1,失败返回0
     */
    public int UpdateCimsHuji(CimsHuji cimsHuji,CimsShequ cimsShequ){

        int a=cimsHujiMapper.updateCimsHuji(cimsHuji,cimsShequ);
        if(a!=0){
            return 1;
        }
        return 0;
    }
}
