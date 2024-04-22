/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Alumnos;
import modelo.Conexion;
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
 * @author cdavi
 */
public class AlumnosDAO {
     private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alummno, estatus_alummno FROM alumnos WHERE nombre_alumno = ?";

    public List<Alumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumnos alumno = null;
        List<Alumnos> alumnos = new ArrayList<Alumnos>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet_alumno = rs.getString("carnet_alummno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion_alumno");
                String telefono_alumno = rs.getString("telefono_alummno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");

                alumno = new Alumnos();
                alumno.setCarnet_alumno(carnet_alumno);
                alumno.setNombre_alumno(nombre_alumno);
                alumno.setDireccion_alumno(direccion_alumno);
                alumno.setTelefono_alumno(telefono_alumno);
                alumno.setEmail_alumno(email_alumno);
                alumno.setEstatus_alumno(estatus_alumno);

                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alumnos;
    }

    public int insert(Alumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumnos.getCarnet_alumno());
            stmt.setString(2, alumnos.getNombre_alumno());
            stmt.setString(3, alumnos.getDireccion_alumno());
            stmt.setString(4, alumnos.getTelefono_alumno());
            stmt.setString(5, alumnos.getEmail_alumno());
            stmt.setString(6, alumnos.getEstatus_alumno());

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

    public int update(Alumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,alumnos.getCarnet_alumno());
            stmt.setString(2, alumnos.getNombre_alumno());
            stmt.setString(3, alumnos.getDireccion_alumno());
            stmt.setString(4, alumnos.getTelefono_alumno());
            stmt.setString(5, alumnos.getEmail_alumno());
            stmt.setString(6, alumnos.getEstatus_alumno());
    
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

    public int delete(Alumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, alumno.getCarnet_alumno());
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

    public Alumnos query(Alumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, alumno.getNombre_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet_alumno = rs.getString("carnet_alumno");
                String nombre_alumno = rs.getString("nombre_alumno");
                String direccion_alumno = rs.getString("direccion__alumno");
                String telefono_alumno = rs.getString("telefono_alumno");
                String email_alumno = rs.getString("email_alumno");
                String estatus_alumno = rs.getString("estatus_alumno");

                alumno = new Alumnos();
                alumno.setCarnet_alumno(carnet_alumno);
                alumno.setNombre_alumno(nombre_alumno);
                alumno.setDireccion_alumno(direccion_alumno);
                alumno.setTelefono_alumno(telefono_alumno);
                alumno.setEmail_alumno(email_alumno);
                alumno.setEstatus_alumno(estatus_alumno);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return alumno;
    }
}

