
package Controlador;

import java.util.ArrayList;
import java.util.List;
import Modelo.Contacto;
import Modelo.Telefono;

/*@author kevin*/

public abstract class Repositorio<TIPO> {
    public List<TIPO> listC;
    
    public Repositorio(){
        listC = new ArrayList<>();
        cargarDatos();
    }
    
    public List<TIPO> getList(){
        return listC;
    }
    
    public void agregar(TIPO ins){
        listC.add(ins);
    }
    
    
    
    public abstract void cargarDatos();
    
    
}
