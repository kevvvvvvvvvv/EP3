
package Modelo;

import java.util.ArrayList;
import java.util.List;

/*@author kevin*/

public class Contacto {
    private long id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String estado;
    private String pais;
    private int edad;
    private List<Telefono> telefonos;

    
    public Contacto() {
    }

    public Contacto(long id, String nombre, String apellidoP, String apellidoM, String estado, String pais, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.estado = estado;
        this.pais = pais;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    
    @Override
    public String toString(){
        return id+" "+nombre+" "+apellidoP+" "+apellidoM+" "+edad;
    }
}
