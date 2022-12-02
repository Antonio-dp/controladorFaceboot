/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloPublicacion;
import entidades.Publicacion;
import excepciones.NotFoundException;
import excepciones.PersistException;
import interfaces.IModeloPublicacion;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class FachadaModeloPublicacion implements IFachadaModeloPublicacion{
    private IModeloPublicacion modeloPublicacion;
    public FachadaModeloPublicacion() {
        this.modeloPublicacion = ModelosFactory.crearModeloPublicacion();
    }
    
    @Override
    public Publicacion agregarPublicacion(Publicacion publicacion) throws PersistException {
        return modeloPublicacion.registrar(publicacion);
    }

    @Override
    public List<Publicacion> consultarPublicaciones() throws NotFoundException{
        return this.modeloPublicacion.consultarPublicaciones();
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion publicacion) throws PersistException {
        return modeloPublicacion.eliminar(publicacion.getId());
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorEtiqueta(String hashtag) throws Exception {
        return modeloPublicacion.consultarPublicacionesPorEtiqueta(hashtag);
    }
    
}
