package uz.fargona.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/,","index","1.html"})
    public String index(){
        return "index";
    }
}
