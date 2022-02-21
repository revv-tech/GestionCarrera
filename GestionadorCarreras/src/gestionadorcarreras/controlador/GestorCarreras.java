/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.Sede;
import java.util.Collection;

/**
 *
 * @author Marco
 */
public class GestorCarreras {
    
    private DAO dao;
    
    /**
     * Metodo para agregar una carrera
     * @param unaCarrea
     * @return 
     */
    public boolean agregarCarrera(Carrera unaCarrea){
        dao.carreras.add(unaCarrea);
        return true;
    }
    /**
     * Metodo para buscar carreras
     * 
     * @return 
     */
    public Collection buscarCarreras(){
        return null;
    }
    /**
     * Metodo de buscar sede
     * @param codigo
     * @return 
     */
    public Sede buscarSede(String codigo){
        return null;
    }
    /**
     * Metodo para buscar carrera por codigo
     * 
     * @return 
     */
    public Carrera buscarCarrera(String codigo){
        return null;
    }
    /**
     * Metodo para modificar carrera
     * @param unaCarrera
     * @return 
     */
    public boolean modificarCarrera(Carrera unaCarrera){
        return false;
    }
    /**
     * Metodo que devuelve las carreras del DAO
     * @return 
     */
    public Collection<Carrera> getCarrerasDAO(){
        return dao.getCarreras();
    }
}
