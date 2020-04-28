package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsJuminb;
import com.biyesheji.cims.bean.CimsJumind;
import com.biyesheji.cims.service.CimsJumindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CimsJunmidController {

    @Autowired
    CimsJumindService cimsJumindService;


    //查找并前往修改信息
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){

        CimsJumind cimsJumind=cimsJumindService.findCimsJumind(id);
        CimsJuminb cimsJuminb=new CimsJuminb();
        cimsJuminb.setCimsJuminbId(id);


        model.addAttribute("basic",cimsJuminb);
        model.addAttribute("detail",cimsJumind);

        return "resident/detail/edit";
    }

    //修改信息
    @PutMapping("/detail")
    public String updateCimsJumind(CimsJumind cimsJumind,CimsJuminb cimsJuminb){

        int a=cimsJumindService.updateCimsJumind(cimsJumind,cimsJuminb);

        if(a==1){
            return "redirect:/basics";
        }
        return "resident/detail/error";
    }

    //新增信息
    @PostMapping("/detail")
    public String addCimsJumind(CimsJumind cimsJumind,CimsJuminb cimsJuminb){


        int a=cimsJumindService.addCimsJumind(cimsJumind,cimsJuminb);
        if(a==1){
            return "redirect:/basics";
        }
        return "resident/detail/error";
    }
}
