package cl.duoc.llanquihuetourapp.ui;

import cl.duoc.llanquihuetourapp.data.GestorDatosDisco;
import cl.duoc.llanquihuetourapp.services.ServicioGuiasTurist;
import cl.duoc.llanquihuetourapp.services.ServicioOperadores;
import cl.duoc.llanquihuetourapp.services.ServicioProveedores;

public class Main {
	public static void main(String[] args) {

		System.out.println("Actividad Sumativa 2: Organización modular y creación de una librería personalizada");
		System.out.println("-----------------------------------------------------------------------------------");

		// gestor de E/S archivos
		GestorDatosDisco gestor1 = new GestorDatosDisco();

		// Carga datos desde disco
		//gestor1.cargarDatosOperadores("operadores.txt");
		gestor1.cargarDatosGuias("guias.txt");
		//gestor1.cargarDatosProveedores("proveedores.txt");

		// servicios para consultar informacion de listas
		ServicioGuiasTurist servicioGuias = new ServicioGuiasTurist( gestor1.getGuias() );
		System.out.println("Listado leido de Guias Turisticos:");
		System.out.println("----------------------------------");
		servicioGuias.muestraListado();
		//ServicioOperadores servicioOperadores = new ServicioOperadores( gestor1.getOperadores() );
		//ServicioProveedores servicioProveedores = new ServicioProveedores( gestor1.getProveedores() );

		//gestor1
	}
}
