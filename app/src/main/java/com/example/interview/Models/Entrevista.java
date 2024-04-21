package com.example.interview.Models;

public class Entrevista {

    private int IdOrden;
    private String Descripcion;
    private String Periodista;
    private String Fecha;
    private String Imagen;
    private String Audio;

    public Entrevista(){

    }

    public Entrevista(int idOrden, String descripcion, String periodista, String fecha, String imagen, String audio) {
        IdOrden = idOrden;
        Descripcion = descripcion;
        Periodista = periodista;
        Fecha = fecha;
        Imagen = imagen;
        Audio = audio;
    }

    public int getIdOrden() {
        return IdOrden;
    }

    public void setIdOrden(int idOrden) {
        IdOrden = idOrden;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPeriodista() {
        return Periodista;
    }

    public void setPeriodista(String periodista) {
        Periodista = periodista;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getAudio() {
        return Audio;
    }

    public void setAudio(String audio) {
        Audio = audio;
    }
}
