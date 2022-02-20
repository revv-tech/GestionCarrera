/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.Formulario;
import gestionadorcarreras.modelo.TEstado;
import java.util.Collection;

/**
 * 
 * @author Marco
 */
public class Controlador {
    
    private GestorCarreras gCarreras;
    private GestorFormularios gFormularios;
    /**
     * Metodo para crear carrera
     * @param dto
     * @return 
     */
    public boolean crearCarrera(DTOCarreras dto){
        return false;
    }
    /**
     * Metodo para visualizar la informacion de una carrera
     * @return 
     */
    public Collection visualizarCarreras(){
        return null;
    }
    /**
     * Metodo para obtener carrera
     * @param codigo
     * @param codigoSede
     * @return 
     */
    public Carrera getCarrera(String codigo, String codigoSede){
        return null;
    }
    /**
     * Metodo para editar carrera
     * @param carrera
     * @return 
     */
    public boolean editarCarrera(Carrera carrera){
        return false;
    }
    /**
     * Metodo para crear formulario
     * @param unFormulario
     * @return 
     */
    public boolean crearFormulario(Formulario unFormulario){
        return false;
    }
    /**
     * Metodo para simular aplicacion de examen
     * @return 
     */
    public boolean simularAplicacionExamen(){
        return false;
    }
    /**
     * Metodo para procesar resultados
     * @return 
     */
    public boolean procesarResultados(){
        return false;
    }
    /**
     * Metodo para visualizar las solicitudes
     * @return 
     */
    public Collection visualizarSolicitudes(){
        return null;
    }
    /**
     * Metodo para ver formularios
     * @param estado
     * @param porNombre
     * @return 
     */
    public Collection verFormularios(TEstado estado, boolean porNombre){
        return null;
    }
    
    
    
    
}
