
package Controlador;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Contacto;
import Modelo.Telefono;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;


/**
 *
 * @author kevin
 */
public class LogicaContacto{
    
    
    private Repositorio<Contacto> rep;
    private List<Contacto> list;
    
    public LogicaContacto() throws IOException{
        //rep = RepositorioContacto.getRepositorio();
        //list = rep.getList();
        //crearEnlaces();
    }
    
    public void validarContacto(int id,String n,String ap,String am,String pais,String estado,String edad)throws Exception{
        
        //Validando que los campos no esten vacios
        if(n.isEmpty() || ap.isEmpty() || am.isEmpty() || pais.isEmpty() || estado.isEmpty() || edad.isEmpty()){
            throw new Exception(); 
        }
        
        //Validando que los textos no tengan caracteres especiales
        if(!n.matches("[a-zA-Z ]+") || !am.matches("[a-zA-Z ]+") || !ap.matches("[a-zA-Z ]+") || !pais.matches("[a-zA-Z ]+") || !estado.matches("[a-zA-Z ]+")){
            throw new Exception();
        }
        
        //Evaluando que la cadena tenga solo numeros
        if(!edad.matches("\\d+")){
            throw new Exception();
        }
        
        int ed = Integer.parseInt(edad);
        //Contacto con = new Contacto(id,n,ap,am,estado,pais,ed);
        insertarContacto(id,n,ap,am,pais,estado,edad);
    }
    
    private void insertarContacto(int id,String n,String ap,String am,String pais,String estado,String edad) throws SQLException, Exception{
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        
        String Query = "insert into contacto values(?,?,?,?,?,?,?)";
        
        PreparedStatement insertar = cone.conexion.prepareStatement(Query);
        
        insertar.setString(1,String.valueOf(generarId()));
        insertar.setString(2,n);
        insertar.setString(3,ap);
        insertar.setString(4,am);
        insertar.setString(5,estado);
        insertar.setString(6,pais);
        insertar.setString(7,edad);
        insertar.executeUpdate();
        
    }
    
    private int generarId() throws SQLException, Exception{
        Conexion cone = new Conexion();
        int id=0;
        cone.JavaToMySQL();
        String Query = "select max(idcontacto) from contacto";
        
        cone.comando = cone.conexion.createStatement();
        ResultSet rs = cone.comando.executeQuery(Query);
        if (rs.next()) {
            id = rs.getInt(1); // Obtener el primer resultado de la consulta
            if (rs.wasNull()) {
                id = 0; // Si el valor era null, asignar 0
            }
        }
        return (id+1);
    }
    
    /*FUNCIONES ANTIGUAS*/
    
    public boolean buscar(int met,String dat,JTable usuarios) throws Exception{
        List<Contacto> con = new ArrayList<>();
        
        
        int a=0;
        switch(met){
            case 0: 
                //NUMERO DE TELEFONO
                //Verificando que haya colocado un numero de telefono
                if(!dat.matches("\\d+")){
                    throw new Exception();
                }
                con = buscarTelefono(dat);
                break;
            case 1:
                //ID
                //Verificando si coloco una ID válida
                if(!dat.matches("\\d+")){
                    throw new Exception();
                }
                long id = Long.parseLong(dat);
                con=buscarId(id);
                
                break;
            case 2:
                //PAIS
                if(!dat.matches("[a-zA-Z ]+")){
                    throw new Exception();
                }
                con = buscarPais(dat);
                break;
            case 3:
                //EDAD
                //Evaluando que sea una edad válida
                if(!dat.matches("\\d+")){
                    throw new Exception();
                }  
                int ed = Integer.parseInt(dat);
                con = buscarEdad(ed);
                
                break;
        }
        
        //Terminar la ejecucion si no se encuentra un elemento al buscado
        if(con.isEmpty()){
            return false;
        }
       
        DefaultTableModel modelo =(DefaultTableModel) usuarios.getModel();
        modelo.setRowCount(0);        
        
        //Mostrar los datos en la tabla de la interfaz gráfica
        for (Contacto p : con) {
            if (p.getTelefonos() != null && !p.getTelefonos().isEmpty()) {
                for (Telefono q : p.getTelefonos()) {
                    String[] datos ={String.valueOf(p.getId()),p.getNombre(),p.getApellidoP(),p.getApellidoM(),String.valueOf(p.getEdad()),q.getNum(),p.getEstado(),p.getPais()};
                    modelo.addRow(datos);
                }
            } else {
                String[] datos ={String.valueOf(p.getId()),p.getNombre(),p.getApellidoP(),p.getApellidoM(),String.valueOf(p.getEdad())," ",p.getEstado(),p.getPais()};
                modelo.addRow(datos);
            }
        }
        return true;
    }
    
    public List<Contacto> buscarTelefono(String tele) throws Exception{
        List<Contacto> con = new ArrayList<>();
        boolean flag;
        
        for(Contacto p:list){
            flag = true;
            if(p.getTelefonos()!=null){
                
                for(Telefono q:p.getTelefonos()){
                    if(q.getNum().equals(tele)&& flag){
                        con.add(p);
                        flag = false;
                    }
                }
            }
        } 
        return con;
    }
    
    public List<Contacto> buscarId(long id) throws Exception{
        List<Contacto> cont = new ArrayList<>();
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from contacto where idcontacto = "+id;
        
        con.comando = con.conexion.createStatement();
        ResultSet rs = con.comando.executeQuery(Query);
        
        if(rs.next()){
            Contacto c = new Contacto(
                rs.getLong("idcontacto"),
                rs.getString("nombre"),
                rs.getString("apellidoP"),
                rs.getString("apellidoM"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getInt("edad")
            );
            cont.add(c);
        }
        return cont;
    }

    public List<Contacto> buscarPais(String pa) throws Exception{
        List<Contacto> cont = new ArrayList<>();
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from contacto where pais = ?";
        
        PreparedStatement resul = con.conexion.prepareStatement(Query);
        
        resul.setString(1, pa);
        
        ResultSet rs = resul.executeQuery();
        
        while(rs.next()){
        
            Contacto c = new Contacto(
                rs.getLong("idcontacto"),
                rs.getString("nombre"),
                rs.getString("apellidoP"),
                rs.getString("apellidoM"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getInt("edad")
            );
            cont.add(c);
        }
        
        return cont;
    }
    
    public List<Contacto> buscarEdad(int ed) throws Exception{
        List<Contacto> cont = new ArrayList<>();
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from contacto where edad = ?";
        
        PreparedStatement resul = con.conexion.prepareStatement(Query);
        
        resul.setString(1, String.valueOf(ed));
        
        ResultSet rs = resul.executeQuery();
        
        while(rs.next()){
        
            Contacto c = new Contacto(
                rs.getLong("idcontacto"),
                rs.getString("nombre"),
                rs.getString("apellidoP"),
                rs.getString("apellidoM"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getInt("edad")
            );
            cont.add(c);
        }
        
        return cont;
    }
    
    
    public void eliminarContactoId(long id) throws Exception{
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "delete from contacto where idcontacto = "+id;
        
        con.comando = con.conexion.createStatement();
        Statement st = con.conexion.createStatement();
        st.executeUpdate(Query);
        
    }
    
    private void crearEnlaces(){
        Repositorio<Telefono> t = RepositorioTelefono.getRepositorio();
        List<Telefono> listT = new ArrayList<>();
        List<Telefono> listB;
        listT = t.getList();
        
        for(Contacto p:list){
            listB = new ArrayList<>();
            for(Telefono q:listT){
                if(p.getId()==q.getIdC()){
                   listB.add(q);
                }
            }
            p.setTelefonos(listB);
        }
    }    
    
    private void visualizar(){       
        for(Contacto p:list){
            System.out.println(p.toString());
            if(p.getTelefonos()!=null){
                for(Telefono q:p.getTelefonos()){
                    System.out.println(q.getNum());
                } 
            }
        }
        System.out.println("\n");
    }
    
}
