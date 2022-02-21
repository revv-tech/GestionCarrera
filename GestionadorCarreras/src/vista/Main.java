/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package vista;
import gestionadorcarreras.controlador.Controlador;
import gestionadorcarreras.modelo.Carrera;
import gestionadorcarreras.modelo.TEstado;
import gestionadorcarreras.modelo.TGrado;
import gestionadorcarreras.modelo.Formulario;
import gestionadorcarreras.modelo.Sede;
import gestionadorcarreras.controlador.DTOCarreras;
import gestionadorcarreras.controlador.DAO;
import java.util.Collection;
import java.util.Collections;
/**
 *
 * @author Marco
 */
public class Main {

    
    public static void main(String args[]) {
       
        
        DAO dao = new DAO();
        Controlador controlador = new Controlador(dao); 
        
        // crear grado
        Sede sedeC = new Sede(1, "Cartago");
        Sede sedeSJ = new Sede(2, "San Jose");
        Carrera compu = new Carrera("CI", "Computacion", 650, 40, TGrado.BACHILLERATO, sedeSJ);
        Carrera biotec = new Carrera("IB", "Biotecnologia", 750, 40, TGrado.BACHILLERATO, sedeC);
        DTOCarreras dtocompu = new DTOCarreras("CI", "Computacion", 650, 40, TGrado.BACHILLERATO, 2, "San Jose");
        DTOCarreras dtobiotec = new DTOCarreras("IB", "Biotecnologia", 750, 40, TGrado.BACHILLERATO, 1, "Cartago");
        
        controlador.crearCarrera(dtocompu);
        controlador.crearCarrera(dtobiotec);
        
        controlador.simularAplicacionExamen(12);

        
        
    }
}
