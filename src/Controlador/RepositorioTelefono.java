
package Controlador;

import Modelo.Telefono;

/*@author kevin*/

public class RepositorioTelefono extends Repositorio<Telefono> {
    
    public static RepositorioTelefono obj;

    private RepositorioTelefono(){
    }
    
    public static RepositorioTelefono getRepositorio(){
        if(obj==null){
            obj = new RepositorioTelefono();
        }
        return obj;
    }
    
    @Override
    public void cargarDatos() {
        long a=0;
        Telefono tele;
        
        tele = new Telefono(
             ++a,"7774571517","AT&T","52","Mexico","Movil",1
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"7778455551","AT&T","52","Mexico","Movil",1
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"2774555517","Movistar","34","España","Casa",1
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"8874555517","Vodafone","34","España","Movil",2
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"1074555517","Vodafone","57","Colombia","Compañia",2
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"1456668971","Claro","57","Colombia","Casa",2
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"7776541231","Telcel","52","Mexico","Movil",3
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"7778902223","Unefon","52","Mexico","Movil",3
        );
        listC.add(tele);
        
        tele = new Telefono(
             ++a,"7451234544","Calro","34","España","Casa",3
        );
        listC.add(tele); 
    }
    
}
