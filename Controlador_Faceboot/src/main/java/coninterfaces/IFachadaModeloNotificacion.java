/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package coninterfaces;

import entidades.Notificacion;
import entidades.Usuario;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;

/**
 *
 * @author tonyd
 */
public interface IFachadaModeloNotificacion {
    public Notificacion agregarNotificacion(Notificacion notificacion) throws PersistException;
    public List<Notificacion> consultarNotificacionesPorRemitente(Usuario remitente)throws NotFoundException;
}
