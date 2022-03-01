package view;

import controller.Control;
import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOSedesImpl;
import controller.DTOCarrera;
import controller.DTOFormulario;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    
    private static void showCarreras(ArrayList<Carrera> carreras){
        int i = 1;
        for(Carrera carrera : carreras){
            Sede sede = carrera.getLaSede();
            System.out.println(i + ". " + carrera.getNombre());
            System.out.println("Código = " + carrera.getCodigo());
            System.out.println("Puntaje de Admisión = " + carrera.getPuntajeAdmision());
            System.out.println("Capacidad máxima = " + carrera.getCapacidadMax());
            System.out.println("Grado = " + carrera.getGrado());
            System.out.println("Sede = " + sede.getNombre());
            System.out.println("Código de sede = " + sede.getCodigo());
            System.out.println("\n");
            i++;
        }
    }
    
    private static void showFormularios(ArrayList<Formulario> formularios){
        int i = 1;
        for(Formulario form : formularios){
            System.out.println("- Formulario con id " + form.getNum());
            System.out.println("Identificación = " + form.getIdentificacion());
            System.out.println("Nombre completo = " + form.getNombreCompleto());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Fecha de nacimiento = " + simpleDateFormat.format(form.getFechaNacimiento()));
            System.out.println("Edad = " + form.getEdad());
            System.out.println("Correo = " + form.getCorreo());
            System.out.println("Teléfono = " + form.getTelefono());
            System.out.println("Dirección = " + form.getDireccionResidencia());
            System.out.println("Institución de la Secundaria = " + form.getInstSecundaria());
            System.out.println("Estado = " + form.getEstado());
            System.out.println("Carrera Solicitada = " + form.getCarreraSolicitada().getNombre() + " ("+form.getCarreraSolicitada().getCodigo()+")");
            System.out.println("Sede de la carrera = " + form.getSede().getNombre() + "(" + form.getSede().getCodigo() + ")");
            System.out.println("Puntaje obtenido = " + form.getPuntajeObtenido());
            System.out.println("\n");
            i++;
        }
    }

    private static void showConsulta(String codigo, String nombre, int puntajeMaximo, int maximoAdmitidos, String grado, String codigoSede){
        System.out.println("- " + nombre);
        System.out.println("Código = " + codigo);
        System.out.println("Puntaje de Admisión = " + puntajeMaximo);
        System.out.println("Capacidad máxima = " + maximoAdmitidos);
        System.out.println("Grado = " + grado);
        System.out.println("Sede = " + (codigoSede.equals("SJ") ? "San José" : "Cartago"));
        System.out.println("Código de sede = " + codigoSede);
        System.out.println("\n");
    }    

    public static void main(String[] args) {
        // se activa el DTO que provee el control
        elDTO = Control.getInstance().getDto();
        dtoFormulario = Control.getInstance().getDTOFormulario();
        //se muestran las carreras previamente cargadas
        System.out.println("Mostrando las carreras guardadas...\n");
        Control.getInstance().mostrarCarreras();
        showCarreras((ArrayList) elDTO.getLasCarreras());
        
        //System.out.println(elDTO.getLasCarreras()+"\n");        
        
        //mostrar las carreras específicas de una sede particular: CARTAGO
        System.out.println("Mostrando las carreras guardadas con sede en Cartago...\n");
        Control.getInstance().mostrarCarreras("CA");
        showCarreras((ArrayList) elDTO.getLasCarreras());
                
        //incorporando una nueva carrera al sistema
        System.out.println("Ingresando una nueva carrera con sede en San José llamada 'Arquitectura y Urbanismo'...\n");
        
        elDTO.setCodigo("AU");
        elDTO.setNombre("Arquitectura y Urbanismo");
        elDTO.setGrado("LICENCIATURA");
        elDTO.setMaximoAdmitidos(20);
        elDTO.setPuntajeMaximo(600);
        elDTO.setCodigoSede("SJ");        
        Control.getInstance().crearCarrera(elDTO);
        
        //mostrar las carreras específicas de una sede particular: SAN JOSE
        System.out.println("\nMostrando las carreras con sede en San José...\n");
        Control.getInstance().mostrarCarreras("SJ");
        showCarreras((ArrayList) elDTO.getLasCarreras());
        
        System.out.println("\nConsultando la carrera con sede en San José y Código AU...\n");
        Control.getInstance().consultarCarrera("SJ", "AU");
        showConsulta(elDTO.getCodigo(), elDTO.getNombre(), elDTO.getPuntajeMaximo(), elDTO.getMaximoAdmitidos(), elDTO.getGrado(), elDTO.getCodigoSede());
        
        System.out.println("Editando el puntaje de admisión y la capacidad de la carrera de Ingeniería en Computación de la sede Cartago... \n");
        elDTO.setCodigoSede("CA");
        elDTO.setCodigo("IC");
        elDTO.setMaximoAdmitidos(20);
        elDTO.setPuntajeMaximo(680);
        Control.getInstance().editarCarrera(elDTO);
        
        System.out.println("\nMostrando las carreras con sede en Cartago...\n");
        Control.getInstance().mostrarCarreras("CA");
        showCarreras((ArrayList) elDTO.getLasCarreras());

        // Agrega formularios
        // Se activa el DTO que provee el control de formularios
        // Agregando nuevo formulario
        //Nueva sede
        Sede sede = new Sede("LI","Limon");
        
        System.out.println("Generando formularios...");
        
        // Ejemplo de agregar formularios
        for (int i = 10 ; i != 0 ; i--){
            // Carrera de prueba
            // Maximo y minimo de index de carreras
            int min = 0;
            int max = elDTO.getLasCarreras().size()-1;
            int carreraAleatoria = (int)(Math.random()*(max-min+1)+min);
            Carrera carrera = elDTO.getLasCarreras().get(carreraAleatoria);
            // Empieza a crear el DTO (la nota siempre empezara en cero y el gestor poner el num del formulario)
            dtoFormulario.setCarreraSolicitada(carrera);
            dtoFormulario.setCorreo("revvace@gmail.com");
            dtoFormulario.setEdad(20);
            dtoFormulario.setEstado(TEstado.ACEPTADO);
            Date date = new Date();
            dtoFormulario.setFechaNacimiento(date);
            dtoFormulario.setIdentificacion("117680133");
            dtoFormulario.setInstSecundaria("New Hope Highschool");
            dtoFormulario.setNombreCompleto("Marco Antonio Reveiz Rojas");
            dtoFormulario.setSede(sede);
            dtoFormulario.setTelefono("85769188");
            dtoFormulario.setDireccionResidencia("Heredia, San Rafel");
            Control.getInstance().crearFormulario(dtoFormulario);
        }
        //Control.getInstance().mostrarFormularios();
        //Simula examen de nota
        
        System.out.println("Aplicando exámenes...");
        Control.getInstance().simularExamen();
        
        System.out.println("Definiendo el estado de las solicitudes...\n");
        Control.getInstance().definirEstadoSolicitudes();
        
        System.out.println("Mostrando todas las solicitudes...\n");
        Control.getInstance().mostrarSolictudes();
        showFormularios((ArrayList)dtoFormulario.getFormularios());
        
        System.out.println("Mostrando las solicitudes RECHAZADAS por nombre del solicitante");
        Control.getInstance().
        
    }
}
