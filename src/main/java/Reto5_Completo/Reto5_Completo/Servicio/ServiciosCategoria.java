package Reto5_Completo.Reto5_Completo.Servicio;

import Reto5_Completo.Reto5_Completo.Modelo.Categoria;
import Reto5_Completo.Reto5_Completo.Repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>sercat=metodosCrud.getCategoria(categoria.getId());
            if(!sercat.isEmpty()){
                if(categoria.getDescription()!=null){
                    sercat.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    sercat.get().setName(categoria.getName());
                }
                return metodosCrud.save(sercat.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean sercas=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return sercas;
    }

}
