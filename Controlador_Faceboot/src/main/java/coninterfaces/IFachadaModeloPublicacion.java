/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package coninterfaces;

import entidades.Publicacion;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IFachadaModeloPublicacion {
    
    /**
     * Método que se encarga de agregar una publicación
     * @param publicacion a registrar
     * @return la publicación agregada
     * @throws PersistException Excepción que puede ocurrir al momento de
     * persistir
     */
    public Publicacion agregarPublicacion(Publicacion publicacion)throws PersistException;
    
    /**
     * Método que consulta todas las publicaciones
     * @return Lista de publicaciones
     * @throws NotFoundException Excepción que puede ocurrir cuando no se
     * enuentran las publicaciones
     */
    public List<Publicacion> consultarPublicaciones()throws NotFoundException;
    
    /**
     * Método que se encarga de eliminar una publicacion
     * @param publicacion a eliminar
     * @return la publicacíon eliminada
     * @throws PersistException Excepción que puede ocurrir al momento de
     * eliminar
     */
    public Publicacion eliminarPublicacion(Publicacion publicacion) throws PersistException;
    
    /**
     * Método que se encarga de consultar una lista de publicaciones por su hashtag
     * @param hashtag a buscar
     * @return Lista de publicaciones que coinciden con el hashtag
     * @throws Exception que puede lanzar al consultar las publicaciones por hashtag
     */
    public List<Publicacion> consultarPublicacionesPorEtiqueta(String hashtag) throws Exception;
}
