package usuarios.test;

import usuarios.dto.UsuarioDTO;
import usuarios.jdbc.UsuarioDao;
import usuarios.jdbc.UsuarioDaoJDBC;

import java.sql.SQLException;
import java.util.List;

public class TestUsuarios {
    public static void main(String[] args) {

        UsuarioDao usuarioDao = new UsuarioDaoJDBC();

        List<UsuarioDTO> usuarios=null;

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario("Revelos");
        usuarioDTO.setPassword("123456");
        usuarioDTO.setEmail("cristianrevelo98@gmail.com");

        try {
            //usuarioDao.insert(usuarioDTO);

            usuarioDao.delete(new UsuarioDTO(10));
            usuarios=usuarioDao.select();
            for (UsuarioDTO usuario :
                    usuarios) {
                System.out.println(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
