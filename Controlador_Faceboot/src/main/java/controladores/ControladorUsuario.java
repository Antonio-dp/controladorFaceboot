/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import commodelo.FachadaModeloUsuario;
import coninterfaces.IFachadaModeloUsuario;
import entidades.Usuario;
import eventos.Eventos;
import excepciones.FacebootException;
import excepciones.PersistException;
import peticiones.PeticionUsuario;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ControladorUsuario {
    
    /**
     * Instancia de IFachadaModeloUsuario
     */
    private IFachadaModeloUsuario fachadaUsuario;

    /**
     * Constructor que inicializa la instancia de la clase
     */
    public ControladorUsuario() {
        this.fachadaUsuario = new FachadaModeloUsuario();
    }
    
    /**
     * Método registra usuario por medio de un usuario
     * @param usuario a registrar
     * @return PeticionUsuario con el resultado de esto
     */
    public PeticionUsuario registrarUsuario(Usuario usuario){
        try{
            Usuario usuarioRegistrado = fachadaUsuario.agregarUsuario(usuario);
            return new PeticionUsuario(Eventos.registrarUsuario, 200, usuarioRegistrado);
        } catch(PersistException pe){
            return new PeticionUsuario(Eventos.registrarUsuario, 503, pe.getMessage());
        } catch(FacebootException fe){
            return new PeticionUsuario(Eventos.registrarUsuario, 406, fe.getMessage());
        } 
    }
    
    /**
     * Método que se encarga de iniciar sesión por facebook
     * @param usuario a comparar credenciales he iniciar sesión
     * @return PeticionUsuario con el resultado de la acción
     */
    public PeticionUsuario IniciarSesionFacebook(Usuario usuario){
        Usuario usuarioEncontrado = fachadaUsuario.iniciarSesionFacebook(usuario);
        if(usuarioEncontrado == null){
            return new PeticionUsuario(Eventos.Login, 404, "No se encontró el usuario");
        }
        return new PeticionUsuario(Eventos.Login, 200, usuarioEncontrado);
    }
    
    /**
     * Método que se encarga de iniciar sesión
     * @param usuario a comparar credenciales he iniciar sesión
     * @return PeticionUsuario con el resultado de la acción
     */
    public PeticionUsuario IniciarSesion(Usuario usuario){
        Usuario usuarioEncontrado = fachadaUsuario.iniciarSesion(usuario);
        if(usuarioEncontrado == null){
            return new PeticionUsuario(Eventos.Login, 404, "No se encontró el usuario");
        }
        return new PeticionUsuario(Eventos.Login, 200, usuarioEncontrado);
    }
    
    /**
     * Método que se encarga de editar el perfil de un usuario
     * @param usuario a editar perfil
     * @return usuario con perfil editado
     */
    public Usuario editarPerfil(Usuario usuario){
        return fachadaUsuario.editarPerfil(usuario);
    }
   
    /**
     * Método que se encarga de consultar un usuario por ID
     * @param idUsuario a consultar
     * @return PeticionUsuario consultado
     */
    public PeticionUsuario consultarUsuarioPorId(Integer idUsuario){
        try{
            Usuario usuarioEncontrado = fachadaUsuario.consultarUsuario(idUsuario);
            return new PeticionUsuario(Eventos.consultarUsuarioPorId, 200, usuarioEncontrado);
        } catch(Exception ex){

        }
        return null;
    }
    
    /**
     * Método que se encarga de consultar un usuario por nombre
     * @param nombre del usuario a consultar
     * @return PeticionUsuario consultado correspondiente
     */
    public PeticionUsuario consultarUsuarioPorNombre(String nombre){
        Usuario usuarioEncontrado = fachadaUsuario.consultarUsuarioPorNombre(nombre);
        return new PeticionUsuario(Eventos.consultarUsuarioPorNombre, 200, usuarioEncontrado);
    }
    

}
