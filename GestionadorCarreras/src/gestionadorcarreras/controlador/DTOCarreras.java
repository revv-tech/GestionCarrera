/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.TGrado;

/**
 *
 * @author Marco
 */
public class DTOCarreras {
    String codigo;
    String nombre;
    int puntajeAdmision;
    int capacidadMax;
    TGrado grado;
    String codigoSede;
    String nombreSede;

    public DTOCarreras(String codigo, String nombre, int puntajeAdmision, int capacidadMax, TGrado grado, String codigoSede, String nombreSede) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntajeAdmision = puntajeAdmision;
        this.capacidadMax = capacidadMax;
        this.grado = grado;
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntajeAdmision() {
        return puntajeAdmision;
    }

    public void setPuntajeAdmision(int puntajeAdmision) {
        this.puntajeAdmision = puntajeAdmision;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public TGrado getGrado() {
        return grado;
    }

    public void setGrado(TGrado grado) {
        this.grado = grado;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
    
    
}
