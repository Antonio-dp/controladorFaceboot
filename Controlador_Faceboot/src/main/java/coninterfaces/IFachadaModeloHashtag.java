/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coninterfaces;

import entidades.Hashtag;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IFachadaModeloHashtag {
    
    /**
     * Método que se encarga de agregar un hashtag
     * @param hashtag a agregar
     * @return Hashtag agregado
     * @throws PersistException Excepción qie puede ocurrir al agregar el hashtag
     */
    public Hashtag agregarHashtag(Hashtag hashtag) throws PersistException;
    
    /**
     * Método que se encarga de agregar una lista de hashtag
     * @param hashtags lista de hashtag a agregar
     * @return lista de hashtag agregada
     * @throws PersistException Excepción que puede ocurrir al agregar
     */
    public List<Hashtag> agregarHashtags(List<Hashtag> hashtags) throws PersistException;
    
    /**
     * Método que se encarga de consultar un hashtag por id
     * @param idHashtag a consultar
     * @return Hashtag consultado
     * @throws NotFoundException Excepción que puede ocurrir al consultar
     */
    public Hashtag consultarHashtag(Integer idHashtag) throws NotFoundException;
    
    /**
     * Método que se encarga de eliminar un hashtag por id
     * @param idHashtag del hashtag a eliminar
     * @return hashtag eliminado
     * @throws PersistException Excepión que puede ocurrir al eliminar
     */
    public Hashtag eliminarHashtag(Integer idHashtag) throws PersistException;
    
    /**
     * Método que se encarga de consultar un hashtag por tema
     * @param tema a consultar
     * @return hashtag consultado
     * @throws Exception Exepción que puede ourrir al consultar
     */
    public Hashtag consultarPorTema(String tema) throws Exception;
}
