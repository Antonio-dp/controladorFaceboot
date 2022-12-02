/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import commodelo.FachadaModeloPublicacion;
import coninterfaces.IFachadaModeloPublicacion;
import entidades.Publicacion;
import eventos.Eventos;
import excepciones.NotFoundException;
import excepciones.PersistException;
import java.util.List;
import peticiones.PeticionPublicacion;
import peticiones.PeticionPublicaciones;

/**
 *
 * @author tonyd
 */
public class ControladorPublicacion {

    private IFachadaModeloPublicacion fachadaPublicacion;

    public ControladorPublicacion() {
        this.fachadaPublicacion = new FachadaModeloPublicacion();
    }

    public PeticionPublicacion registrarPublicacion(Publicacion publicacion) {
        try {
            Publicacion publicacionRegistrada = fachadaPublicacion.agregarPublicacion(publicacion);
            return new PeticionPublicacion(Eventos.registrarPublicacion, 200, publicacionRegistrada);
        } catch (PersistException pe) {
            return new PeticionPublicacion(Eventos.registrarPublicacion, 503, pe.getMessage());
        }

    }

    public PeticionPublicaciones consultarPublicaciones() {
        try {
            List<Publicacion> publicaciones = fachadaPublicacion.consultarPublicaciones();
            return new PeticionPublicaciones(Eventos.consultarPublicaciones, 200, publicaciones);
        } catch (NotFoundException nfe) {
            return new PeticionPublicaciones(Eventos.consultarPublicaciones, 404, nfe.getMessage());
        }
    }

    public PeticionPublicacion eliminarPublicacion(Publicacion publicacion) {
        try {
            Publicacion publicacionEliminada = fachadaPublicacion.eliminarPublicacion(publicacion);
            return new PeticionPublicacion(Eventos.eliminarPublicacion, 200, publicacionEliminada);
        } catch (PersistException pe) {
            return new PeticionPublicacion(Eventos.eliminarPublicacion, 503, pe.getMessage());
        }
    }

    public PeticionPublicaciones consultarPublicacionesPorEtiqueta(String hashtag) {
        try {
            List<Publicacion> publicacionesEncontradas = this.fachadaPublicacion.consultarPublicacionesPorEtiqueta(hashtag);
            return new PeticionPublicaciones(Eventos.consultarPublicacionesPorHashtag, 200, publicacionesEncontradas);
        } catch (Exception ex) {
            return new PeticionPublicaciones(Eventos.consultarPublicacionesPorHashtag, 400, ex.getMessage());
        }
    }
}
