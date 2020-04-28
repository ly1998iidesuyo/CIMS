package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsShequ;
import com.biyesheji.cims.service.CimsHujiService;
import com.biyesheji.cims.service.CimsShequService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;


@Controller
public class CimsHujiController {

    @Autowired
    CimsHujiService cimsHujiService;

    @Autowired
    CimsShequService cimsShequService;


    //所有户籍信息
    @GetMapping("/hhregisters")
    public String hhregisters(Model model){

        model.addAttribute("hhregisters",cimsHujiService.findAllCimsHuji());
        return "resident/hhregister/hhregisterdisplay";
    }

    //查找户籍信息
    @GetMapping("/hhregister")
    public String hhregister(Model model,CimsHuji cimsHuji){

        if(cimsHujiService.findCimsHujiById(cimsHuji.getCimsHujiId())!=null) {
            model.addAttribute("hhregister", cimsHujiService.findCimsHujiById(cimsHuji.getCimsHujiId()));
            return "resident/hhregister/hhregisterdisplay1";
        }
        return "resident/hhregister/hhregisterdisplay2";
    }

    //前往添加页面
    @GetMapping("/hregister")
    public String toAddPage(Model model){

        Collection<CimsShequ> cimsShequs=cimsShequService.findAllCimsShequ();
        model.addAttribute("communities",cimsShequs);

        return "resident/hhregister/add&edit";
    }

    //添加户籍
    @PostMapping("/hregister")
    public String addCimsHuji(CimsHuji cimsHuji,CimsShequ cimsShequ){

        int a = cimsHujiService.addCimsHuji(cimsHuji,cimsShequ);
        if(a==1) {
            return "redirect:/hhregisters";
        }
        return "resident/hhregister/error";
    }

    //前往编辑页面
    @GetMapping("/hregister/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model){

        CimsHuji cimsHuji=cimsHujiService.findCimsHujiById(id);
        System.out.println(cimsHuji.getCimsShequ().getCimsShequName());
        //将户籍信息回显到前端
        model.addAttribute("hregister",cimsHujiService.findCimsHujiById(id));

        //将社区信息回显到前端
        Collection<CimsShequ> cimsShequs=cimsShequService.findAllCimsShequ();
        model.addAttribute("communities",cimsShequs);

        return "resident/hhregister/add&edit";
    }

    //编辑户籍信息
    @PutMapping("/hregister")
    public String updateEmp(CimsHuji cimsHuji,CimsShequ cimsShequ){

        int a = cimsHujiService.UpdateCimsHuji(cimsHuji,cimsShequ);
        if(a==1) {
            return "redirect:/hhregisters";
        }
        return "resident/hhregister/error";
    }
}

