/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import coninterfaces.IFachadaModeloHashtag;
import entidades.Hashtag;
import excepciones.NotFoundException;
import excepciones.PersistException;
import interfaces.IModeloHashtag;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class FachadaModeloHashtag implements IFachadaModeloHashtag{

    /**
     * Instancia de IModeloHashtag
     */
    private IModeloHashtag modeloHashtag;
    
    /**
     * constructor de la clase que inicializa la instancia
     */
    public FachadaModeloHashtag(){
        this.modeloHashtag = ModelosFactory.crearModeloHashtag();
    }
    
    /**
     * Método que se encarga de agregar un hashtag
     * @param hashtag a agregar
     * @return Hashtag agregado
     * @throws PersistException Excepción qie puede ocurrir al agregar el hashtag
     */
    @Override
    public Hashtag agregarHashtag(Hashtag hashtag) throws PersistException{
        return modeloHashtag.registrar(hashtag);
    }

    /**
     * Método que se encarga de agregar una lista de hashtag
     * @param hashtags lista de hashtag a agregar
     * @return lista de hashtag agregada
     * @throws PersistException Excepción que puede ocurrir al agregar
     */
    @Override
    public List<Hashtag> agregarHashtags(List<Hashtag> hashtags) throws PersistException{
        return modeloHashtag.registrarHashtags(hashtags);
    }

    /**
     * Método que se encarga de consultar un hashtag por id
     * @param idHashtag a consultar
     * @return Hashtag consultado
     * @throws NotFoundException Excepción que puede ocurrir al consultar
     */
    @Override
    public Hashtag consultarHashtag(Integer idHashtag) throws NotFoundException{
        return modeloHashtag.consultar(idHashtag);
    }

    /**
     * Método que se encarga de eliminar un hashtag por id
     * @param idHashtag del hashtag a eliminar
     * @return hashtag eliminado
     * @throws PersistException Excepión que puede ocurrir al eliminar
     */
    @Override
    public Hashtag eliminarHashtag(Integer idHashtag) throws PersistException{
        return modeloHashtag.eliminar(idHashtag);
    }

    /**
     * Método que se encarga de consultar un hashtag por tema
     * @param tema a consultar
     * @return hashtag consultado
     * @throws Exception Exepción que puede ourrir al consultar
     */
    @Override
    public Hashtag consultarPorTema(String tema) throws Exception {
        return modeloHashtag.consultarPorTema(tema);
    }

}
