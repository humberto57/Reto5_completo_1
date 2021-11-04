package Reto5_Completo.Reto5_Completo.Servicio;

import Reto5_Completo.Reto5_Completo.Modelo.Mensaje;
import Reto5_Completo.Reto5_Completo.Repositorio.RepositorioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> sermen= metodosCrud.getMessage(message.getIdMessage());
            if(sermen.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> sermes= metodosCrud.getMessage(message.getIdMessage());
            if(!sermes.isEmpty()){
                if(message.getMessageText()!=null){
                    sermes.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(sermes.get());
                return sermes.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
