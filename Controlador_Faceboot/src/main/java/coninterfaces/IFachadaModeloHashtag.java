/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coninterfaces;

import entidades.Hashtag;
import entidades.Publicacion;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;

/**
 *
 * @author tonyd
 */
public interface IFachadaModeloHashtag {
    public Hashtag agregarHashtag(Hashtag hashtag) throws PersistException;
    public List<Hashtag> agregarHashtags(List<Hashtag> hashtags) throws PersistException;
    public Hashtag consultarHashtag(Integer idHashtag) throws NotFoundException;
    public Hashtag eliminarHashtag(Integer idHashtag) throws PersistException;
    public Hashtag consultarPorTema(String tema) throws Exception;
}
