package cl.duoc.llanquihuetourapp.services;

import cl.duoc.llanquihuetourapp.model.GuiaTuristico;

import java.util.ArrayList;

public class ServicioGuiasTurist {

	private ArrayList<GuiaTuristico> guias;

	public ServicioGuiasTurist(){
		this.guias = new ArrayList<>();
	}
	public ServicioGuiasTurist(ArrayList<GuiaTuristico> listado){
		this.guias = listado;
	}

	/**
	 * Filtra listado e imprime por pantalla registro encontrado.
	 * @param nombreTours
	 */
	public void buscarGuiaZona(String nombreTours){
		for(GuiaTuristico guia: guias){
			for( String nombreTour : guia.getNombreTours() ){
				if( nombreTour.equalsIgnoreCase(nombreTours)){
					System.out.println("Registro encontrado!");
					System.out.println(nombreTour.toString());
				}
			}
		}
	}

	public void muestraListado(){
		int indice = 1;
		StringBuilder sb = new StringBuilder();
		if( guias.size()>0){
			for(GuiaTuristico guia : guias){
				String txt1 = indice+".- ";
				sb.append(txt1).append(guia.getNombre());
				sb.append("  | Nombre: ").append(guia.getNombre());
				sb.append("  | Email: ").append(guia.getEmail());
				sb.append("  | Fono: ").append(guia.getTelefono());

				sb.append("  | Fecha Cliente: ").append(guia.getFechaCliente());
				sb.append("  | Agencia: ").append(guia.getNombreAgencia());
			}
		}
		System.out.println(sb.toString());
	}

}
