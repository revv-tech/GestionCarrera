/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionadorcarreras.modelo;
import java.util.Comparator;

/**
 *
 * @author Marco
 */
public class Formulario {
    
    private int num;
    private TEstado estado;
    private Carrera carreraSolicitada;
    private int puntajeObtenido;
    private String nombreSolicitante;
    

    public Formulario(Carrera carreraSolicitada, int puntajeObtenido, String nombre) {
        this.carreraSolicitada = carreraSolicitada;
        this.puntajeObtenido = puntajeObtenido;
        this.nombreSolicitante = nombre;
    }
    
    public Formulario(Carrera carreraSolicitada, int puntajeObtenido){
        this.carreraSolicitada = carreraSolicitada;
        this.puntajeObtenido = puntajeObtenido;
        this.nombreSolicitante = "";
    }
    
    public static Comparator<Formulario> compGrade = new Comparator<Formulario>() {
      public int compare(Formulario f1, Formulario f2) {
          return f2.puntajeObtenido - f1.puntajeObtenido;
      }  
    };
    
    public static Comparator<Formulario> compName = new Comparator<Formulario>() {
      public int compare(Formulario f1, Formulario f2) {
          String StudentName1 = f1.nombreSolicitante.toUpperCase();
	  String StudentName2 = f2.nombreSolicitante.toUpperCase();
	  return StudentName1.compareTo(StudentName2);
      }  
    };

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
