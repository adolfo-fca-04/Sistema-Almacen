
package com.almacen.sistema_almacen.service;

import com.almacen.sistema_almacen.model.Proveedor;
import com.almacen.sistema_almacen.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getNombreEmpresa() == null || proveedor.getNombreEmpresa().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede estar vacío.");
        }
        return proveedorRepository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
    
}
