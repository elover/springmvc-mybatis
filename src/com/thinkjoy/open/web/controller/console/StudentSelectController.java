package com.thinkjoy.open.web.controller.console;

import com.thinkjoy.open.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mac on 14-2-21.
 */
@Controller
public class StudentSelectController extends BaseController {

    @Autowired
    private ScService scService;

    @RequestMapping("/console/student/select/{id}")
    public String selectStudent(@PathVariable String id ,Model model){
//        List<Sc> scList = sc.findAll(id);
        model.addAttribute("scList", scService.findAll(id));
        return "student-select";
    }

}
