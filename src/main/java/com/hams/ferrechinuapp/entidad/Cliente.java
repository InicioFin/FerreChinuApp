package com.hams.ferrechinuapp.entidad;

public class Cliente {
    private String numero;
    private String Documento_tipo;
    private String nombre;
    private String barrio;
    private String direccion;
    private String celular;
    private String correo;
    private String clave;
    public Cliente() {
    }
    public Cliente(String Documento_tipo, String numero)  {
        setDocumento_tipo(Documento_tipo);
        setNumero(numero);
    }
    public Cliente(String numero, String documento_tipo, String nombre, String barrio, String direccion, String celular, String correo, String clave) {
        this.numero = numero;
        this.Documento_tipo = documento_tipo;
        this.nombre = nombre;
        this.barrio = barrio;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.clave = clave;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setDocumento_tipo(String documento_tipo) {
        this.Documento_tipo = documento_tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setClave(String clave) {this.clave=clave;}
    public String getNumero() {
        return numero;
    }
    public String getDocumento_tipo() {
        return Documento_tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getBarrio() {
        return barrio;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCelular() {
        return celular;
    }
    public String getCorreo() {
        return correo;
    }
    public String getClave(){ return clave;}
}
