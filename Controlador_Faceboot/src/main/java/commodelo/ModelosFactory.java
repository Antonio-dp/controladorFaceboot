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
 * @author jegav
 */
public class ModelosFactory {

    private static final IConexionBD conexionBD = ConexionBD.getInstance();

    public static ModeloUsuario crearModeloUsuario() {
        return new ModeloUsuario(conexionBD);
    }

    public static ModeloPublicacion crearModeloPublicacion() {
        return new ModeloPublicacion(conexionBD);
    }

    public static ModeloComentario crearModeloComentario() {
        return new ModeloComentario(conexionBD);
    }

    public static ModeloNotificacion crearModeloNotificacion() {
        return new ModeloNotificacion(conexionBD);
    }

    public static ModeloHashtag crearModeloHashtag() {
        return new ModeloHashtag(conexionBD);
    }

}
