package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsJuminb;
import com.biyesheji.cims.service.CimsHujiService;
import com.biyesheji.cims.service.CimsJuminbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class CimsJuminbController {

    @Autowired
    CimsJuminbService cimsJuminbService;
    @Autowired
    CimsHujiService cimsHujiService;

    //所有居民信息
    @GetMapping("/basics")
    public String basics(Model model){

        model.addAttribute("basics",cimsJuminbService.findAllCimsJuminbs());
        return "resident/basic/basicdisplay";
    }

    //利用身份证号查询单个用户
    @GetMapping("/sbasic")
    public String basic(CimsJuminb cimsJuminb, Model model) {

        if(cimsJuminbService.findCimsJuminbByInid(cimsJuminb.getCimsJuminbIdcardnum())!=null){
           model.addAttribute("basic",cimsJuminbService.findCimsJuminbByInid(cimsJuminb.getCimsJuminbIdcardnum()));
           return "resident/basic/basicdisplay1";
        }
        return "resident/basic/basicdisplay2";
    }

    //前往添加页面
    @GetMapping("/basic")
    public String toAddPage(){

        return "resident/basic/add";
    }

    //添加居民
    @PostMapping("/basic")
    public String addCimsJuminb(CimsJuminb cimsJuminb, CimsHuji cimsHuji){

        int a=cimsJuminbService.addCimsJuminb(cimsJuminb,cimsHuji);
        if(a==1){
            return "redirect:/basics";
        }
        return "resident/basic/error";
    }

    //前往修改页面
    @GetMapping("/basic/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model){

        CimsJuminb cimsJuminb=cimsJuminbService.findCimsJuminbByInid(id);
        model.addAttribute("basic",cimsJuminb);
        return "resident/basic/edit";
    }

    //修改信息
    @PutMapping("/basic")
    public String updateCimsJuminb(CimsJuminb cimsJuminb){

        int a = cimsJuminbService.updateCimsJuminb(cimsJuminb);
        if(a==1){
            return "redirect:/basics";
        }
        return "resident/basic/error";
    }
}
