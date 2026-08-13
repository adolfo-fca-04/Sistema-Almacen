
package com.almacen.sistema_almacen.controller;

import com.almacen.sistema_almacen.model.Producto;
import com.almacen.sistema_almacen.service.CategoriaService;
import com.almacen.sistema_almacen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping 
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("nuevoProducto", new Producto());
        return "productos/index";   
    }
    
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("nuevoProducto") Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Producto productoExistente = productoService.buscarPorId(id);
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("nuevoProducto", productoExistente);
        return "productos/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}
