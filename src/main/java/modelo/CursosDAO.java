/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author visitante
 */
public class CursosDAO {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(codigo_curso, nombre_curso, estatus_curso) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso=?";
    private static final String SQL_QUERY = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE codigo_curso = ?";

    public List<Cursos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cursos curso = null;
        List<Cursos> cursos = new ArrayList<Cursos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_curso");
                String nombre = rs.getString("nombre_curso");
                String estatus = rs.getString("estatus_curso");
                
                curso = new Cursos();
                curso.setCodigo_curso(codigo);
                curso.setNombre_curso(nombre);
                curso.setEstatus_curso(estatus);
                
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cursos;
    }

    public int insert(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getCodigo_curso());
            stmt.setString(2, curso.getNombre_curso());
            stmt.setString(3, curso.getEstatus_curso());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getEstatus_curso());
            stmt.setString(3, curso.getCodigo_curso());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, curso.getCodigo_curso());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Cursos query(Cursos curso) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, curso.getCodigo_curso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_curso");
                String nombre = rs.getString("nombre_curso");
                String estatus = rs.getString("estatus_curso");
                
                curso = new Cursos();
                curso.setCodigo_curso(codigo);
                curso.setNombre_curso(nombre);
                curso.setEstatus_curso(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return curso;
    }
        
}
