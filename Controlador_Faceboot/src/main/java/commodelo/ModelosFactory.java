/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commodelo;

import interfaces.IConexionBD;
import conexiones.ConexionBD;
import modelos.ModeloComentario;
import modelos.ModeloHashtag;
import modelos.ModeloNotificacion;
import modelos.ModeloPublicacion;
import modelos.ModeloUsuario;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ModelosFactory {

    /**
     * Conexion
     */
    private static final IConexionBD conexionBD = ConexionBD.getInstance();

    /**
     * Se encarga de generar la conexion con el modelo de usuario
     * @return instancia de ModeloUsuario
     */
    public static ModeloUsuario crearModeloUsuario() {
        return new ModeloUsuario(conexionBD);
    }

    /**
     * Se encarga de generar la conexion con el modelo de publicacion
     * @return instancia de ModeloPublicacion
     */
    public static ModeloPublicacion crearModeloPublicacion() {
        return new ModeloPublicacion(conexionBD);
    }

    /**
     * Se encarga de generar la conexion con el modelo de comentario
     * @return instancia de ModeloComentario
     */
    public static ModeloComentario crearModeloComentario() {
        return new ModeloComentario(conexionBD);
    }

    /**
     * Se encarga de generar la conexion con el modelo de Notificación
     * @return instancia de ModeloNotificacion
     */
    public static ModeloNotificacion crearModeloNotificacion() {
        return new ModeloNotificacion(conexionBD);
    }

    /**
     * Se encarga de generar la conexion con el modelo de hashtag
     * @return instancia de ModeloHashtag
     */
    public static ModeloHashtag crearModeloHashtag() {
        return new ModeloHashtag(conexionBD);
    }

}
