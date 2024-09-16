package br.com.fiap.exemploMVC.Doracorde.controller;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Instrumento;
import br.com.fiap.exemploMVC.Doracorde.service.InstrumentoServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/instrumento")
public class IntrumentoController {

    @Autowired
    private @Setter InstrumentoServiceImpl service;

    @GetMapping("/addNew")
    public String addNewInstrumento( Model model ){
        Instrumento instrumento = new Instrumento();
        model.addAttribute("instrumento", instrumento);
        return "newInstrumento";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("instrumento") Instrumento instrumento) {
        this.service.save( instrumento );
        return "redirect:/";
    }

    @GetMapping("/deleteInstrumento/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById( id );
        return "redirect:/";
    }

    @GetMapping("/listAll")
    public String viewAsList(Model model){
        List<Instrumento> instrumentoList = this.service.findAllInstrumento();
        model.addAttribute("allInstrumentoList", instrumentoList);
        return "listInstrumento";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Instrumento> instrumento  = this.service.findById(id);
        if(instrumento.isPresent())
            model.addAttribute("instrumento", instrumento.get());
        else
            System.out.println("Instrumento não encontrado");
        return "updateInstrumento";
    }

    @PostMapping("/update")
    public String update( @ModelAttribute("instrumento") Instrumento instrumento ){
        this.service.save( instrumento );
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String showInstrumento( @PathVariable("id") Long id, Model model){
        Optional<Instrumento> instrumento = this.service.findById(id);

        if( instrumento.isPresent() )
            model.addAttribute("instrumento", instrumento.get());
        else
            System.out.println("Instrumento não encontrado");
        return "showInstrumento";
    }


}
