/*
package Presentador;

import Dao.AlquilerDao;
import Dao.ClienteDao;
import Dao.VehiculoDao;
import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Vehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class AlquilerPresentador implements ActionListener {
    private IAlquiler iAlquiler;
    private VehiculoDao vehiculoDao;
    private AlquilerDao alquilerDao;
    private ClienteDao  clienteDao;
    private String mensaje;

    public AlquilerPresentador(IAlquiler iAlquiler, VehiculoDao vehiculoDao, AlquilerDao alquilerDao, ClienteDao clienteDao) {
        this.iAlquiler = iAlquiler;
        this.vehiculoDao = vehiculoDao;
        this.alquilerDao = alquilerDao;
        this.clienteDao = clienteDao;
    }

    public void saveAlquiler(int idCliente) {
        Vehiculo vehiculo = iAlquiler.getVehiculo();
        Alquiler alquiler = iAlquiler.getAlquiler();

        alquiler.setNombreCliente(clienteDao.getCliente(idCliente).getNombre());
        alquiler.setNombreVehiculo(vehiculo.getDescripcion());
        alquiler.setHoraRecogida(LocalTime.now());
        alquiler.setHorasFacturadas(alquiler.getHorasFacturadas());
        alquiler.setDineroFacturado(vehiculo.getPrecio()*alquiler.getHorasFacturadas());
        alquilerDao.registrarAlquiler(alquiler);
        this.mensaje = "Alquiler Exitoso";
        getMensaje();
        guardarAlquiler(alquiler.getNombreCliente());
    }

    public void saveCliente(){
        Cliente cliente = iAlquiler.getCliente();
        if(clienteDao.getCliente(cliente.getDni())==null){
            clienteDao.registar(cliente);
        }
        saveAlquiler(cliente.getDni());
    }

    public void getMensaje() {
        iAlquiler.mostrarMensaje(mensaje);
    }

    public void llenarCategoria() {
        List<String> categorias = new ArrayList<>();
        if(iAlquiler.getTipoVehiculo().equals("Carro")) {
            categorias.add(Modelo.Categoria.A.getKey());
            categorias.add(Modelo.Categoria.B.getKey());
            categorias.add(Modelo.Categoria.C.getKey());
        }
        iAlquiler.mostrarCategorias(categorias);

    }

    public void llenarVehiculos() {
        int idTipoVehiculo;
        if (iAlquiler.getTipoVehiculo().equals("Carro")) {
            idTipoVehiculo = 1;
        } else if (iAlquiler.getTipoVehiculo().equals("Moto")) {
            idTipoVehiculo = 2;
        } else {
            idTipoVehiculo = 3;
        }
        Vehiculo vehiculo = vehiculoDao.getVehiculo(idTipoVehiculo);
        llenarCategoria();
        iAlquiler.setDatosVehiculo(vehiculo);
    }
    public void llenarPrecio(){
        if(iAlquiler.getCategoria().equals("A")){
            iAlquiler.setPrecio("18");
        } else if (iAlquiler.getCategoria().equals("B")) {
            iAlquiler.setPrecio("14");
        } else if (iAlquiler.getCategoria().equals("C")){
            iAlquiler.setPrecio("10");
        }
    }

    public void guardarAlquiler(String cliente) {
        List<String> detalleAlquiler = new ArrayList<String>();
        for (Alquiler alquiler : alquilerDao.getAlquileresDuenio(cliente)) {
            detalleAlquiler.add(alquiler.getNombreVehiculo() +
                    "\t" + alquiler.getNombreCliente() +
                    "\t" + alquiler.getHoraRecogida().toString().substring(0,8) +
                    "\t" + alquiler.getHorasFacturadas() +
                    "\t" + alquiler.getDineroFacturado() +
                    "\n");
            iAlquiler.setOperaciones(detalleAlquiler);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Alquilar")){
            saveCliente();
        } else if (e.getActionCommand().equals("combo")) {
            llenarVehiculos();
        } else if (e.getActionCommand().equals("categoria")) {
            llenarPrecio();
        }
    }

}
*/
package Presentador;

import Dao.AlquilerDao;
import Dao.ClienteDao;
import Dao.VehiculoDao;
import Logica.Alquiler;
import Logica.BusinessLogic;
import Logica.Cliente;
import Logica.Vehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class AlquilerPresentador implements ActionListener {
    private IAlquiler iAlquiler;
    private BusinessLogic businessLogic;
    private String mensaje;

    public AlquilerPresentador(IAlquiler iAlquiler, VehiculoDao vehiculoDao, AlquilerDao alquilerDao, ClienteDao clienteDao) {
        this.iAlquiler = iAlquiler;
        this.businessLogic = new BusinessLogic(vehiculoDao,alquilerDao,clienteDao);
    }

    public void saveAlquiler(int idCliente) {
        Vehiculo vehiculo = iAlquiler.getVehiculo();
        Alquiler alquiler = iAlquiler.getAlquiler();
        businessLogic.saveAlquiler(idCliente,vehiculo,alquiler);
        this.mensaje = "Alquiler Exitoso";
        getMensaje();
        guardarAlquiler(alquiler.getNombreCliente());
    }

    public void saveCliente(){
        Cliente cliente = iAlquiler.getCliente();
        if(businessLogic.getCliente(cliente.getDni())==null){
            businessLogic.registarCliente(cliente);
        }
        saveAlquiler(cliente.getDni());
    }

    public void getMensaje() {
        iAlquiler.mostrarMensaje(mensaje);
    }

    public void llenarCategoria() {
        List<String> categorias = new ArrayList<>();
        if(iAlquiler.getTipoVehiculo().equals("Carro")) {
            categorias.add(Logica.Categoria.A.getKey());
            categorias.add(Logica.Categoria.B.getKey());
            categorias.add(Logica.Categoria.C.getKey());
        }
        iAlquiler.mostrarCategorias(categorias);

    }

    public void llenarVehiculos() {
        int idTipoVehiculo;
        if (iAlquiler.getTipoVehiculo().equals("Carro")) {
            idTipoVehiculo = 1;
        } else if (iAlquiler.getTipoVehiculo().equals("Moto")) {
            idTipoVehiculo = 2;
        } else {
            idTipoVehiculo = 3;
        }
        Vehiculo vehiculo = businessLogic.getVehiculo(idTipoVehiculo);
        llenarCategoria();
        iAlquiler.setDatosVehiculo(vehiculo);
    }
    public void llenarPrecio(){
        if(iAlquiler.getCategoria().equals("A")){
            iAlquiler.setPrecio("18");
        } else if (iAlquiler.getCategoria().equals("B")) {
            iAlquiler.setPrecio("14");
        } else if (iAlquiler.getCategoria().equals("C")){
            iAlquiler.setPrecio("10");
        }
    }

    public void guardarAlquiler(String cliente) {
        List<String> detalleAlquiler = new ArrayList<String>();
        for (Alquiler alquiler : businessLogic.getAlquileresDuenio(cliente)) {
            detalleAlquiler.add(alquiler.getNombreVehiculo() +
                    "\t" + alquiler.getNombreCliente() +
                    "\t" + alquiler.getHoraRecogida().toString().substring(0,8) +
                    "\t" + alquiler.getHorasFacturadas() +
                    "\t" + alquiler.getDineroFacturado() +
                    "\n");
            iAlquiler.setOperaciones(detalleAlquiler);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Alquilar")){
            saveCliente();
        } else if (e.getActionCommand().equals("combo")) {
            llenarVehiculos();
        } else if (e.getActionCommand().equals("categoria")) {
            llenarPrecio();
        }
    }

}
