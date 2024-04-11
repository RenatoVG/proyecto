package Dao;

import Logica.Alquiler;

import java.util.List;

public interface AlquilerDao {
    List<Alquiler> getAlquileres();
    List<Alquiler> getAlquileresDuenio(String Duenio);
    Alquiler registrarAlquiler(Alquiler alquiler);


}
