package cl.duoc.llanquihuetourapp.services;

import cl.duoc.llanquihuetourapp.model.GuiaTuristico;
import cl.duoc.llanquihuetourapp.model.Operador;

import java.util.ArrayList;

public class ServicioOperadores {

	private ArrayList<Operador> operadores;

	public ServicioOperadores(){
		this.operadores = new ArrayList<>();
	}
	public ServicioOperadores(ArrayList<Operador> listado){
		this.operadores = listado;
	}

	/**
	 * Filtra listado e imprime por pantalla registro encontrado.
	 * @param valorMax
	 */
	public void buscarPrecioMax(double valorMax){
		int conta = 0;
		for( Operador op: operadores){
			if( op.getPrecioServicio() <= valorMax ){
				System.out.println(op.toString());
				conta++;
			}
		}
		System.out.println(conta+" registros están por debajo de "+valorMax);
	}

	public void muestraListado(){
		int indice = 1;
		StringBuilder sb = new StringBuilder();
		if( operadores.size()>0){
			for(Operador op : operadores){
				String txt1 = indice+".- ";
				sb.append(txt1).append(op.getNombre());
				sb.append("  | Nombre: ").append(op.getNombre());
				sb.append("  | Email: ").append(op.getEmail());
				sb.append("  | Fono: ").append(op.getTelefono());
				sb.append("  | Zona: ").append(op.getZona());
				sb.append("  | Giro: ").append(op.getGiroComercial());
				sb.append("  | Precio: ").append(op.getPrecioServicio()).append("\n");
				indice++;
			}
		}
		System.out.println(sb.toString());
	}

}
