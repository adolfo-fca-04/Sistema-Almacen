
package com.almacen.sistema_almacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.almacen.sistema_almacen.model.Proveedor;
import com.almacen.sistema_almacen.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("nuevoProveedor", new Proveedor());
        return "proveedores/index";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute("nuevoProveedor") Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Proveedor proveedorExistente = proveedorService.buscarPorId(id);
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("nuevoProveedor", proveedorExistente);
        return "proveedores/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable("id") Long id) {
        proveedorService.eliminar(id);
        return "redirect:/proveedores";
    }
    
}
