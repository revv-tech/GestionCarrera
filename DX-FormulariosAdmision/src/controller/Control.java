/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOSedesImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Carrera;
import model.Formulario;
import model.Sede;
import model.TGrado;
import model.TEstado;                   

/**
 *
 * @author ersolano
 */
public class Control {
    
    
    //atributo autorreferenciado para el manejo del Singleton
    private static Control singletonControl;
    
    //Atributo DTO Utilitario para la transferencia de datos asociados a la entidad Carrera
    private DTOCarrera dto;
    
    //Agregado Marco
    //Atributo DTO Utilitario para la transferencia de datos asociados a la entidad Formulario
     private DTOFormulario dtoFormulario;
     
    //atributos de acceso controlado 
    private GestorCarreras gCarreras;
    
    //attributos de acceso controlado
    private GestorFormulario gFormularios;

    public static Control getInstance(){
        if (singletonControl == null){
            singletonControl =new Control();
        }
        return singletonControl;
    }
    private Control() {
        dto = new DTOCarrera();
        //Agregado Marco
        dtoFormulario = new DTOFormulario();
        gFormularios = new GestorFormulario();
        gCarreras = new GestorCarreras();  // se habilita un gestor con carreras precreadas    
    }

    public DTOCarrera getDto() {
        return dto;
    }
    
    public DTOFormulario getDTOFormulario(){
        return dtoFormulario;
    }
    
    public boolean crearCarrera(DTOCarrera dto){      
        // Paso 1: localizar todos los datos que están relacionados a la carrera 
        TGrado elGrado = TGrado.valueOf(dto.getGrado());
        Sede laSede = (Sede) DAOSedesImpl.getInstance().get(dto.getCodigoSede());
        
        //crea una instancia de acuerdo al modelo propuesto de una carrera
        Carrera unaCarrera = new Carrera(dto.getCodigo(), dto.getNombre(),
                            dto.getPuntajeMaximo(), dto.getMaximoAdmitidos(),
                            elGrado, laSede);
        // se solicita al gestor el registro de la carrera
        return gCarreras.agregarCarrera(unaCarrera);
    }
    
    public List<Formulario> ordenarXNombre(TEstado estado){
       List<Formulario> formularios = dtoFormulario.getFormularios();
       formularios = GestorFormulario.formulariosXEstado(formularios, estado);
       Collections.sort(formularios, Formulario.compName);
       return formularios;
    }
    
    public List<Formulario> ordenarXPuntaje(TEstado estado){
       List<Formulario> formularios = dtoFormulario.getFormularios();
       formularios = GestorFormulario.formulariosXEstado(formularios, estado);
       Collections.sort(formularios, Formulario.compGrade);
       return formularios;
    }
    
    public void mostrarCarreras(){
        // el gestor obtiene lo solicitado y lo deja en el dto.
        dto.setLasCarreras(gCarreras.buscarCarreras());
    }

    public void mostrarCarreras(String codigoSede){
        dto.setLasCarreras(gCarreras.buscarCarreras(codigoSede));
    }

    public void consultarCarrera(String codSede, String codCarrera){
        Carrera laCarrera=  gCarreras.buscarCarrera(codSede, codCarrera);
        if (laCarrera != null){
            dto.setCodigo(laCarrera.getCodigo());
            dto.setNombre(laCarrera.getNombre());
            dto.setGrado(laCarrera.getGrado().name());
            dto.setMaximoAdmitidos(laCarrera.getCapacidadMax());
            dto.setPuntajeMaximo(laCarrera.getPuntajeAdmision());
            dto.setCodigoSede(laCarrera.getLaSede().getCodigo());
        }
    }
    
    public boolean editarCarrera(DTOCarrera elDTO){
        Carrera laCarrera = gCarreras.buscarCarrera(elDTO.getCodigoSede(), elDTO.getCodigo());
        if (laCarrera != null){
            laCarrera.setPuntajeAdmision(elDTO.getPuntajeMaximo());
            laCarrera.setCapacidadMax(elDTO.getMaximoAdmitidos());
            return gCarreras.modificarCarrera(laCarrera);
        }
        return false;
    }
    /**
     * Crea formulario
     * @param dto DTOFormulario
     * @return 
     */
    public boolean crearFormulario(DTOFormulario dto){
        //Crea obj Formulaio
        Formulario nuevoFormulario = new Formulario();
        //Iguala atributos
        nuevoFormulario.setCorreo(dto.getCorreo());
        nuevoFormulario.setEdad(dto.getEdad());
        nuevoFormulario.setEstado(dto.getEstado());
        nuevoFormulario.setFechaNacimiento(dto.getFechaNacimiento());
        nuevoFormulario.setIdentificacion(dto.getIdentificacion());
        nuevoFormulario.setInstSecundaria(dto.getInstSecundaria());
        nuevoFormulario.setNombreCompleto(dto.getNombreCompleto());
        nuevoFormulario.setPuntajeObtenido(dto.getPuntajeObtenido());
        nuevoFormulario.setSede(dto.getSede());
        nuevoFormulario.setTelefono(dto.getTelefono());
        nuevoFormulario.setDireccionResidencia(dto.getDireccionResidencia());
        nuevoFormulario.setCarreraSolicitada(dto.getCarreraSolicitada());
        
        return gFormularios.agregarFormulario(nuevoFormulario);
    }
    
    /**
     * Simula aplicacion de prueba con las lista de formularios registrados
     */
    
    public boolean simularExamen() {
        return gFormularios.aplicarSimulacion();
    }
    
    public void mostrarSolictudes(){
        // el gestor obtiene lo solicitado y lo deja en el dto.
        dtoFormulario.setFormularios(gFormularios.buscarFormularios());
        
    }

    public void verUnFormulario(DTOFormulario dto){
        Formulario form = gFormularios.obtenerUnFormulario(dto.getNum());
        dtoFormulario.setIdentificacion(form.getIdentificacion());
        dtoFormulario.setNombreCompleto(form.getNombreCompleto());
        dtoFormulario.setFechaNacimiento(form.getFechaNacimiento());
        dtoFormulario.setEdad(form.getEdad());
        dtoFormulario.setCorreo(form.getCorreo());
        dtoFormulario.setTelefono(form.getTelefono());
        dtoFormulario.setDireccionResidencia(form.getDireccionResidencia());
        dtoFormulario.setInstSecundaria(form.getInstSecundaria());
        dtoFormulario.setEstado(form.getEstado());
        dtoFormulario.setCarreraSolicitada(form.getCarreraSolicitada());
        dtoFormulario.setSede(form.getSede());
        dtoFormulario.setPuntajeObtenido(form.getPuntajeObtenido());
    }
    
    public void definirEstadoSolicitudes(){
    
        gFormularios.definirResultados();
    }
    
    public void totalSolicitudesEstado(DTOFormulario dto){
        dtoFormulario.setTotalEstado(gFormularios.totalSolicitudesEstado(dto.getCarreraSolicitada(), dto.getSede(), dto.getEstado()));
    }
}
