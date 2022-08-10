package personas.jdbc;

import personas.dto.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {
    int insert(PersonaDTO persona) throws SQLException;

    int update(PersonaDTO persona) throws SQLException;

    int delete(PersonaDTO persona) throws SQLException;

    List<PersonaDTO> select() throws SQLException;

}
