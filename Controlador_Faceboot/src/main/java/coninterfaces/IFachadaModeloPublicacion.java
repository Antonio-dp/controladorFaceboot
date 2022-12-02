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
 * @author tonyd
 */
public interface IFachadaModeloPublicacion {
    public Publicacion agregarPublicacion(Publicacion publicacion)throws PersistException;
    public List<Publicacion> consultarPublicaciones()throws NotFoundException;
    public Publicacion eliminarPublicacion(Publicacion publicacion) throws PersistException;
    public List<Publicacion> consultarPublicacionesPorEtiqueta(String hashtag) throws Exception;
}
