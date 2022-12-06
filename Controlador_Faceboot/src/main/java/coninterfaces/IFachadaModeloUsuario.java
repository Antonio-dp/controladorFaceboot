/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coninterfaces;

import entidades.Usuario;
import excepciones.FacebootException;
import excepciones.PersistException;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IFachadaModeloUsuario {
    /**
     * Metodo agregar usuario que comunica con en modelo para registrar el usuario
     * @param usuario recibido para registrar
     * @return regresa el usuario registrado
     * @throws PersistException Excepcion que puede ocurrir al momento de guardar
     * @throws FacebootException Excepcion que puede ocurrir al momento de validaciones de negocio
     */
    public Usuario agregarUsuario(Usuario usuario) throws PersistException, FacebootException;
    
    /**
     * Metodo que se encarga de iniciar sesion de un usuario recibido
     * @param usuario recibido a iniciar sesión
     * @return el usuario una vez confirmado con sus credenciales
     */
    public Usuario iniciarSesion(Usuario usuario);
    
    /**
     * Metodo que se encarga de iniciar sesion con facebook de un usuario recibido
     * @param usuario recibido a iniciar sesión
     * @return el usuario una vez confirmado con sus credenciales con facebook
     */
    public Usuario iniciarSesionFacebook(Usuario usuario);
    
    /**
     * Método que se encarga de editar el perfil del usuario seleccionado
     * @param usuario a editar con los respectivos campos
     * @return usuario con los datos modificados
     */
    public Usuario editarPerfil(Usuario usuario);
    
    /**
     * Método que se encarga de consultar un usuario por id
     * @param idUsuario del usuario a consultar
     * @return usuario consultado
     */
    public Usuario consultarUsuario(Integer idUsuario);
    
    /**
     * Método que se encarga de consultar un usuario por su nombre
     * @param nombre del usuario a consultar
     * @return usuario consultar
     */
    public Usuario consultarUsuarioPorNombre(String nombre);
}
