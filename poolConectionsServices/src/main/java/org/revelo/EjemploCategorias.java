package org.revelo;

import org.revelo.jdbc.ConexionBaseDatos;
import org.revelo.modelo.Categoria;
import org.revelo.repositorio.CategoriaRepositorioImpl;
import org.revelo.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploCategorias {
    public static void main(String[] args) {

        try(Connection conn = ConexionBaseDatos.getConnection()){
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            Repositorio<Categoria> repositorio = new CategoriaRepositorioImpl(conn);

        }catch (SQLException e){

            e.printStackTrace();
        }
    }
}
