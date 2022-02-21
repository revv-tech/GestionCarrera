/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Formulario;
import gestionadorcarreras.modelo.TEstado;
import java.util.Collection;

/**
 *
 * @author Marco
 */
public class GestorFormularios {
    
    private DAO dao;
    
    /**
     * Metodo de agregar formulario
     * @param unFormulario
     * @return 
     */
    public boolean agregarFormulario(Formulario unFormulario){
        dao.formularios.add(unFormulario);
        return true;
    };
    /**
     * Metodo de realizar simulacion
     * @return 
     */
    public boolean aplicarSimulacion(){
        return false;
    }
    /**
     * Metodo de definir resultados
     * @return 
     */
    public boolean definirResultados(){
        return false;
    }
    /**
     * Metodo de retornar las solicitudes registradas
     * @return 
     */
    public Collection getSolicitudes(){
        return dao.formularios;
    }
    /**
     * Metodo para obtener solictudes por nombre
     * @return 
     */
    public Collection getSolicitudesPorNombre(TEstado estado){
        return null;
    }
    /**
     * Metodo para obtener solictudes por puntaje
     * @return 
     */
    public Collection getSolicitudesPorPuntaje(TEstado estado){
        return null;
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
    
    
}
