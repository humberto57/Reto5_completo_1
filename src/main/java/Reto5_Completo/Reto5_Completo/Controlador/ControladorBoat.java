package Reto5_Completo.Reto5_Completo.Controlador;

import Reto5_Completo.Reto5_Completo.Modelo.Boat;
import Reto5_Completo.Reto5_Completo.Servicio.ServiciosBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorBoat {
    @Autowired
    private ServiciosBoat servicio;
    @GetMapping("/all")
    public List<Boat> getBoats(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int boatId) {
        return servicio.getBoat(boatId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {
        return servicio.save(boat);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat) {
        return servicio.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boatId) {
        return servicio.deleteBoat(boatId);
    }
}
