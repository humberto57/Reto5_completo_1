package Reto5_Completo.Reto5_Completo.Repositorio;

import Reto5_Completo.Reto5_Completo.Interface.InterfaceCategoria;
import Reto5_Completo.Reto5_Completo.Modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud;
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }

    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    public void delete(Categoria Categoria){
        crud.delete(Categoria);
    }
}
