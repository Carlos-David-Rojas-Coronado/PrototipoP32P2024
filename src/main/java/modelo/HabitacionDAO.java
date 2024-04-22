/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Habitacion;
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
public class HabitacionDAO {

    private static final String SQL_SELECT = "SELECT id_habitacion, id_tipohabitacion, id_tipocama, precio, estatus_habitaicon FROM habitacion";
    private static final String SQL_INSERT = "INSERT INTO habitacion(id_habitacion, id_tipohabitacion, id_tipocama, pecion,estatus_habitacion) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE habitacion SET id_tipohabitacion=?, id_tipocama=?, precio,estatus_habtiacion=? WHERE id_habitacion = ?";
    private static final String SQL_DELETE = "DELETE FROM habitacion WHERE id_habitacion=?";
    private static final String SQL_QUERY = "SELECT id_habitacion, id_tipohabitaion, idtipocama, precio,estatus_curso FROM habtiacion WHERE id_habitacion = ?";

    public List<Habitacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Habitacion habitacion = null;
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idhabitacion = rs.getString("id_habitacion");
                String tipohabitacion = rs.getString("id_tipohabitacion");
                String tipocama =rs.getString("id_tipocama");
                String precio = rs.getString("precio");
                String estatus = rs.getString("estatus_habitacion");
                
                habitacion = new Habitacion();
                habitacion.setId_habitacion(idhabitacion);
                habitacion.setId_tipohabitacion(tipohabitacion);
                habitacion.setId_tipocama(tipocama);
                habitacion.setPrecio(precio);
                habitacion.setEstatus_habitacion(estatus);
                
                habitaciones.add(habitacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return habitaciones;
    }

    public int insert(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, habitacion.getId_habitacion());
            stmt.setString(2, habitacion.getId_tipohabitacion());
            stmt.setString(3, habitacion.getId_tipocama());
            stmt.setString(4, habitacion.getPrecio());
            stmt.setString(5, habitacion.getEstatus_habitacion());
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

    public int update(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, habitacion.getId_habitacion());
            stmt.setString(2, habitacion.getId_tipohabitacion());
            stmt.setString(3, habitacion.getId_tipocama());
            stmt.setString(4, habitacion.getPrecio());
            stmt.setString(5, habitacion.getEstatus_habitacion());

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

    public int delete(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, habitacion.getId_habitacion());
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
    public Habitacion query(Habitacion habitacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, habitacion.getId_habitacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                 String idhabitacion = rs.getString("id_habitacion");
                String tipohabitacion = rs.getString("id_tipohabitacion");
                String tipocama =rs.getString("id_tipocama");
                String precio = rs.getString("precio");
                String estatus = rs.getString("estatus_habitacion");
                
                habitacion = new Habitacion();
                habitacion.setId_habitacion(idhabitacion);
                habitacion.setId_tipohabitacion(tipohabitacion);
                habitacion.setId_tipocama(tipocama);
                habitacion.setPrecio(precio);
                habitacion.setEstatus_habitacion(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return habitacion;
    }
        
}
