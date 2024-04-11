package Logica;

public class Vehiculo {
    private int id;
    private String descripcion;
    private Categoria categoria;
    private int precio;

    public Vehiculo(int id, String descripcion, Categoria categoria, int precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Vehiculo() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int calcularPrecioConCategoria(String categoria){
        return Categoria.get(categoria).getValue();
    }
}
