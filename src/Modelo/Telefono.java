
package Modelo;

/* @author kevin*/ 

public class Telefono {
    
    private long id;
    private String num;
    private String compania;
    private String prefijo;
    private String pais;
    private String tipo;
    private long idC; 
    
    public Telefono(){
        
    }

    public Telefono(long id, String num, String compania, String prefijo, String pais, String tipo,long idC) {
        this.id = id;
        this.num = num;
        this.compania = compania;
        this.prefijo = prefijo;
        this.pais = pais;
        this.tipo = tipo;
        this.idC=idC;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public long getIdC() {
        return idC;
    }

    public void setTipo(long idC) {
        this.idC = idC;
    }
    
}
