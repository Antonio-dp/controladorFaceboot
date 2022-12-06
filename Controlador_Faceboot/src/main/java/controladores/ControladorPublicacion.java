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
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ControladorPublicacion {

    /**
     * Instancia de IFachadaModeloPublicacion
     */
    private IFachadaModeloPublicacion fachadaPublicacion;

    /**
     * Contructor que inicializa la instancia de la clase
     */
    public ControladorPublicacion() {
        this.fachadaPublicacion = new FachadaModeloPublicacion();
    }

    /**
     * Método que registra publicación
     * @param publicacion a registrar
     * @return PeticionPublicacion que registra lo sucedido.
     */
    public PeticionPublicacion registrarPublicacion(Publicacion publicacion) {
        try {
            Publicacion publicacionRegistrada = fachadaPublicacion.agregarPublicacion(publicacion);
            return new PeticionPublicacion(Eventos.registrarPublicacion, 200, publicacionRegistrada);
        } catch (PersistException pe) {
            return new PeticionPublicacion(Eventos.registrarPublicacion, 503, pe.getMessage());
        }

    }

    /**
     * Método para consultarPublicaciones
     * @return PeticionPublicacion con el resultado de la consulta
     */
    public PeticionPublicaciones consultarPublicaciones() {
        try {
            List<Publicacion> publicaciones = fachadaPublicacion.consultarPublicaciones();
            return new PeticionPublicaciones(Eventos.consultarPublicaciones, 200, publicaciones);
        } catch (NotFoundException nfe) {
            return new PeticionPublicaciones(Eventos.consultarPublicaciones, 404, nfe.getMessage());
        }
    }

    /**
     * Método que elimina la publicación
     * @param publicacion a eliminar
     * @return PeticionPublicacion con el resultado de la eliminación
     */
    public PeticionPublicacion eliminarPublicacion(Publicacion publicacion) {
        try {
            Publicacion publicacionEliminada = fachadaPublicacion.eliminarPublicacion(publicacion);
            return new PeticionPublicacion(Eventos.eliminarPublicacion, 200, publicacionEliminada);
        } catch (PersistException pe) {
            return new PeticionPublicacion(Eventos.eliminarPublicacion, 503, pe.getMessage());
        }
    }

    /**
     * Método que se encarga de consultar publicaciones por etiqueta
     * @param hashtag etiqueta a buscar
     * @return PeticionPublicacion con el resultado de la consulta
     */
    public PeticionPublicaciones consultarPublicacionesPorEtiqueta(String hashtag) {
        try {
            List<Publicacion> publicacionesEncontradas = this.fachadaPublicacion.consultarPublicacionesPorEtiqueta(hashtag);
            return new PeticionPublicaciones(Eventos.consultarPublicacionesPorHashtag, 200, publicacionesEncontradas);
        } catch (Exception ex) {
            return new PeticionPublicaciones(Eventos.consultarPublicacionesPorHashtag, 400, ex.getMessage());
        }
    }
}
