package uz.fargona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.fargona.model.Vet;
import uz.fargona.service.VetService;

import java.util.Set;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/1.html","/vets.html"})
    public String listVets(Model model) {
        var list = vetService.findAll().stream()
                .toList();
        model.addAttribute("vets", list);
        return "vet/index";
    }
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetJson(){
        return vetService.findAll();
    }
}
