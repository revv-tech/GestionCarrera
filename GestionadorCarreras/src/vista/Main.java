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

/**
 *
 * @author Marco
 */
public class Main {

    
    public static void main(String args[]) {
       
        // crear sede
        // crear grado
        Sede sedeC = new Sede(1, "Cartago");
        Sede sedeSJ = new Sede(1, "San Jose");
        Carrera compu = new Carrera("CI", "Computacion", 650, 40, TGrado.BACHILLERATO, sedeSJ);
        Carrera biotec = new Carrera("BIO", "Biotecnologia", 750, 40, TGrado.BACHILLERATO, sedeC);
    }
}
