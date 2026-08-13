
package com.almacen.sistema_almacen.controller;

import com.almacen.sistema_almacen.service.CategoriaService;
import com.almacen.sistema_almacen.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public String listarCategorias(Model model) {

        // Pasamos la lista de categorías extraídas de MySQL a la vista HTML
        model.addAttribute("categorias", categoriaService.listarTodas());
        // Enviamos un objeto Categoria vacío para vincularlo al formulario HTML
        model.addAttribute("nuevaCategoria", new Categoria());
        return "categorias/index";
    }   
    
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("nuevaCategoria") Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Categoria categoriaExistente = categoriaService.obtenerPorId(id);
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("nuevaCategoria", categoriaExistente); // Pasamos el objeto lleno
        return "categorias/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminar(id);
        return "redirect:/categorias";
    }
}
