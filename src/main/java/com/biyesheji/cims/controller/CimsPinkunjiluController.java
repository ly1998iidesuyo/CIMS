package com.biyesheji.cims.controller;

import com.biyesheji.cims.bean.CimsPinkun;
import com.biyesheji.cims.bean.CimsPinkunjilu;
import com.biyesheji.cims.service.CimsPinkunjiluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class CimsPinkunjiluController {

    @Autowired
    CimsPinkunjiluService cimsPinkunjiluService;

    //查找所有领取记录
    @GetMapping("/drawrecords")
    public String drawrecords(Model model) {


        model.addAttribute("drawrecords",cimsPinkunjiluService.findAllPinkunjilu());
        return "drawrecord/drawrecordisplay";
    }

    //通过领取记录id查找领取记录
    @GetMapping("/sdrawrecord")
    public String sdrawrecord(Model model, CimsPinkunjilu cimsPinkunjilu) {

        String a = cimsPinkunjilu.getCimsPinkunjiluId();
        if (cimsPinkunjiluService.findPinkunjiluByJId(a) != null) {

            model.addAttribute("drawrecord", cimsPinkunjiluService.findPinkunjiluByJId(a));
            return "drawrecord/drawrecordisplay1";
        }
        return "drawrecord/drawrecordisplay2";
    }

    //通过贫困户id查找领取记录
    @GetMapping("/ssdrawrecord")
    public String ssdrawrecord(Model model, CimsPinkun cimsPinkun, HttpSession session) {

        String a = cimsPinkun.getCimsPinkunId();
        session.setAttribute("Pinkunid",cimsPinkun.getCimsPinkunId());
        Collection<CimsPinkunjilu> cimsPinkunjilus=cimsPinkunjiluService.findPinkunjiluById(a);
        model.addAttribute("drawrecords", cimsPinkunjiluService.findPinkunjiluById(a));
        return "drawrecord/drawrecordisplay3";
    }

    //前往添加页面
    @GetMapping("/drawrecord")
    public String toAddPage(){

        return "drawrecord/add";
    }

    //添加低保领取记录(领取低保)
    @PostMapping("/drawrecord")
    public String addCimsPinkunjilu(CimsPinkunjilu cimsPinkunjilu,CimsPinkun cimsPinkun,HttpSession session){

        String id=(String) session.getAttribute("Pinkunid");

        cimsPinkun.setCimsPinkunId(id);

        int a=cimsPinkunjiluService.addPinkunjilu(cimsPinkunjilu,cimsPinkun);
        if(a!=1){
            return "drawrecord/error";
        }
        return "redirect:/drawrecords";
    }
}
