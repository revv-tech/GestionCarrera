/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.Formulario;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Marco
 */
public class DAO {
    
    ArrayList<Carrera> carreras;
    ArrayList<Formulario> formularios;

    public DAO() {
        this.carreras = new ArrayList<Carrera>();
        this.formularios = new ArrayList<Formulario>();
    }
    
    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }
    
}
