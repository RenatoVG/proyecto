/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

import Dao.*;
import Presentador.AlquilerPresentador;
import Vista.FView;
import Presentador.IAlquiler;

public class AlquilerAutos_Capas {

    public static void main(String[] args) {
        ClienteDao clienteDao = new ClienteDaoImpl("cliente.txt");
        VehiculoDao vehiculoDao = new VehiculoDaoImpl("vehiculo.txt");
        AlquilerDao alquilerDao = new AlquilerDaoImpl("alquiler.txt");
        IAlquiler vista = new FView();
        AlquilerPresentador alquilerPresentador = new AlquilerPresentador(vista,vehiculoDao,alquilerDao,clienteDao);
        vista.setPresentador(alquilerPresentador);
        vista.iniciar();
    }
    
}
