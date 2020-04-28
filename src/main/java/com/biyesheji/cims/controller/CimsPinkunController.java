package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsHuji;
import com.biyesheji.cims.bean.CimsPinkun;
import com.biyesheji.cims.service.CimsHujiService;
import com.biyesheji.cims.service.CimsPinkunService;
import com.biyesheji.cims.service.CimsPinkunjiluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CimsPinkunController {

    @Autowired
    CimsPinkunService cimsPinkunService;
    @Autowired
    CimsHujiService cimsHujiService;
    @Autowired
    CimsPinkunjiluService cimsPinkunjiluService;

    //查找所有贫困信息
    @GetMapping("/poorhhs")
    public String poorhhs(Model model){

        model.addAttribute("poorhhs",cimsPinkunService.findAllCimsPinkun());
        return "poorhh/poorhhdisplay";
    }

    //通过id查找贫困户信息
    @GetMapping("/spoorhh")
    public String poorhh(Model model, CimsPinkun cimsPinkun){

        if(cimsPinkunService.findCimsPinkunById(cimsPinkun.getCimsPinkunId())!=null){
            model.addAttribute("poorhh",cimsPinkunService.findCimsPinkunById(cimsPinkun.getCimsPinkunId()));
            return "poorhh/poorhhdisplay1";
        }
        return "poorhh/poorhhdisplay2";
    }

    //前往添加页面
    @GetMapping("/poorhh")
    public String toAddPage(){

        return "poorhh/add";
    }

    //添加贫困信息
    @PostMapping("/poorhh")
    public String addCimsPinkun(CimsPinkun cimsPinkun,CimsHuji cimsHuji){

        int a=cimsPinkunService.addCimsPinkun(cimsPinkun,cimsHuji);
        if(a==1){
            return "redirect:/poorhhs";
        }
        return "poorhh/error";
    }

    //前往编辑页面
    @GetMapping("/poorhh/{id}")
    public String toeEditPage(Model model, @PathVariable("id") String id){

        CimsPinkun cimsPinkun=cimsPinkunService.findCimsPinkunById(id);
        model.addAttribute("huji",cimsPinkun.getCimsHuji());
        model.addAttribute("poorhh",cimsPinkun);

        return "poorhh/edit";
    }

    //更新贫困信息
    @PutMapping("/poorhh")
    public String updateCimsPinkun(CimsPinkun cimsPinkun){

        int a=cimsPinkunService.updateCimsPinkun(cimsPinkun);
        if(a==1){
            return "redirect:/poorhhs";
        }
        return "poorhh/error";
    }

    //删除贫困资格
    @DeleteMapping("/poorhh/{id}")
    public String deleteCimsPinkun(@PathVariable("id") String id){

        int a=cimsPinkunService.deleteCimsPinkun(id);
        if(a==1){
            return "redirect:/poorhhs";
        }
        return "poorhh/error";
    }

}
