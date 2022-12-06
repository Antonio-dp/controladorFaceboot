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
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IFachadaModeloNotificacion {
    
    /**
     * Método que se encarga de agregar una notificación
     * @param notificacion a agregar
     * @return Notificación agregada
     * @throws PersistException Excepción que puede ocurrir al agregar
     */
    public Notificacion agregarNotificacion(Notificacion notificacion) throws PersistException;
    
    /**
     * Método que se encarga de consultar las notificaciones por remitente
     * @param remitente usuario a consultar
     * @return Lista de notificaciones consultadas
     * @throws NotFoundException Excepción que puede ocurrir al consultar
     */  
    public List<Notificacion> consultarNotificacionesPorRemitente(Usuario remitente)throws NotFoundException;
}
