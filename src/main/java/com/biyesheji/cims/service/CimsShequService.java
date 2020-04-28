package com.biyesheji.cims.service;

import com.biyesheji.cims.bean.CimsShequ;
import com.biyesheji.cims.mapper.CimsShequMapper;
import com.biyesheji.cims.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CimsShequService {

    @Autowired
    CimsShequMapper cimsShequMapper;

    /**
     * 通过id查找单个社区
     * @param id 社区id
     * @return 返回单个社区对象
     */
    public CimsShequ findCimsShequById(String id){

        return cimsShequMapper.findCimsShequById(id);
    }

    /**
     * 查找所有社区
     * @return 返回社区对象的集合容器
     */
    public Collection<CimsShequ> findAllCimsShequ(){

        return cimsShequMapper.findAllCimsShequ();
    }

    /**
     * 添加社区
     * @param cimsShequ 从前端传入的数据绑定的社区对象，主键工具类生成主键
     * @return 添加成功返回1，失败返回0
     */
    public int addCimsShequ(CimsShequ cimsShequ){

        //利用工具类生成社区主键
        cimsShequ.setCimsShequId(UuidUtil.CimsSheqUid());

        int a=cimsShequMapper.addCimsShequ(cimsShequ);
        if(a!=0){
            return 1;
        }
        return 0;
    }

    /**
     * 更新社区信息
     * @param cimsShequ 从前端传入的数据绑定的社区对象
     * @return 更新成功返回1，失败返回0
     */
    public int updateCimsShequ(CimsShequ cimsShequ){

        int a=cimsShequMapper.updateCimShequ(cimsShequ);
        if(a!=0){
            return 1;
        }
        return 0;
    }
}
