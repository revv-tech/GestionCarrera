/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.Formulario;
import java.util.Collection;

/**
 *
 * @author Marco
 */
public class DAO {
    
    Collection<Carrera> carreras;
    Collection<Formulario> formularios;

    public DAO() {
        

    }
    
    
    public Collection<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Collection<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Collection<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(Collection<Formulario> formularios) {
        this.formularios = formularios;
    }
    
}
