package cl.duoc.llanquihuetourapp.data;

import cl.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
import cl.duoc.llanquihuetourapp.model.GuiaTuristico;
import cl.duoc.llanquihuetourapp.model.Proveedor;
import cl.duoc.llanquihuetourapp.model.Operador;
import cl.duoc.llanquihuetourapp.model.Rut;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GestorDatosDisco {

	private ArrayList<GuiaTuristico> guias;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Operador> operadores;


	public GestorDatosDisco() {
		this.guias = new ArrayList<GuiaTuristico>();
		this.proveedores = new ArrayList<Proveedor>();
		this.operadores = new ArrayList<Operador>();
	}

	/**
	 * Lee datos desde archivo de Guias Turisticos.
	 * @param fileName
	 */
	public void cargarDatosGuias(String fileName){

		System.out.println("STEP-0");
		//try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){
		try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
			if (is == null) {
				System.out.println("File not found in resources dir.: " + fileName);
			}
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
				String linea;
				System.out.println("STEP-1");
				while( (linea = reader.readLine())!=null ){
					try {
						System.out.println("STEP-2");
						String[] columnas = linea.split(";");
						GuiaTuristico guia = new GuiaTuristico(
								columnas[0],
								columnas[1],
								columnas[2],
								columnas[3],
								columnas[4]
						);
						guias.add(guia);
					} catch (Exception e) {
						System.out.println("El formato del archivo es inválido.");
					}
				}
			}
		} catch( IOException e ){
			throw new RuntimeException(e);
		}

		try( BufferedReader reader = new BufferedReader( new InputStreamReader(GestorDatosDisco.class.getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8) ) ){
			String linea;
			System.out.println("STEP-1");
			while( (linea = reader.readLine())!=null ){
				try {
					System.out.println("STEP-2");
					String[] columnas = linea.split(";");
					GuiaTuristico guia = new GuiaTuristico(
							columnas[0],
							columnas[1],
							columnas[2],
							columnas[3],
							columnas[4]
					);
					guias.add(guia);
				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException("El formato del archivo es inválido. Asegúrese de que cada línea tenga el formato: nombreTour;ubicacion;precio");
				}
			}
		} catch ( IOException e) {
			System.out.println("Error al leer el archivo de Guias Turisticos: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	public ArrayList<GuiaTuristico> getGuias(){
		return guias;
	}

	/**
	 * Lee datos desde archivo de los Proveedores.
	 * @param fileName
	 */
	public void cargarDatosProveedores(String fileName){
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Proveedor proveedor = new Proveedor(
							columnas[0],
							columnas[1],
							columnas[2],
							new Rut(columnas[3]),
							columnas[4],
							columnas[5]
					);
					proveedores.add(proveedor);
				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException("El formato del archivo es inválido. Asegúrese de que cada línea tenga el formato: nombreTour;ubicacion;precio");
				}
			}
		} catch ( IOException e) {
			System.out.println("Error al leer el archivo de Proveedores: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	public ArrayList<Proveedor> getProveedores(){
		return proveedores;
	}

	/**
	 * Lee datos desde archivo de los Operadores.
	 * @param fileName
	 */
	public void cargarDatosOperadores(String fileName){
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Operador operador = new Operador(
							columnas[0],
							columnas[1],
							columnas[2],
							columnas[3],
							columnas[4],
							Double.parseDouble(columnas[5])
					);
					operadores.add(operador);
				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException("El formato del archivo es inválido. Asegúrese de que cada línea tenga el formato: nombreTour;ubicacion;precio");
				}
			}
		} catch ( IOException e) {
			System.out.println("Error al leer el archivo de Operadores: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	public ArrayList<Operador> getOperadores(){
		return operadores;
	}
}
