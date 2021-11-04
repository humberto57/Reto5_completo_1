package Reto5_Completo.Reto5_Completo.Servicio;

import Reto5_Completo.Reto5_Completo.Modelo.Boat;
import Reto5_Completo.Reto5_Completo.Repositorio.RepositorioBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosBoat {
    @Autowired
    private RepositorioBoat metodosCrud;

    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBoat(int boatId) {
        return metodosCrud.getBoat(boatId);
    }

    public Boat save(Boat boat){
        if(boat.getId()==null){
            return metodosCrud.save(boat);
        }else{
            Optional<Boat> serbas=metodosCrud.getBoat(boat.getId());
            if(serbas.isEmpty()){
                return metodosCrud.save(boat);
            }else{
                return boat;
            }
        }
    }

    public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> serbar=metodosCrud.getBoat(boat.getId());
            if(!serbar.isEmpty()){
                if(boat.getName()!=null){
                    serbar.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    serbar.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    serbar.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    serbar.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    serbar.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(serbar.get());
                return serbar.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }


    public boolean deleteBoat(int boatId) {
        Boolean aBoolean = getBoat(boatId).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
