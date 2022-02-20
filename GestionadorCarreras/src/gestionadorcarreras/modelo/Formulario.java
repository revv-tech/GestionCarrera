/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionadorcarreras.modelo;

/**
 *
 * @author Marco
 */
public class Formulario {
    private int num;
    private TEstado estado;
    private Carrera carreraSolicitada;
    private int puntajeObtenido;

    public Formulario(int num, TEstado estado, Carrera carreraSolicitada, int puntajeObtenido) {
        this.num = num;
        this.estado = estado;
        this.carreraSolicitada = carreraSolicitada;
        this.puntajeObtenido = puntajeObtenido;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TEstado getEstado() {
        return estado;
    }

    public void setEstado(TEstado estado) {
        this.estado = estado;
    }

    public Carrera getCarreraSolicitada() {
        return carreraSolicitada;
    }

    public void setCarreraSolicitada(Carrera carreraSolicitada) {
        this.carreraSolicitada = carreraSolicitada;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }
    
}
