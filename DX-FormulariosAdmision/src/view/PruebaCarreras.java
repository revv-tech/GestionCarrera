package view;

import controller.Control;
import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOSedesImpl;
import controller.DTOCarrera;
import controller.DTOFormulario;
import java.util.Date;
import model.Carrera;
import model.Formulario;
import model.Sede;
import model.TEstado;
import model.TGrado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ersolano
 */
public class PruebaCarreras {
 
    static DTOCarrera elDTO;
    static DTOFormulario dtoFormulario;
    
    public static void mostrarCarreras(){
        
        
    }
    
    public static void main(String[] args) {
        // se activa el DTO que provee el control
        elDTO = Control.getInstance().getDto();
        dtoFormulario = Control.getInstance().getDTOFormulario();
        //se muestran las carreras previamente cargadas
        Control.getInstance().mostrarCarreras();
        System.out.println("Todas las carreras\n" + elDTO.getLasCarreras());
        
        //mostrar las carreras específicas de una sede particular: CARTAGO
        Control.getInstance().mostrarCarreras("CA");
        System.out.println("Las carreras de CA\n" + elDTO.getLasCarreras());
        
        //incorporando una nueva carrera al sistema
        System.out.println("Ingresando una nueva carrera");
        elDTO.setCodigo("AU");
        elDTO.setNombre("Arquitectura y Urbanismo");
        elDTO.setGrado("LICENCIATURA");
        elDTO.setMaximoAdmitidos(40);
        elDTO.setPuntajeMaximo(600);
        elDTO.setCodigoSede("SJ");        
        Control.getInstance().crearCarrera(elDTO);
        
        //mostrar las carreras específicas de una sede particular: SAN JOSE
        Control.getInstance().mostrarCarreras("SJ");
        System.out.println("Las carreras de SJ\n" + elDTO.getLasCarreras());
        
        Control.getInstance().consultarCarrera("SJ", "AU");
        System.out.println("La carrera consultada es "+ 
                                    elDTO.getCodigo()+ "-"+
                                    elDTO.getNombre());
        
        elDTO.setCodigoSede("CA");
        elDTO.setCodigo("IC");
        elDTO.setMaximoAdmitidos(200);
        elDTO.setPuntajeMaximo(680);
        Control.getInstance().editarCarrera(elDTO);
        Control.getInstance().editarCarrera(elDTO);
        
        
        Control.getInstance().mostrarCarreras("CA");
        System.out.println("Luego de modificar " + elDTO.getLasCarreras());
        
        // Agrega formularios
        // Se activa el DTO que provee el control de formularios
        // Agregando nuevo formulario
        
        Sede sede = new Sede("LI","Limon");
        
        // Carrera de prueba
        Carrera carrera = new Carrera("CI", "Compu",650, 90, TGrado.BACHILLERATO, sede);
        
        dtoFormulario.setCarreraSolicitada(carrera);
        dtoFormulario.setCorreo("revvace@gmail.com");
        dtoFormulario.setEdad(20);
        dtoFormulario.setEstado(TEstado.ACEPTADO);
        Date date = new Date();
        dtoFormulario.setFechaNacimiento(date);
        dtoFormulario.setIdentificacion("117680133");
        dtoFormulario.setInstSecundaria("New Hope Highschool");
        dtoFormulario.setNombreCompleto("Marco Antonio Reveiz Rojas");
        dtoFormulario.setPuntajeObtenido(0);
        dtoFormulario.setSede("SJ");
        dtoFormulario.setTelefono("85769188");
        dtoFormulario.setDireccionResidencia("Heredia, San Rafel");
        Control.getInstance().crearFormulario(dtoFormulario);
        
        
        Control.getInstance().mostrarFormularios();
        Control.getInstance().simularExamen();
        System.out.println(dtoFormulario.getFormularios());
        
        
    }
}
