/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOFormularioImp;
import java.util.ArrayList;
import java.util.List;
import model.Formulario;
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
}
