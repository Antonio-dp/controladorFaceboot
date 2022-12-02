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
 * @author tonyd
 */
public interface IFachadaModeloComentario {

    public Comentario agregarComentario(Comentario comentario) throws PersistException;

    public List<Comentario> consultarComentarios(Integer idPublicacion) throws PersistException;

    public Comentario eliminarComentario(Comentario comentario) throws PersistException;
}
