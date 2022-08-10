package usuarios.jdbc;

import usuarios.dto.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    int insert(UsuarioDTO persona) throws SQLException;

    int update(UsuarioDTO persona) throws SQLException;

    int delete(UsuarioDTO persona) throws SQLException;

    List<UsuarioDTO> select() throws SQLException;
}
