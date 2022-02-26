/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAO;

import java.util.ArrayList;
import java.util.List;
import model.Carrera;
import model.Formulario;

/**
 *
 * @author Marco
 */
public class DAOFormularioImp implements DAOTrasaccional{
    
    // instancia autorreferenciada para el uso de Singleton
    private static DAOFormularioImp accesoFormulario;

    // atributo de acceso controlado:
    private List<Formulario> tablaFormularios = new ArrayList<Formulario>();
    
    private DAOFormularioImp() {
    }
    
    public static DAOFormularioImp getInstance(){
        if (accesoFormulario == null)
            accesoFormulario = new DAOFormularioImp();
        return accesoFormulario;
    }
    
     @Override
    public boolean create(Object obj) {
        Formulario form = (Formulario)obj;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formActual = tablaFormularios.get(i);
            if (formActual.equals(form))
                return false;   // no se puede registrar una carrera con el mismo código
        }
        return tablaFormularios.add(form);
    }

    @Override
    public boolean update(Object obj) {
        Formulario form = (Formulario)obj;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formActual = tablaFormularios.get(i);
            if (formActual.equals(form)){
                tablaFormularios.set(i, form);
                return true;
            }
        }
        return false;
    }

    @Override
    // Lo busca por identificación
    public Object get(Object key) {
        String codigoALocalizar = (String) key;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if (formularioActual.getIdentificacion().equals(codigoALocalizar)) {
                return formularioActual;
            }
        }
        return null;  // no apareció la sede solicitada
    }

    @Override
    public List getAll() {
        return tablaFormularios;
    }
}
