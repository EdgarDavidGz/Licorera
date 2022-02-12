package com.tienda.licorera.controlador;

import java.util.List;

import com.tienda.licorera.modelo.Categoria;
import com.tienda.licorera.modelo.Licor;
import com.tienda.licorera.modelo.Usuario;
import com.tienda.licorera.sevicio.ICategoriaServicio;
import com.tienda.licorera.sevicio.ILicorServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLicor {

    @Autowired
    private ILicorServicio licorServicio;

    @Autowired
    private ICategoriaServicio categoriaServicio;

    @GetMapping({"/licorera","/","/home","/index"})
    public String listarLicores(Model model,Usuario usuario){
        model.addAttribute("usuario", usuario);
        model.addAttribute("cabecera","Licores Disponibles | MaxLicor's");
        model.addAttribute("titulo","LICORES DISPONIBLES");
        List<Categoria>listadoCategorias=categoriaServicio.listarTodas();
        List<Licor>listadoLicores=licorServicio.listarTodos();
        model.addAttribute("categorias",listadoCategorias);
        model.addAttribute("licores",listadoLicores);
        return "index";
    }


}
