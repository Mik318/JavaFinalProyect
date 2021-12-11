package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {
    
    public static void main(String[] args) {
//        PersonaJDBC personaDao = new PersonaJDBC();
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaJDBC personaJdbc = new PersonaJDBC(conexion);
            Persona personaModificar = new Persona();
            personaModificar.setIdPersona(4);
            personaModificar.setNombre("Juan kkk");
            personaModificar.setApellido("Ezparza");
            personaModificar.setEmail("loki@mail.com");
            personaModificar.setTelefono("92841945");
            personaJdbc.actualizar(personaModificar);
            
//            Persona nuevaPersona = new Persona();
//            nuevaPersona.setNombre("Gama");
////            nuevaPersona.setApellido("Garcia11111111111111111111111111111111111111111111111111111111111111111111111111111111");
//            nuevaPersona.setApellido("Garcia");
//            personaJdbc.insertar(nuevaPersona);
            
            conexion.commit();
            System.out.println("exitoso");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("entramos el rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

//        Insertando un nuevo objeto de tipo Persona
//        Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "554456587");
//        personaDao.insertar(personaNueva);
        //Modificar un objeto de persona existente
//        Persona personaModificar = new Persona(4, "Juan Carlos", "Esparza", "jcesparza@mail.com", "554456587");
//        personaDao.actualizar(personaModificar);
        //Eliminar un registro
//        Persona personaEliminar = new Persona(1);
//        personaDao.eliminar(personaEliminar);
//        
//        //Listado Persona
//        List<Persona> personas = personaDao.seleccionar();
//
//        personas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
    }
}
