/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coninterfaces;

import entidades.Publicacion;
import entidades.Usuario;
import excepciones.FacebootException;
import excepciones.PersistException;

/**
 *
 * @author jegav
 */
public interface IFachadaModeloUsuario {
    public Usuario agregarUsuario(Usuario usuario) throws PersistException, FacebootException;
    public Usuario iniciarSesion(Usuario usuario);
    public Usuario iniciarSesionFacebook(Usuario usuario);
    public Usuario editarPerfil(Usuario usuario);
    public Usuario eliminarUsuario(Usuario usuario);
    public Usuario consultarUsuario(Integer idUsuario);
    public Usuario consultarUsuarioPorNombre(String nombre);
}
