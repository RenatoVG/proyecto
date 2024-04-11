package Dao;

import Logica.Vehiculo;

import java.util.List;

public interface VehiculoDao {
    List<Vehiculo> getVehiculos();
    Vehiculo getVehiculo(int idVehiculo);
}
