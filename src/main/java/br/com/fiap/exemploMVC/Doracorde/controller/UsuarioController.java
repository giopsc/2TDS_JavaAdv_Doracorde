package br.com.fiap.exemploMVC.Doracorde.controller;

import br.com.fiap.exemploMVC.Doracorde.domainmodel.Usuario;
import br.com.fiap.exemploMVC.Doracorde.service.UsuarioServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private @Setter UsuarioServiceImpl service;

    @GetMapping("/addNew")
    public String addNewUsuario( Model model ){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "newUsuario";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("usuario") Usuario usuario) {
        this.service.save( usuario );
        return "redirect:/";
    }

    @GetMapping("/deleteUsuario/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById( id );
        return "redirect:/";
    }

    @GetMapping("/listAll")
    public String viewAsList(Model model){
        List<Usuario> usuarioList = this.service.findAllUsuario();
        model.addAttribute("allUsuarioList", usuarioList);
        return "listUsuario";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Usuario> usuario  = this.service.findById(id);
        if(usuario.isPresent())
            model.addAttribute("usuario", usuario.get());
        else
            System.out.println("Usuario not found");
        return "updateUsuario";
    }

    @PostMapping("/update")
    public String update( @ModelAttribute("usuario") Usuario usuario ){
        this.service.save( usuario );
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String showUsuario( @PathVariable("id") Long id, Model model){
        Optional<Usuario> usuario = this.service.findById(id);

        if( usuario.isPresent() )
            model.addAttribute("usuario", usuario.get());
        else
            System.out.println("Usuario not found");
        return "showUsuario";
    }

}
