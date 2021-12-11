package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    
    public static void main(String[] args) {
//        PersonaDaoJDBC personaDao = new PersonaDaoJDBC();
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDao personaDao = new PersonaDaoJDBC(conexion);
            List<PersonaDTO> personas = personaDao.seleccionar();
            for (PersonaDTO persona : personas) {
                System.out.println("Persona DTO: " + persona);
            }
//            PersonaDTO personaModificar = new PersonaDTO();
//            personaModificar.setIdPersona(4);
//            personaModificar.setNombre("Juan kkk");
//            personaModificar.setApellido("Ezparza");
//            personaModificar.setEmail("loki@mail.com");
//            personaModificar.setTelefono("92841945");
//            personaJdbc.actualizar(personaModificar);
            
//            PersonaDTO nuevaPersona = new PersonaDTO();
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

//        Insertando un nuevo objeto de tipo PersonaDTO
//        PersonaDTO personaNueva = new PersonaDTO("Carlos", "Esparza", "cesparza@mail.com", "554456587");
//        personaDao.insertar(personaNueva);
        //Modificar un objeto de persona existente
//        PersonaDTO personaModificar = new PersonaDTO(4, "Juan Carlos", "Esparza", "jcesparza@mail.com", "554456587");
//        personaDao.actualizar(personaModificar);
        //Eliminar un registro
//        PersonaDTO personaEliminar = new PersonaDTO(1);
//        personaDao.eliminar(personaEliminar);
//        
//        //Listado PersonaDTO
//        List<Persona> personas = personaDao.seleccionar();
//
//        personas.forEach(persona -> {
//            System.out.println("persona = " + persona);
//        });
    }
}
