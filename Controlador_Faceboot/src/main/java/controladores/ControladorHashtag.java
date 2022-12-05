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
 * @author tonyd
 */
public class ControladorHashtag {

    private IFachadaModeloHashtag fachadaHashtag;

    public ControladorHashtag() {
        this.fachadaHashtag = new FachadaModeloHashtag();
    }
    public PeticionHashtag registrarHashtag(Hashtag hashtag){
        try{
            Hashtag hashtagRegistrado = fachadaHashtag.agregarHashtag(hashtag);
            return new PeticionHashtag(Eventos.registrarHashtag, 200, hashtagRegistrado);
        }catch(PersistException pe){
            return new PeticionHashtag(Eventos.consultarHashtag, 503, pe.getMessage());
        }
    }

    public PeticionHashtags registrarHashtags(List<Hashtag> hashtags){
        try{
            List<Hashtag> hashtagsRegistrados = fachadaHashtag.agregarHashtags(hashtags);
            return new PeticionHashtags(Eventos.registrarHashtags, 200, hashtagsRegistrados);
        }catch(PersistException pe){
            return new PeticionHashtags(Eventos.registrarHashtags, 503, pe.getMessage());
        }
    }

    public PeticionHashtag consultarHashtag(Integer idHashtag){
        try{
            Hashtag hashtagConsultado = fachadaHashtag.consultarHashtag(idHashtag);
            return new PeticionHashtag(Eventos.consultarHashtag, 200, hashtagConsultado);
        }catch(NotFoundException pe){
            return new PeticionHashtag(Eventos.consultarHashtag, 503, pe.getMessage());
        }
    }
    
    public PeticionHashtag eliminarHashtag(Integer idHashtag){
        try{
            Hashtag hashtagEliminado = fachadaHashtag.eliminarHashtag(idHashtag);
            return new PeticionHashtag(Eventos.eliminarHashtag, 200, hashtagEliminado);
        }catch(PersistException pe){
            return new PeticionHashtag(Eventos.eliminarHashtag, 503, pe.getMessage());
        }
    }
 
    public PeticionHashtag consultarPorNombre(String tema){
        try{
            Hashtag hashtagEncontrado = fachadaHashtag.consultarPorTema(tema);
            return new PeticionHashtag(Eventos.consultarHashtagPorTema, 200, hashtagEncontrado);
        }catch(Exception ex){
            return new PeticionHashtag(Eventos.consultarHashtagPorTema, 404, ex.getMessage());
        }
    }
}
