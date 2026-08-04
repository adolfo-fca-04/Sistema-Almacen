
package com.almacen.sistema_almacen.controller;

import com.almacen.sistema_almacen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    //Ruta para la lista de las categorias
    @GetMapping
    public String listarCategorias(Model model) {
        //Prueva de vista 4-08-2026
        model.addAttribute("titulo", "Listado de Categorias de la Tienda");
        // Pasamos la lista de categorías extraídas de MySQL a la vista HTML
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categorias/index"; // "templates/categorias/index.html"
    }    
}
