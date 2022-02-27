/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DTOCarrera;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Marco
 */
public class Formulario {

    
    
    private int num;
    private String identificacion;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private int edad;
    private String correo;
    private String telefono;
    private String direccionResidencia;
    private String instSecundaria;
    private TEstado estado;
    private Carrera carreraSolicitada;
    private Sede sede;
    private int puntajeObtenido;

    public Formulario() {}
    
        public static Comparator<Formulario> compGrade = new Comparator<Formulario>() {
      public int compare(Formulario f1, Formulario f2) {
          return f2.puntajeObtenido - f1.puntajeObtenido;
      }  
    };
    
    public static Comparator<Formulario> compName = new Comparator<Formulario>() {
      public int compare(Formulario f1, Formulario f2) {
          String StudentName1 = f1.nombreCompleto.toUpperCase();
	  String StudentName2 = f2.nombreCompleto.toUpperCase();
	  return StudentName1.compareTo(StudentName2);
      }  
    };
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getInstSecundaria() {
        return instSecundaria;
    }

    public void setInstSecundaria(String instSecundaria) {
        this.instSecundaria = instSecundaria;
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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Formulario{" + "num=" + num + ", identificacion=" + identificacion + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", correo=" + correo + ", telefono=" + telefono + ", direccionResidencia=" + direccionResidencia + ", instSecundaria=" + instSecundaria + ", estado=" + estado + ", carreraSolicitada=" + carreraSolicitada + ", sede=" + sede + ", puntajeObtenido=" + puntajeObtenido + '}';
    }
    
}
