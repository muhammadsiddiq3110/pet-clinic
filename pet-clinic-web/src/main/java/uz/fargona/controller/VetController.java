package uz.fargona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.fargona.service.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/1.html"})
    public String listVets(Model model) {
        var list = vetService.findAll().stream()
                .toList();
        model.addAttribute("vets", list);
        return "vet/index";
    }
}
