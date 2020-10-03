package ar.com.dartech.clase140820.models;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private String barcode;
    private int imagen;

    public Producto(int id, String nombre, float precio, String barcode, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.barcode = barcode;
        this.imagen = imagen;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
