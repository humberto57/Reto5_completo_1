package Reto5_Completo.Reto5_Completo.Controlador;

import Reto5_Completo.Reto5_Completo.Modelo.Categoria;
import Reto5_Completo.Reto5_Completo.Servicio.ServiciosCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorCategoria {
    @Autowired
    private ServiciosCategoria servicio;
    @GetMapping("/all")
    public List<Categoria> getCategoria(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int categoriaId) {
        return servicio.getCategoria(categoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return servicio.save(categoria);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return servicio.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicio.deletecategoria(categoriaId);
    }

}
