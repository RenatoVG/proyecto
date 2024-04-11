package Dao;

import Logica.Cliente;

import java.util.List;

public interface ClienteDao {
    List<Cliente> getClientes();
    void registar(Cliente cliente);
    Cliente getCliente( int dni);
}
