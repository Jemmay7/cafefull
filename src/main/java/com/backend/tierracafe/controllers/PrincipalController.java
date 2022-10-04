package com.backend.tierracafe.controllers;

import com.backend.tierracafe.models.UsuarioModel;
import com.backend.tierracafe.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.backend.tierracafe.services.ProductoService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;


@AllArgsConstructor
@Controller
public class PrincipalController {
    
    @Autowired  
    ProductoService productoService;

    @Autowired
    UsuarioService usuarioService;

        
    @GetMapping("/loginadmin")
    public String iniciosesion(){
        return "iniciosesion";
    }
    
    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToIndex(Model model) {
        model.addAttribute("page", "home");
        return "index";
    }

    @GetMapping("/contacto")
    public String goToContact(Model model) {
        model.addAttribute("page", "contacto");
        return "contacto";
    }

    @GetMapping("/cliente")
    public String goToClient(Model model) {

        model.addAttribute("usuario", new UsuarioModel());
        model.addAttribute("clientesList", usuarioService.listarUsuarios());
        return "cliente";
    }

    @PostMapping("/cliente/create")
    public String saveClient(@ModelAttribute UsuarioModel usuario, Model model) {

        if(usuario.getNumeroDocumento() == null || Objects.equals(usuario.getNombre(), "")){
            return "redirect:/cliente";
        }

        try{
            usuarioService.guadarUsuario(usuario);
        } catch(Exception e){
            String msgError = "Error registrando el cliente";
            model.addAttribute("msgError", msgError);
            return goToClient(model);
        }

        return "redirect:/cliente";
    }

    @PostMapping("/cliente/update")
    public String editClient(@ModelAttribute UsuarioModel usuario, Model model) {

        if(usuario.getNumeroDocumento() == null || Objects.equals(usuario.getNombre(), "")){
            return "redirect:/cliente";
        }

        try{
            usuarioService.guadarUsuario(usuario);
        } catch(Exception e){
            String msgError = "Error registrando el cliente";
            model.addAttribute("msgError", msgError);
            return goToClient(model);
        }

        return "redirect:/cliente";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/cliente";
    }


    @GetMapping("/productos")
    public String goToProductos(Model model) {

        //var products = this.productoService.listarProductos();

        model.addAttribute("product", "product");
        return "productos";
    }

    @GetMapping("/quienesSomos")
    public String goToQuienesSomos(Model model) {
        model.addAttribute("page", "quienesSomos");
        return "quienesSomos";
    }

    @GetMapping("/iniciosesion")
    public String goTologinadmin(Model model) {

        model.addAttribute("page", "loginadmin");
        return "loginadmin";
    }

}
