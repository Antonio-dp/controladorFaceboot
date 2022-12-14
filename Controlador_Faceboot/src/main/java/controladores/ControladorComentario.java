/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import commodelo.FachadaModeloComentario;
import coninterfaces.IFachadaModeloComentario;
import entidades.Comentario;
import eventos.Eventos;
import excepciones.PersistException;
import java.util.List;
import peticiones.PeticionComentario;
import peticiones.PeticionComentarios;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ControladorComentario{
    
    /**
     * Instancia de IFachadaModeloComentario
     */
    private IFachadaModeloComentario fachadaComentario;

    /**
     * Constructor que inicializa la instancia de la clase
     */
    public ControladorComentario() {
        this.fachadaComentario = new FachadaModeloComentario();
    }

    /**
     * Método que se encarga de registrar un comentario
     * @param comentario a registrar
     * @return PeticionComentario con el resultado de la acción
     */
    public PeticionComentario registrarComentario(Comentario comentario) {
        
        try{
            Comentario comentarioRegistrado = fachadaComentario.agregarComentario(comentario);
            return new PeticionComentario(Eventos.registrarComentario, 200, comentarioRegistrado);
        } catch(PersistException pe){
            return new PeticionComentario(Eventos.registrarComentario, 503, pe.getMessage());
        }
        
    }
    
    /**
     * Método que se encarga de consultar los compentarios por medio de la publicación
     * @param idPublicacion a consultar
     * @return PeticionComentario con el resultado de la acción
     */
    public PeticionComentarios consultarComentarios(Integer idPublicacion){
        try{
            List<Comentario> comentarios = fachadaComentario.consultarComentarios(idPublicacion);
            return new PeticionComentarios(Eventos.consultarComentarios, 200, comentarios);
        } catch(PersistException pe){
            return new PeticionComentarios(Eventos.consultarComentarios, 503, pe.getMessage());
        }
    }
 
    /**
     * Método que se encarga de eliminar un comentario
     * @param comentario a eliminar
     * @return PeticionComentario con el resultado de la acción
     */
    public PeticionComentario eliminarComentario(Comentario comentario) {
        try{
            Comentario comentarioEliminado = fachadaComentario.eliminarComentario(comentario);
            return new PeticionComentario(Eventos.eliminarComentario, 200, comentario);
        } catch(PersistException pe){
            return new PeticionComentario(Eventos.eliminarComentario,503, pe.getMessage());
        }
    }
}
