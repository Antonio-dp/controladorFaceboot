package commodelo;

import entidades.Usuario;
import coninterfaces.IFachadaModeloUsuario;
import entidades.Publicacion;
import excepciones.FacebootException;
import excepciones.PersistException;
import interfaces.IModeloUsuario;

/**
 *
 * @author jegav
 */
public class FachadaModeloUsuario implements IFachadaModeloUsuario {

    private IModeloUsuario modeloUsuario;

    public FachadaModeloUsuario() {
        this.modeloUsuario = ModelosFactory.crearModeloUsuario();
    }  
    
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistException, FacebootException {
        return modeloUsuario.registrar(usuario);
    }

    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        return modeloUsuario.login(usuario);
    }
    
    @Override
    public Usuario iniciarSesionFacebook(Usuario usuario) {
        return modeloUsuario.loginFacebook(usuario);
    }

    @Override
    public Usuario editarPerfil(Usuario usuario) {
        return modeloUsuario.actualizar(usuario);
    }

    @Override
    public Usuario eliminarUsuario(Usuario usuario) {
        return modeloUsuario.eliminar(usuario.getId());
    }
    
    @Override
    public Usuario consultarUsuario(Integer idUsuario) {
        return modeloUsuario.consultar(idUsuario);
    }

    @Override
    public Usuario consultarUsuarioPorNombre(String nombre) {
        return modeloUsuario.consultarUsuarioPorNombre(nombre);
    }

}
