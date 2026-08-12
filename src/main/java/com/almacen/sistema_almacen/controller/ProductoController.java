
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
    
}
