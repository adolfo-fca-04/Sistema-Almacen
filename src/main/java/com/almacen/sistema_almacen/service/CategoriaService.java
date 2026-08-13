
package com.almacen.sistema_almacen.service;



import com.almacen.sistema_almacen.model.Categoria;
import com.almacen.sistema_almacen.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    //Obtener categorias de la db
    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }
    
    //Guardar y actualizar categoria
    public Categoria guardar(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        return categoriaRepository.save(categoria);
    }
    
    //Buscar categoria por ID
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
    
    //Borrar categoria
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
    
}
