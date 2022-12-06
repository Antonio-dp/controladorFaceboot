/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package coninterfaces;

import entidades.Comentario;
import excepciones.PersistException;
import java.util.List;


/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IFachadaModeloComentario {

    /**
     * Método que se encarga de agregar un comentario
     * @param comentario a agregar
     * @return comentario agregado
     * @throws PersistException Excepción que puede ocurrir al momento de agregar
     */
    public Comentario agregarComentario(Comentario comentario) throws PersistException;

    /**
     * Método que se encarga de consultar una lista de comentarios
     * @param idPublicacion de la cual se extraeran los comentarios
     * @return Lista de comentarios relaccionados a la publiación
     * @throws PersistException Excepción que puede ocurrir al consultar
     */
    public List<Comentario> consultarComentarios(Integer idPublicacion) throws PersistException;

    /**
     * Método que se encarga de eliminar un comentario
     * @param comentario a eliminar
     * @return comentario eliminado
     * @throws PersistException Excepción que puede ocurrir al eliminar
     */
    public Comentario eliminarComentario(Comentario comentario) throws PersistException;
}
