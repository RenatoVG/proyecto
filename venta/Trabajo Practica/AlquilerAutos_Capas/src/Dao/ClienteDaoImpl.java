package Dao;

import Logica.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao{
    private final String filePath;

    public ClienteDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int dni = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                String fecNacimiento = parts[2];
                Cliente cliente = new Cliente( dni, nombre, fecNacimiento);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return clientes;

    }

    @Override
    public void registar(Cliente cliente) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(cliente.getDni() + "," + cliente.getNombre() + "," +cliente.getFecNacimiento());
            bw.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Cliente getCliente(int dni) {
        List<Cliente> clientes = getClientes();
        for (Cliente cliente : clientes){
            if (cliente.getDni() == dni){
                return cliente;
            }
        }
        return null;
    }
}
