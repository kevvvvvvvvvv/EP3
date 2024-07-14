
package Controlador;

import java.io.IOException;
import Modelo.Contacto;

/**@author kevin*/
public class RepositorioContacto extends Repositorio<Contacto>{
    
    public static Repositorio obj;
    
    private RepositorioContacto(){
    }
    
    public static Repositorio getRepositorio() throws IOException{
        if(obj== null){
            obj = new RepositorioContacto();
        }
        return obj;
    }       

    @Override
    public void cargarDatos() {
        long a=1;
        Contacto con = new Contacto(
            a,"Camila","Alor","Contreras","Morelos","Mexico",50
        );
        listC.add(con);
        
        con = new Contacto(
            ++a,"Kevin Yahir","Trinidad","Medina","Queretaro","Mexico",20
        );
        listC.add(con);
        
        con = new Contacto(
            ++a,"Tobias","Martinez","Hernandez","Toronto","Canada",20
        );
        listC.add(con); 
    }
    
}
