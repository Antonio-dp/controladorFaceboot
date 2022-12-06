/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import commodelo.FachadaModeloHashtag;
import coninterfaces.IFachadaModeloHashtag;
import entidades.Hashtag;
import eventos.Eventos;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;
import peticiones.PeticionHashtag;
import peticiones.PeticionHashtags;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ControladorHashtag {

    /**
     * Instancia de IFachadaModeloHashtag
     */
    private IFachadaModeloHashtag fachadaHashtag;

    /**
     * Constructor que inicializa la instancia de la clase
     */
    public ControladorHashtag() {
        this.fachadaHashtag = new FachadaModeloHashtag();
    }
    
    /**
     * Método que se encarga de registrar un hashtag
     * @param hashtag a registrar
     * @return PeticionHashtag con el resltado de la acción
     */
    public PeticionHashtag registrarHashtag(Hashtag hashtag){
        try{
            Hashtag hashtagRegistrado = fachadaHashtag.agregarHashtag(hashtag);
            return new PeticionHashtag(Eventos.registrarHashtag, 200, hashtagRegistrado);
        }catch(PersistException pe){
            return new PeticionHashtag(Eventos.consultarHashtag, 503, pe.getMessage());
        }
    }

    /**
     * Método que se encarga de registrar Hashtasgs por medio de una lista
     * @param hashtags Lista de hashtags a agregar
     * @return PeticionHashtags con el resultado de la acción
     */
    public PeticionHashtags registrarHashtags(List<Hashtag> hashtags){
        try{
            List<Hashtag> hashtagsRegistrados = fachadaHashtag.agregarHashtags(hashtags);
            return new PeticionHashtags(Eventos.registrarHashtags, 200, hashtagsRegistrados);
        }catch(PersistException pe){
            return new PeticionHashtags(Eventos.registrarHashtags, 503, pe.getMessage());
        }
    }

    /**
     * Método que se encarga de consultar un Hashtag por medio de su id
     * @param idHashtag de hashtag a consultar
     * @return PeticionHashtag con el resultado de la acción
     */
    public PeticionHashtag consultarHashtag(Integer idHashtag){
        try{
            Hashtag hashtagConsultado = fachadaHashtag.consultarHashtag(idHashtag);
            return new PeticionHashtag(Eventos.consultarHashtag, 200, hashtagConsultado);
        }catch(NotFoundException pe){
            return new PeticionHashtag(Eventos.consultarHashtag, 404, pe.getMessage());
        }
    }
    
    /**
     * Método que se encarga de eliminar un hashtag por medio de su id
     * @param idHashtag a eliminar
     * @return PeticionHashtag con el resultado de la acción
     */
    public PeticionHashtag eliminarHashtag(Integer idHashtag){
        try{
            Hashtag hashtagEliminado = fachadaHashtag.eliminarHashtag(idHashtag);
            return new PeticionHashtag(Eventos.eliminarHashtag, 200, hashtagEliminado);
        }catch(PersistException pe){
            return new PeticionHashtag(Eventos.eliminarHashtag, 503, pe.getMessage());
        }
    }
 
    /**
     * Método que se encarga de consultar un hashtag por su nombre
     * @param tema el nombre del hashtag a consultar
     * @return PeticionHashtag con el resultado de la acción
     */
    public PeticionHashtag consultarPorNombre(String tema){
        try{
            Hashtag hashtagEncontrado = fachadaHashtag.consultarPorTema(tema);
            return new PeticionHashtag(Eventos.consultarHashtagPorTema, 200, hashtagEncontrado);
        }catch(Exception ex){
            return new PeticionHashtag(Eventos.consultarHashtagPorTema, 404, ex.getMessage());
        }
    }
}
