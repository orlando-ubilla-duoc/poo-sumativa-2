package cl.duoc.llanquihuetourapp.data;

import cl.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
import cl.duoc.llanquihuetourapp.model.GuiaTuristico;
import cl.duoc.llanquihuetourapp.model.Proveedor;
import cl.duoc.llanquihuetourapp.model.Operador;
import cl.duoc.llanquihuetourapp.model.Rut;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class GestorDatosDisco {

	private ArrayList<GuiaTuristico> guias;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Operador> operadores;
	private final String rutaBase = "../../../../../resources/";


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
		SimpleDateFormat formatFechas = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try( BufferedReader reader = new BufferedReader(new FileReader(rutaBase+fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					GuiaTuristico guia = new GuiaTuristico(
							columnas[0].trim(),
							columnas[1].trim(),
							columnas[2].trim(),
							formatFechas.parse(columnas[3].trim()),
							columnas[4].trim()
					);
					guias.add(guia);
				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException("El formato del archivo es inválido. Asegúrese de que cada línea tenga el formato: nombreTour;ubicacion;precio");
				}
			}
		} catch ( IOException e) {
			System.out.print(e);
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
		try( BufferedReader reader = new BufferedReader(new FileReader(rutaBase+fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Proveedor proveedor = new Proveedor(
							columnas[0].trim(),
							columnas[1].trim(),
							columnas[2].trim(),
							new Rut(columnas[3].trim()),
							columnas[4].trim(),
							columnas[5].trim()
					);
					proveedores.add(proveedor);
				} catch (Exception e) {
					System.out.print(e);
					throw new FormatoArchivoInvalidoException("El formato del archivo Proveedores es inválido.");
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
		try( BufferedReader reader = new BufferedReader(new FileReader(rutaBase+fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Operador operador = new Operador(
							columnas[0].trim(),
							columnas[1].trim(),
							columnas[2].trim(),
							columnas[3].trim(),
							columnas[4].trim(),
							Double.parseDouble(columnas[5].trim())
					);
					operadores.add(operador);
				} catch (Exception e) {
					System.out.print(e);
					throw new FormatoArchivoInvalidoException("El formato del archivo Operadores es inválido.");
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
