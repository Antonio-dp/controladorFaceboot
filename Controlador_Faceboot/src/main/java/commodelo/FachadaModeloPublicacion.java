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
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FachadaModeloPublicacion implements IFachadaModeloPublicacion{
    
    /**
     * Instancia de IModeloPublicacion
     */
    private IModeloPublicacion modeloPublicacion;
    
    /**
     * Constructor que inicializa el modeloPublicacion
     */
    public FachadaModeloPublicacion() {
        this.modeloPublicacion = ModelosFactory.crearModeloPublicacion();
    }
    
    /**
     * Método que se encarga de agregar una publicación
     * @param publicacion a registrar
     * @return la publicación agregada
     * @throws PersistException Excepción que puede ocurrir al momento de
     * persistir
     */
    @Override
    public Publicacion agregarPublicacion(Publicacion publicacion) throws PersistException {
        return modeloPublicacion.registrar(publicacion);
    }

    /**
     * Método que consulta todas las publicaciones
     * @return Lista de publicaciones
     * @throws NotFoundException Excepción que puede ocurrir cuando no se
     * encuentran las publicaciones
     */
    @Override
    public List<Publicacion> consultarPublicaciones() throws NotFoundException{
        return this.modeloPublicacion.consultarPublicaciones();
    }

    /**
     * Método que se encarga de eliminar una publicacion
     * @param publicacion a eliminar
     * @return la publicacíon eliminada
     * @throws PersistException Excepción que puede ocurrir al momento de
     * eliminar
     */
    @Override
    public Publicacion eliminarPublicacion(Publicacion publicacion) throws PersistException {
        return modeloPublicacion.eliminar(publicacion.getId());
    }

    /**
     * Método que se encarga de consultar una lista de publicaciones por su hashtag
     * @param hashtag a buscar
     * @return Lista de publicaciones que coinciden con el hashtag
     * @throws Exception que puede lanzar al consultar las publicaciones por hashtag
     */
    @Override
    public List<Publicacion> consultarPublicacionesPorEtiqueta(String hashtag) throws Exception {
        return modeloPublicacion.consultarPublicacionesPorEtiqueta(hashtag);
    }
    
}
