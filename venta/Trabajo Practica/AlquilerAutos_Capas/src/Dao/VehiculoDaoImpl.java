package Dao;

import Logica.Categoria;
import Logica.Vehiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDaoImpl implements VehiculoDao {
    private final String filePath;

    public VehiculoDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String descripcion = parts[1];
                Categoria categoria = Categoria.valueOf(parts[2]);
                int precio = Integer.parseInt(parts[3]);
                Vehiculo vehiculo = new Vehiculo(id, descripcion, categoria, precio);
                vehiculos.add(vehiculo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public Vehiculo getVehiculo(int idVehiculo) {
        List<Vehiculo> vehiculos = getVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getId() == idVehiculo) {
                return vehiculo;
            }
        }
        return null;
    }
}
