package Dao;

import Logica.Alquiler;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDaoImpl implements AlquilerDao{
    private final String filePath;

    public AlquilerDaoImpl(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public List<Alquiler> getAlquileres() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
        List<Alquiler> alquilers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nombreVehiculo = parts[0];
                String nombreCliente = parts[1];
                LocalTime horaRecogida = LocalTime.parse(parts[2]);
                int horasFacturadas = Integer.parseInt(parts[3]);
                int dineroFacturado = Integer.parseInt(parts[4]);
                Alquiler alquiler = new Alquiler(null,null,nombreVehiculo,nombreCliente,horaRecogida,horasFacturadas,dineroFacturado);
                alquilers.add(alquiler);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return alquilers;
    }

    @Override
    public Alquiler registrarAlquiler(Alquiler alquiler) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(alquiler.getNombreVehiculo() + "," + alquiler.getNombreCliente() + "," + alquiler.getHoraRecogida() + "," + alquiler.getHorasFacturadas() + "," + alquiler.getDineroFacturado());
            bw.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return alquiler;
    }

    @Override
    public List<Alquiler> getAlquileresDuenio(String Duenio) {
        List<Alquiler> alquilers = getAlquileres();
        List<Alquiler> alquiladoDuenio = new ArrayList<>();
        for (Alquiler alquiler : alquilers) {
            if (alquiler.getNombreCliente().equals(Duenio)) {
                alquiladoDuenio.add(alquiler);
            }
        }
        return alquiladoDuenio;
    }
}
