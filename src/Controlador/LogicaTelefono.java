
package Controlador;

import Modelo.Contacto;
import Modelo.Telefono;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**@author Usuario**/

public class LogicaTelefono {
    
    private Repositorio<Telefono> rep;
    private List<Telefono> list;
    
    public LogicaTelefono() throws IOException{
        rep = RepositorioTelefono.getRepositorio();
        list = rep.getList();
    }
    
    public void validarTelefono(long id, String te, String com, String pre, String pais, String tipo, String idC) throws Exception{
        
        //Validando que los campos no esten vacios
        if(te.isEmpty() || com.isEmpty() || pre.isEmpty() || pais.isEmpty() || tipo.isEmpty() || idC.isEmpty()){
            throw new Exception();
        }
        
        //Evaluando que el país y tipo no tenga crácteres especiales
        if ((!pais.matches("[a-zA-ZñÑ ]+")) || (!tipo.matches("[a-zA-ZñÑ ]+"))) {
            throw new Exception();
        }

        
        //Evaluando que las cadenas de teléfono, prefijo e id del contacto sean números
        if((!te.matches("\\d+")) || (!idC.matches("\\d+")) || (!pre.matches("\\d+"))){
            throw new Exception();
        }
        
        //Convertir id de contacto en int
        int idCon = Integer.parseInt(idC);
        
        //Evaluando que el id del contacto exista
        boolean flag;
        flag = verificarIdC(idCon);
        if(flag != true){
            throw new Exception();
        }
        
        
        Telefono telefono = new Telefono(id,te,com,pre,pais,tipo,idCon);
        agregarTelefono(telefono);
    }
    
    private void agregarTelefono(Telefono telefono){
        long id;
        Telefono t = new Telefono();
        if(telefono.getId()==0){
            
            //Generando un id de manera automatica
            t = list.get(list.size()-1);
            id = t.getId();
            telefono.setId(++id);
            rep.agregar(telefono);
        }else{
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == telefono.getId()) {
                    list.set(i, telefono); 
                    break; 
                }
            }
        }
    }
    
    public boolean buscar(int met,String dat,JTable usuarios) throws Exception{
        Telefono t = new Telefono();
        Contacto c = new Contacto();
        
        switch(met){
            case 0:
                //NUMERO DE TELEFONO
                //Verificando que haya colocado un numero de telefono
                if(!dat.matches("\\d+")){
                    throw new Exception();
                }
                
                t = buscarTelefono(dat);
                break;
                
            case 1:
                if(!dat.matches("\\d+")){
                    throw new Exception();
                }
                long idT = Long.parseLong(dat);
                
                t = buscarId(idT);
                break;
        }
        
        //Terminar la ejecucion si no se encuentra un elemento al buscado
        if(t == null){
            return false;
        }
        
        c = buscarContactoIdT(t);
        
        DefaultTableModel modelo =(DefaultTableModel) usuarios.getModel();
        modelo.setRowCount(0);   
        
        //Mostrar los datos en la tabla de la interfaz gráfica
        String[] datos ={c.getNombre(),String.valueOf(c.getId()),String.valueOf(t.getId()),t.getNum(),t.getCompania(),t.getPrefijo(),t.getPais(),t.getTipo()};
        modelo.addRow(datos);
        
        return true;
    }
    
    public Telefono buscarTelefono(String tele){
        for(Telefono t:list){
            if(t.getNum().equals(tele)){
                return t;
            }
        }
        return null;
    }
    
    public Telefono buscarId(long idT){
        for(Telefono t:list){
            if(t.getId() == idT){
                return t;
            }
        }
        return null;
    }
    
    public Contacto buscarContactoIdT(Telefono t) throws IOException{
        Repositorio<Contacto> repCon = RepositorioContacto.getRepositorio();
        LogicaContacto lc = new LogicaContacto();
        List<Contacto> listaC = repCon.getList();
        
        for(Contacto c:listaC){
            if(c.getTelefonos()!=null){
                for(Telefono q:c.getTelefonos()){
                    if(q.getNum().equals(t.getNum()) || q.getId() == t.getId()){
                        return c;
                    }
                }
            }
        }
        
        return null;
    }
    
    public boolean verificarIdC(int idC) throws IOException{
        Repositorio<Contacto> repCon = RepositorioContacto.getRepositorio();
        LogicaContacto lc = new LogicaContacto();
        List<Contacto> listaC = repCon.getList();
        
        for(Contacto c:listaC){
            if(c.getId() == idC){
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarTelefono(long id){
        boolean flag = false;
        Telefono tel = new Telefono();
        for(Telefono t:list){
            if(t.getId() == id){
                tel = t;
                break;
            }
        }
        
        list.remove(tel);
        return flag;
    }
}
