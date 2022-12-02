/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import commodelo.FachadaModeloNotificacion;
import coninterfaces.IFachadaModeloNotificacion;
import entidades.Notificacion;
import entidades.Usuario;
import eventos.Eventos;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;
import peticiones.PeticionNotificacion;
import peticiones.PeticionNotificaciones;

/**
 *
 * @author tonyd
 */
public class ControladorNotificacion {

    private IFachadaModeloNotificacion fachadaNotificacion;

    public ControladorNotificacion() {
        this.fachadaNotificacion = new FachadaModeloNotificacion();
    }

    public PeticionNotificacion registrarNotificacion(Notificacion notificacion) {
        try {
            Notificacion notificacionRegistrada = fachadaNotificacion.agregarNotificacion(notificacion);
            return new PeticionNotificacion(Eventos.registrarNotificacion, 200, notificacionRegistrada);
        } catch (PersistException pe) {
            return new PeticionNotificacion(Eventos.registrarNotificacion, 503, pe.getMessage());
        }
    }

    public PeticionNotificaciones consultarNotificacionesPorRemitente(Usuario remitente) {
        try {
            List<Notificacion> notificacionesEncontradas = fachadaNotificacion.consultarNotificacionesPorRemitente(remitente);
            return new PeticionNotificaciones(Eventos.consultarNotificacionesPorRemitente, 200, notificacionesEncontradas);
        } catch (NotFoundException ex) {
            return new PeticionNotificaciones(Eventos.consultarNotificacionesPorRemitente, 404, ex.getMessage());
        }
    }

}
