package Logica;

import java.time.LocalTime;

public class Alquiler {
    private Vehiculo vehiculo;
    private Cliente cliente;
    private String nombreVehiculo;
    private String nombreCliente;
    private LocalTime horaRecogida;
    private  int horasFacturadas;
    private int dineroFacturado;

    public Alquiler(Vehiculo vehiculo, Cliente cliente, String nombreVehiculo, String nombreCliente, LocalTime horaRecogida, int horasFacturadas, int dineroFacturado) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.nombreVehiculo = nombreVehiculo;
        this.nombreCliente = nombreCliente;
        this.horaRecogida = horaRecogida;
        this.horasFacturadas = horasFacturadas;
        this.dineroFacturado = dineroFacturado;
    }

    public Alquiler() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalTime getHoraRecogida() {
        return horaRecogida;
    }

    public void setHoraRecogida(LocalTime horaRecogida) {
        this.horaRecogida = horaRecogida;
    }

    public int getHorasFacturadas() {
        return horasFacturadas;
    }

    public void setHorasFacturadas(int horasFacturadas) {
        this.horasFacturadas = horasFacturadas;
    }

    public int getDineroFacturado() {
        return dineroFacturado;
    }

    public void setDineroFacturado(int dineroFacturado) {
        this.dineroFacturado = dineroFacturado;
    }
}
