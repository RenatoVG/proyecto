package Presentador;

import Logica.Alquiler;
import Logica.Cliente;
import Logica.Vehiculo;

import java.util.List;

public interface IAlquiler {
    void setPresentador(AlquilerPresentador presentador);
    void iniciar();
    Vehiculo getVehiculo();
    Cliente getCliente();
    Alquiler getAlquiler();
    String getCategoria();
    String getTipoVehiculo();
    int getPrecio();
    void setPrecio(String precio);
    void mostrarCategorias(List<String> categorias);
    void mostrarMensaje(String mensaje);
    void setOperaciones(List<String> operaciones);
    void setDatosVehiculo(Vehiculo vehiculo);


}
