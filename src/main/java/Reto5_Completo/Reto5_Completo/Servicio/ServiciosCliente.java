package Reto5_Completo.Reto5_Completo.Servicio;

import Reto5_Completo.Reto5_Completo.Modelo.Cliente;
import Reto5_Completo.Reto5_Completo.Repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> sercli= metodosCrud.getCliente(client.getIdClient());
            if(sercli.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> serclie= metodosCrud.getCliente(client.getIdClient());
            if(!serclie.isEmpty()){
                if(client.getName()!=null){
                    serclie.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    serclie.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    serclie.get().setPassword(client.getPassword());
                }
                metodosCrud.save(serclie.get());
                return serclie.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
