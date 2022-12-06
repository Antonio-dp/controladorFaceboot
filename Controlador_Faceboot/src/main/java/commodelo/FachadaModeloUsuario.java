package commodelo;

import entidades.Usuario;
import coninterfaces.IFachadaModeloUsuario;
import excepciones.FacebootException;
import excepciones.PersistException;
import interfaces.IModeloUsuario;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FachadaModeloUsuario implements IFachadaModeloUsuario {

    /**
     * Instancia de IModeloUsuario
     */
    private IModeloUsuario modeloUsuario;

    /**
     * Constructor que inicializa la instancia de modelo Usuario
     */
    public FachadaModeloUsuario() {
        this.modeloUsuario = ModelosFactory.crearModeloUsuario();
    }  
    
    /**
     * Metodo agregar usuario que comunica con en modelo para registrar el usuario
     * @param usuario recibido para registrar
     * @return regresa el usuario registrado
     * @throws PersistException Excepcion que puede ocurrir al momento de guardar
     * @throws FacebootException Excepcion que puede ocurrir al momento de validaciones de negocio
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistException, FacebootException {
        return modeloUsuario.registrar(usuario);
    }

    /**
     * Metodo que se encarga de iniciar sesion de un usuario recibido
     * @param usuario recibido a iniciar sesión
     * @return el usuario una vez confirmado con sus credenciales
     */
    @Override
    public Usuario iniciarSesion(Usuario usuario) {
        return modeloUsuario.login(usuario);
    }
    
    /**
     * Metodo que se encarga de iniciar sesion con facebook de un usuario recibido
     * @param usuario recibido a iniciar sesión
     * @return el usuario una vez confirmado con sus credenciales con facebook
     */
    @Override
    public Usuario iniciarSesionFacebook(Usuario usuario) {
        return modeloUsuario.loginFacebook(usuario);
    }

    /**
     * Método que se encarga de editar el perfil del usuario seleccionado
     * @param usuario a editar con los respectivos campos
     * @return usuario con los datos modificados
     */
    @Override
    public Usuario editarPerfil(Usuario usuario) {
        return modeloUsuario.actualizar(usuario);
    }

    /**
     * Método que se encarga de consultar un usuario por id
     * @param idUsuario del usuario a consultar
     * @return usuario consultado
     */
    @Override
    public Usuario consultarUsuario(Integer idUsuario) {
        return modeloUsuario.consultar(idUsuario);
    }
    
    /**
     * Método que se encarga de consultar un usuario por su nombre
     * @param nombre del usuario a consultar
     * @return usuario consultar
     */
    @Override
    public Usuario consultarUsuarioPorNombre(String nombre) {
        return modeloUsuario.consultarUsuarioPorNombre(nombre);
    }

}
