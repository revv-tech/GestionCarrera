/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package gestionadorcarreras.controlador;

import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.Formulario;
import gestionadorcarreras.modelo.Sede;
import gestionadorcarreras.modelo.TEstado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * 
 * @author Marco
 */
public class Controlador {
    
    private GestorCarreras gCarreras;
    private GestorFormularios gFormularios;
    private DTOCarreras dtoCarerras;
    private static int countForm = 0;

    public Controlador(DAO _dao) {
        this.gCarreras = new GestorCarreras();
        gCarreras.setDao(_dao);
        this.gFormularios = new GestorFormularios();
        gFormularios.setDao(_dao);
    }
    
    
    
    /**
     * Metodo para crear carrera
     * @param dto
     * @return 
     */
    public boolean crearCarrera(DTOCarreras dto){
        Sede sede = new Sede(dto.codigoSede,dto.nombreSede);
        Carrera carrera = new Carrera(dto.codigo,dto.nombre,dto.puntajeAdmision,dto.capacidadMax,dto.grado,sede);
        gCarreras.agregarCarrera(carrera);
        return true;
    }
    /**
     * Metodo para visualizar la informacion de una carrera
     * @return 
     */
    public ArrayList<Carrera> visualizarCarreras(){
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
        // Pone id a cada form
        unFormulario.setNum(countForm++);
        // Agrega form a gCarreras
        gFormularios.agregarFormulario(unFormulario);
        // retorna true si es exitoso
        return true;
    }
    /**
     * Metodo para simular aplicacion de examen
     * @return 
     */
    public boolean simularAplicacionExamen(int maxForms){
        // Cantidad de forms
        int minForms = 0;  
        int randomNum = (int)(Math.random()*(maxForms-minForms+1)+minForms);
        
        // Maximo y minimo de nota
        int min = 0;
        int max = 800;
        
        
        
        for (int i = 0 ; i <= maxForms ; i++){
            //Crea codigo de formulario
            countForm = countForm+1;
            // Obtiene carrera random
            Random rnd = new Random();
            int iCarrera = rnd.nextInt(gCarreras.getCarrerasDAO().size());
            Carrera carrera = (Carrera) gCarreras.getCarrerasDAO().toArray()[iCarrera];
            // Nota aleatoria
            int b = (int)(Math.random()*(max-min+1)+min);
            // Crea form
            Formulario newForm = new Formulario(carrera,b);
            newForm.setNum(countForm);
            gFormularios.agregarFormulario(newForm);
            System.out.println(newForm.toString());
               
        }
        return true;
    }
    /**
     * Metodo para procesar resultados
     * @return 
     */
    public boolean procesarResultados(){
        
        
        ArrayList<Formulario> forms = gFormularios.getSolicitudes();
        
            for (Formulario f : forms){
                
                if (f.getPuntajeObtenido() < f.getCarreraSolicitada().getPuntajeAdimision()){

                    f.setEstado(TEstado.RECHAZADO);
                }

                else if (f.getPuntajeObtenido() >= f.getCarreraSolicitada().getPuntajeAdimision()){

                    f.setEstado(TEstado.ACEPTADO);
                }
                System.out.println(f.toString());
              
        }
            
            return true;
    }
    /**
     * Metodo para visualizar las solicitudes
     * @return 
     */
    public ArrayList<Carrera> visualizarSolicitudes(){
        return null;
    }
    /**
     * Metodo para ver formularios
     * @param estado
     * @param porNombre
     * @return 
     */
    public ArrayList<Carrera> verFormularios(TEstado estado, boolean porNombre){
        return null;
    }
    
    
}
