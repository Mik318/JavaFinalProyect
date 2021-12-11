package test;

import datos.UsuarioJDBC;
import domain.Usuario;
import java.util.List;

public class ManejoUsuarios {

    public static void main(String[] args) {
        UsuarioJDBC usuarioJdbc = new UsuarioJDBC();

        //Ejecutando listado usuarios
//        Usuario usuarioi = new Usuario("aisa", "123");
//        usuarioJdbc.insertar(usuarioi);

        //Modificar
        Usuario usuarioModificar = new Usuario(4, "Juan Carlos", "234");
        usuarioJdbc.actualizar(usuarioModificar);
        //Listado usuarios
        List<Usuario> usuario = usuarioJdbc.seleccionar();
        for (Usuario usuarios : usuario) {
            System.out.println("Usuario:" + usuario);
        }
    }
}
