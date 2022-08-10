package personas.test;

import personas.dto.PersonaDTO;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDaoJDBC();



        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Mario");
        persona.setApellido("Rivera");

        try {
            personaDao.insert(persona);

           personaDao.delete(new PersonaDTO(2));

            /*PersonaDTO personaImp = new PersonaDTO();
            personaImp.setId_persona(2);
            personaImp.setNombre("Mario");
            personaImp.setApellido("Lovato");
            personaDao.update(personaImp);*/

            List<PersonaDTO> personas = personaDao.select();
            for (PersonaDTO personaDTO:
                 personas) {
                System.out.print(personaDTO);
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println("Excepciones en la capa de prueba");
            e.printStackTrace();
        }
    }
}
