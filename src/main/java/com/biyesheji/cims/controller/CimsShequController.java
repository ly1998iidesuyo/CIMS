package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsShequ;
import com.biyesheji.cims.service.CimsShequService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CimsShequController {

    @Autowired
    CimsShequService cimsShequService;


    //查询所有社区 get/xxs
    @GetMapping("/communities")
    public String communities(Model model){

        model.addAttribute("communities",cimsShequService.findAllCimsShequ());
        return "community/commdisplay";
    }


    //通过id查询社区 get/sxx
    @GetMapping("/scommunity")
    public String community(Model model, CimsShequ cimsShequ){
        if(cimsShequService.findCimsShequById(cimsShequ.getCimsShequId())!=null){

            model.addAttribute("community",cimsShequService.findCimsShequById(cimsShequ.getCimsShequId()));
            return "community/commdisplay1";
        }

        return "community/commdisplay2";
    }


    //前往添加页面  get/xx
    @GetMapping("/community")
    public String toAddPage(){

        return "community/add";
    }


    //添加社区   post/xx
    @PostMapping("/community")
    public String AddCimsShequ(CimsShequ cimsShequ){

        int a=cimsShequService.addCimsShequ(cimsShequ);
        if(a==1) {

            return "redirect:/communities";
        }
        return "community/error";
    }


    //前往更新社区信息页面  get/xx/id
    @GetMapping("/community/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model){

        CimsShequ cimsShequ=cimsShequService.findCimsShequById(id);

        model.addAttribute("community",cimsShequ);

        return "community/add";
    }


    //更新社区信息    put/xx
    @PutMapping("/community")
    public String EditCimsShequ(CimsShequ cimsShequ){

        int a=cimsShequService.updateCimsShequ(cimsShequ);

        if(a==1){
            return "redirect:/communities";
        }
        return "community/error";
    }

}
