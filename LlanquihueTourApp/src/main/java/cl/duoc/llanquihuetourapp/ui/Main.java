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
		gestor1.cargarDatosOperadores("operadores.txt");
		gestor1.cargarDatosGuias("guias.txt");
		gestor1.cargarDatosProveedores("proveedores.txt");

		// servicios para consultar informacion de listas
		ServicioGuiasTurist servicioGuias = new ServicioGuiasTurist( gestor1.getGuias());
		System.out.println("\nListado leido de Guias Turisticos:");
		System.out.println("----------------------------------");
		servicioGuias.muestraListado();

		ServicioOperadores servicioOperadores = new ServicioOperadores( gestor1.getOperadores());
		System.out.println("\nListado leido de Operadores:");
		System.out.println("----------------------------------");
		servicioOperadores.muestraListado();

		ServicioProveedores servicioProv = new ServicioProveedores( gestor1.getProveedores() );
		System.out.println("\nListado leido de Proveedores:");
		System.out.println("----------------------------------");
		servicioProv.muestraListado();

		// Filtros
		System.out.println("\nGuias Turisticos enrolado en sistema antes de 2026:");
		System.out.println("===================================================");
		servicioGuias.buscarFechaHasta("2026-01-01");

		System.out.println("\nOperadores con tarifas sobre los $ 200 mil :");
		System.out.println("==============================================");
		servicioOperadores.buscarPrecioMax(200000.0);

		System.out.println("\nProveedores de Alojamientos:");
		System.out.println("==============================================");
		servicioProv.buscarPorCategoria("Alojamiento");


	}
}
