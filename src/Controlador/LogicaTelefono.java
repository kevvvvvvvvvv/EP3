
package Controlador;

import Modelo.Contacto;
import Modelo.Telefono;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

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
        if(buscarContacto(idCon) == null){
            throw new Exception();
        }
        
        
        //Telefono telefono = new Telefono(id,te,com,pre,pais,tipo,idCon);
        agregarTelefono(id,te,com,pre,pais,tipo,idC);
    }
    
    private void agregarTelefono(long id, String te, String com, String pre, String pais, String tipo, String idC) throws SQLException, Exception{
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        
        String Query = "insert into telefono values(?,?,?,?,?,?,?)";
        
        PreparedStatement insertar = cone.conexion.prepareStatement(Query);
        
        insertar.setString(1,String.valueOf(generarId()));
        insertar.setString(2,te);
        insertar.setString(3,com);
        insertar.setString(4,tipo);
        insertar.setString(5,pre);
        insertar.setString(6,pais);
        insertar.setString(7,idC);
        insertar.executeUpdate();
    }
    
    private int generarId() throws SQLException, Exception{
        Conexion cone = new Conexion();
        int id = 0;
        cone.JavaToMySQL();
        String Query = "select max(idtelefono) from telefono";
        
        cone.comando = cone.conexion.createStatement();
        ResultSet rs = cone.comando.executeQuery(Query);
        if (rs.next()) {
            id = rs.getInt(1); // Obtener el primer resultado de la consulta
            if (rs.wasNull()) {
                id = 99; // Si el valor era null, asignar 99
            }
        }
        return (id+1);
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
                //ID DE TELEFONO
                //Verificando que haya colocado un numero de ID
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
        
        c = buscarContacto(t.getIdC());
        
        DefaultTableModel modelo =(DefaultTableModel) usuarios.getModel();
        modelo.setRowCount(0);  
        
        //Mostrar los datos en la tabla de la interfaz gráfica
        String[] datos ={c.getNombre(),String.valueOf(c.getId()),String.valueOf(t.getId()),t.getNum(),t.getCompania(),t.getPrefijo(),t.getPais(),t.getTipo()};
        modelo.addRow(datos);
        
        return true;
    }
    
    public Telefono buscarTelefono(String tele) throws Exception{
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from telefono where numero = "+tele;
        con.comando = con.conexion.createStatement();
        ResultSet rs = con.comando.executeQuery(Query);
        
        if (rs.next()){
            Telefono t = new Telefono(
                rs.getLong("idtelefono"),
                rs.getString("numero"),
                rs.getString("compania"),
                rs.getString("prefijo"),
                rs.getString("pais"),
                rs.getString("tipo"),
                rs.getLong("idcontacto")
            );
            return t;
        }
        return null;
    }
    
    public Telefono buscarId(long idT) throws Exception{
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from telefono where idtelefono = "+idT;
        con.comando = con.conexion.createStatement();
        ResultSet rs = con.comando.executeQuery(Query);
        
        if (rs.next()){
            Telefono t = new Telefono(
                rs.getLong("idtelefono"),
                rs.getString("numero"),
                rs.getString("compania"),
                rs.getString("prefijo"),
                rs.getString("pais"),
                rs.getString("tipo"),
                rs.getLong("idcontacto")
            );
            return t;
        }
        return null;
    }
    
    public Contacto buscarContacto(long idC) throws Exception{
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "select * from contacto where idcontacto = "+idC;
        
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
            return c;
        }
        return null;
    }
    
    public void eliminarTelefono(long id) throws Exception{
        Conexion con = new Conexion();
        con.JavaToMySQL();
       
        String Query = "delete from telefono where idtelefono = "+id;
        
        con.comando = con.conexion.createStatement();
        Statement st = con.conexion.createStatement();
        st.executeUpdate(Query);
    }
    
    public void actualizarTelefono(long id, String te, String com, String pre, String pais, String tipo) throws Exception{
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        
        String Query = "update telefono set numero = ?, compania = ?, prefijo = ?, pais = ?, tipo = ? where idtelefono = ?";
        
        PreparedStatement actualizar = cone.conexion.prepareStatement(Query);
        
        actualizar.setString(1,te);
        actualizar.setString(2,com);
        actualizar.setString(3,pre);
        actualizar.setString(4,pais);
        actualizar.setString(5,tipo);
        actualizar.setString(6,String.valueOf(id));
        actualizar.executeUpdate();
    }
    
    
    /*PARA LA CREACIÓN DE GRÁFICAS*/
    
    public DefaultCategoryDataset getDatos(int opc) throws Exception{
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        Conexion cone = new Conexion();
        cone.JavaToMySQL();
        ResultSet rs;
        
        int i=1, total=0;
        String Query;
        
        switch(opc){
            case 0:
                String comp="";
        
                Query = "select compania, count(*) as total  from telefono group by compania";
                cone.comando = cone.conexion.createStatement();
                rs = cone.comando.executeQuery(Query);

                while(rs.next()){
                    comp = rs.getString("compania");
                    total = rs.getInt("total");

                    datos.setValue(total, "Compañía "+i, comp);
                    i++;
                }
                break;
            
            case 1:
                String tipo="";
        
                Query = "select tipo, count(*) as total  from telefono group by tipo";
                cone.comando = cone.conexion.createStatement();
                rs = cone.comando.executeQuery(Query);

                while(rs.next()){
                    tipo = rs.getString("tipo");
                    total = rs.getInt("total");

                    datos.setValue(total, "Tipo "+i, tipo);
                    i++;
                }
                break;
                
            case 2:
                String pais="";
                
                Query = "select pais, count(*) as total from telefono group by pais";
                cone.comando = cone.conexion.createStatement();
                rs = cone.comando.executeQuery(Query);
                
                while(rs.next()){
                    pais = rs.getString("pais");
                    total = rs.getInt("total");

                    datos.setValue(total, "País "+i, pais);
                    i++;
                }
                break;
        }
        
        return datos;         
    }
    
    
    /*FUNCIÓN ANTIGUA*/
    
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
}

