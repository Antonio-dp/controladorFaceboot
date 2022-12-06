/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloComentario;
import entidades.Comentario;
import excepciones.PersistException;
import interfaces.IModeloComentario;
import java.util.List;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FachadaModeloComentario implements IFachadaModeloComentario{
    
    /**
     * instancia de IModeloComentario
     */
    private IModeloComentario modeloComentario;
    
    /**
     * Constructor de la clase que inicializa la instancia de la clase
     */
    public FachadaModeloComentario() {
        this.modeloComentario = ModelosFactory.crearModeloComentario();
    }
    
   /**
     * Método que se encarga de agregar un comentario
     * @param comentario a agregar
     * @return comentario agregado
     * @throws PersistException Excepción que puede ocurrir al momento de agregar
     */
    @Override
    public Comentario agregarComentario(Comentario comentario) throws PersistException {
        return modeloComentario.registrar(comentario);
    }

    /**
     * Método que se encarga de consultar una lista de comentarios
     * @param idPublicacion de la cual se extraeran los comentarios
     * @return Lista de comentarios relaccionados a la publiación
     * @throws PersistException Excepción que puede ocurrir al consultar
     */
    @Override
    public List<Comentario> consultarComentarios(Integer idPublicacion) throws PersistException {
        return modeloComentario.consultarComentarios(idPublicacion);
    }

    /**
     * Método que se encarga de eliminar un comentario
     * @param comentario a eliminar
     * @return comentario eliminado
     * @throws PersistException Excepción que puede ocurrir al eliminar
     */
    @Override
    public Comentario eliminarComentario(Comentario comentario) throws PersistException {
        return modeloComentario.eliminar(comentario);
    }
    
}
