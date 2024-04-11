package Logica;

public class Cliente {
    private String nombre;
    private int dni;
    private String fecNacimiento;

    public Cliente(int dni, String nombre,  String fecNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fecNacimiento = fecNacimiento;
    }
    //TODO:COrregir Combos y queda

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
}
