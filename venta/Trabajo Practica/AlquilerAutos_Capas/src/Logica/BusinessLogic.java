package Logica;

import Dao.AlquilerDao;
import Dao.ClienteDao;
import Dao.VehiculoDao;

import java.time.LocalTime;
import java.util.List;

public class BusinessLogic {
    private VehiculoDao vehiculoDao;
    private AlquilerDao alquilerDao;
    private ClienteDao clienteDao;

    public BusinessLogic(VehiculoDao vehiculoDao, AlquilerDao alquilerDao, ClienteDao clienteDao) {
        this.vehiculoDao = vehiculoDao;
        this.alquilerDao = alquilerDao;
        this.clienteDao = clienteDao;
    }

    public void saveAlquiler(int idCliente, Vehiculo vehiculo, Alquiler alquiler) {
        alquiler.setNombreCliente(clienteDao.getCliente(idCliente).getNombre());
        alquiler.setNombreVehiculo(vehiculo.getDescripcion());
        alquiler.setHoraRecogida(LocalTime.now());
        alquiler.setHorasFacturadas(alquiler.getHorasFacturadas());
        alquiler.setDineroFacturado(vehiculo.getPrecio() * alquiler.getHorasFacturadas());
        alquilerDao.registrarAlquiler(alquiler);
    }

    public Cliente getCliente( int dni){
        return clienteDao.getCliente(dni);
    }

    public void registarCliente(Cliente cliente){
        clienteDao.registar(cliente);
    }

    public Vehiculo getVehiculo(int idVehiculo){
        return vehiculoDao.getVehiculo(idVehiculo);
    }

    public List<Alquiler> getAlquileresDuenio(String duenio) {
        return alquilerDao.getAlquileresDuenio(duenio);
    }
}
