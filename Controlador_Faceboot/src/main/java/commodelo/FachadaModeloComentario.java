/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloComentario;
import entidades.Comentario;
import excepciones.PersistException;
import interfaces.IModeloComentario;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class FachadaModeloComentario implements IFachadaModeloComentario{
    private IModeloComentario modeloComentario;
    public FachadaModeloComentario() {
        this.modeloComentario = ModelosFactory.crearModeloComentario();
    }
    @Override
    public Comentario agregarComentario(Comentario comentario) throws PersistException {
        return modeloComentario.registrar(comentario);
    }

    @Override
    public List<Comentario> consultarComentarios(Integer idPublicacion) throws PersistException {
        return modeloComentario.consultarComentarios(idPublicacion);
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) throws PersistException {
        return modeloComentario.eliminar(comentario);
    }
    
}
