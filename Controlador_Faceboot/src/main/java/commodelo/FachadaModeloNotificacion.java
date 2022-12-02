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
 * @author tonyd
 */
public class FachadaModeloNotificacion implements IFachadaModeloNotificacion{

    private IModeloNotificacion modeloNotificacion;

    public FachadaModeloNotificacion() {
        this.modeloNotificacion = ModelosFactory.crearModeloNotificacion();
    }
    
    @Override
    public Notificacion agregarNotificacion(Notificacion notificacion) throws PersistException{
        return modeloNotificacion.registrar(notificacion);
    }

    @Override
    public List<Notificacion> consultarNotificacionesPorRemitente(Usuario remitente) throws NotFoundException{
        return modeloNotificacion.consultarNotificacionesPorRemitente(remitente);
    }
    
}
