/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloNotificacion;
import entidades.Notificacion;
import entidades.Usuario;
import excepciones.NotFoundException;
import excepciones.PersistException;
import interfaces.IModeloNotificacion;
import java.util.List;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FachadaModeloNotificacion implements IFachadaModeloNotificacion{

    /**
     * Instancia de IModeloNotificacion
     */
    private IModeloNotificacion modeloNotificacion;

    /**
     * Constructor que inicializa la instancia del modelo
     */
    public FachadaModeloNotificacion() {
        this.modeloNotificacion = ModelosFactory.crearModeloNotificacion();
    }
    
    /**
     * Método que se encarga de agregar una notificación
     * @param notificacion a agregar
     * @return Notificación agregada
     * @throws PersistException Excepción que puede ocurrir al agregar
     */
    @Override
    public Notificacion agregarNotificacion(Notificacion notificacion) throws PersistException{
        return modeloNotificacion.registrar(notificacion);
    }

    /**
     * Método que se encarga de consultar las notificaciones por remitente
     * @param remitente usuario a consultar
     * @return Lista de notificaciones consultadas
     * @throws NotFoundException Excepción que puede ocurrir al consultar
     */
    @Override
    public List<Notificacion> consultarNotificacionesPorRemitente(Usuario remitente) throws NotFoundException{
        return modeloNotificacion.consultarNotificacionesPorRemitente(remitente);
    }
    
}
