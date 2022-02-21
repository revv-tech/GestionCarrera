/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package gestionadorcarreras.modelo;

/**
 *
 * @author Marco
 */
public class Carrera {

    private String codigo;
    private String nombre;
    private int puntajeAdimision;
    private int capacidadMaxima;
    private int ContadorCapacidadActual;
    private TGrado grado;
    private Sede laSede;

    public Carrera(String codigo, String nombre, int puntajeAdimision, int capacidadMaxima, TGrado grado, Sede laSede) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntajeAdimision = puntajeAdimision;
        this.capacidadMaxima = capacidadMaxima;
        this.grado = grado;
        this.laSede = laSede;
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

    public int getPuntajeAdimision() {
        return puntajeAdimision;
    }

    public void setPuntajeAdimision(int puntajeAdimision) {
        this.puntajeAdimision = puntajeAdimision;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public TGrado getGrado() {
        return grado;
    }

    public void setGrado(TGrado grado) {
        this.grado = grado;
    }

    public Sede getLaSede() {
        return laSede;
    }

    public void setLaSede(Sede laSede) {
        this.laSede = laSede;
    }

    public int getContadorCapacidadActual() {
        return ContadorCapacidadActual;
    }

    public void setContadorCapacidadActual(int ContadorCapacidadActual) {
        this.ContadorCapacidadActual = ContadorCapacidadActual;
    }

    @Override
    public String toString() {
        return "Carrera{" + "codigo=" + codigo + ", nombre=" + nombre + ", puntajeAdimision=" + puntajeAdimision + '}';
    }
    
    
}
