/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloHashtag;
import entidades.Hashtag;
import entidades.Publicacion;
import excepciones.NotFoundException;
import excepciones.PersistException;
import interfaces.IModeloHashtag;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class FachadaModeloHashtag implements IFachadaModeloHashtag{

    private IModeloHashtag modeloHashtag;
    
    public FachadaModeloHashtag(){
        this.modeloHashtag = ModelosFactory.crearModeloHashtag();
    }
    
    @Override
    public Hashtag agregarHashtag(Hashtag hashtag) throws PersistException{
        return modeloHashtag.registrar(hashtag);
    }

    @Override
    public List<Hashtag> agregarHashtags(List<Hashtag> hashtags) throws PersistException{
        return modeloHashtag.registrarHashtags(hashtags);
    }

    @Override
    public Hashtag consultarHashtag(Integer idHashtag) throws NotFoundException{
        return modeloHashtag.consultar(idHashtag);
    }

    @Override
    public Hashtag eliminarHashtag(Integer idHashtag) throws PersistException{
        return modeloHashtag.eliminar(idHashtag);
    }

    @Override
    public Hashtag consultarPorTema(String tema) throws Exception {
        return modeloHashtag.consultarPorTema(tema);
    }

}
