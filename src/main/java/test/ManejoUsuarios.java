package test;

import java.sql.*;
import datos.Conexion;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.util.List;

public class ManejoUsuarios {

    public static void main(String[] args) {
//        UsuarioDaoJDBC usuarioJdbc = new UsuarioDaoJDBC();
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            UsuarioDaoJDBC usurioJDBC = new UsuarioDaoJDBC();
            List<UsuarioDTO> usuarios = usurioJDBC.seleccionar();
            for (UsuarioDTO usuario : usuarios) {
                System.out.println("Usuario: " + usuario);
            }
            UsuarioDTO nuevoUsuario = new UsuarioDTO();
            nuevoUsuario.setUsername("Gama");
//            nuevoUsuario.setApellido("Garcia11111111111111111111111111111111111111111111111111111111111111111111111111111111");
            nuevoUsuario.setPassword("Garcia123");
            usurioJDBC.insertar(nuevoUsuario);
            conexion.commit();
            System.out.println("Operacion exitosa");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Entramos en rollback");
            try {
                conexion.rollback();

            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        //Ejecutando listado usuarios
//        UsuarioDTO usuarioi = new UsuarioDTO("aisa", "123");
//        usuarioJdbc.insertar(usuarioi);

//        //Modificar
//        UsuarioDTO usuarioModificar = new UsuarioDTO(4, "Juan Carlos", "234");
//        usuarioJdbc.actualizar(usuarioModificar);
//        //Listado usuarios
//        List<Usuario> usuario = usuarioJdbc.seleccionar();
//        for (UsuarioDTO usuarios : usuario) {
//            System.out.println("UsuarioDTO:" + usuario);
//       }
    }
}
