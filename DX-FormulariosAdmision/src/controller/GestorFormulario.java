/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOFormularioImp;
import java.util.ArrayList;
import java.util.List;
import model.Carrera;
import model.Formulario;
import model.Sede;
import model.TEstado;

/**
 *
 * @author Marco
 */
public class GestorFormulario {
    
    private static int countForm = 0;
    
    public GestorFormulario() {
    }
    /**
     * Método que agrega un formulario a la lista del DAO
     * @return 
     */
    public boolean agregarFormulario(Formulario formulario){
        
        formulario.setNum(countForm);
        countForm = countForm + 1;
        
        return DAOFormularioImp.getInstance().create(formulario);
    }
    
    /**
     * Busca la lista de formularios
     * @return lista de formularios
     */
    public List buscarFormularios(){
        DTOFormulario unDTO = new DTOFormulario();
        return DAOFormularioImp.getInstance().getAll();
    }
    
    public boolean aplicarSimulacion() {
        List<Formulario> formulariosPrueba = this.buscarFormularios();
        // Maximo y minimo de nota
        int min = 0;
        int max = 800;
        
        for (int i = 0 ; i < formulariosPrueba.size() ; i++) {
            Formulario formActual = formulariosPrueba.get(i);
            // Nota aleatoria
            int b = (int)(Math.random()*(max-min+1)+min);
            formActual.setPuntajeObtenido(b);
            //System.out.println(formActual.toString());
            
        }
        return true;
    }
    
    
    public boolean definirResultados(){
    
        List<Formulario> solicitudes = this.buscarFormularios();
        
        for (Formulario f : solicitudes){
        
            if (f.getPuntajeObtenido() < f.getCarreraSolicitada().getPuntajeAdmision()){
            
                f.setEstado(TEstado.RECHAZADO);
            }
        }
        
        return true;
    } 
    /**
    *Devuelve el formulario con el numero recibido
    *numForm: Numero del formulario
    */
    public Formulario obtenerUnFormulario(int numForm){
        ArrayList<Formulario> formularios = (ArrayList) this.buscarFormularios();
        for (Formulario f : formularios){
            if (f.getNum() == numForm){
                return f;
            }
        }
        System.out.println("formulario no encontrado");
        return null;
    }
    
    public int totalSolicitudesEstado(Carrera carrera, Sede sede, TEstado estado){
        int total = 0;
        ArrayList<Formulario> formularios = (ArrayList) this.buscarFormularios();
        if(sede == null && carrera == null){
            for (Formulario f : formularios){
                if (f.getEstado() == estado){
                    total++;
                }
            }
        }
        else if(sede == null){
            for (Formulario f : formularios){
                if (f.getCarreraSolicitada() == carrera && f.getEstado() == estado){
                    total++;
                }
            }
        }
        else if(carrera == null){
            for (Formulario f : formularios){
                if (f.getSede() == sede && f.getEstado() == estado){
                    total++;
                }
            }
        }
        else{
            for (Formulario f : formularios){
                if (f.getSede() == sede && f.getCarreraSolicitada() == carrera && f.getEstado() == estado){
                    total++;
                }
            }
        }
        return total;
    }
}
