package uz.fargona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vets")
public class VetController {
    @RequestMapping({"/index","/index.html"})
    public String listVets(){
        return "vet/index";
    }
}
