/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Soporte
 */
 public class Habitacion
 {
    private String id_habitacion;
    private String id_tipohabitacion;
    private String id_tipocama;
    private String precio;
    private String estatus_habitacion; 
    

    public Habitacion() {
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "id_habitacion=" + id_habitacion + ", id_tipohabitacion=" + id_tipohabitacion + ", id_tipocama=" + id_tipocama + ", precio=" + precio + ", estatus_habitacion=" + estatus_habitacion + '}';
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getId_tipohabitacion() {
        return id_tipohabitacion;
    }

    public void setId_tipohabitacion(String id_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
    }

    public String getId_tipocama() {
        return id_tipocama;
    }

    public void setId_tipocama(String id_tipocama) {
        this.id_tipocama= id_tipocama;
    }
    
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public String getEstatus_habitacion() {
        return estatus_habitacion;
    }

    public void setEstatus_habitacion(String estatus_habitacion) {
        this.estatus_habitacion = estatus_habitacion;
    }

    public Habitacion(String id_habitacion, String id_tipohabitacion, String id_tipocama) {
        this.id_habitacion = id_habitacion;
        this.id_tipohabitacion = id_tipohabitacion;
        this.id_tipocama = id_tipocama;
    }

    public Habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Habitacion(String id_habitacion, String id_tipohabitacion, String id_tipocama, String precio, String estatus_habitacion) {
        this.id_habitacion = id_habitacion;
        this.id_tipohabitacion = id_tipohabitacion;
        this.id_tipocama = id_tipocama;
        this.precio = precio;
        this.estatus_habitacion = estatus_habitacion;
    }
 }