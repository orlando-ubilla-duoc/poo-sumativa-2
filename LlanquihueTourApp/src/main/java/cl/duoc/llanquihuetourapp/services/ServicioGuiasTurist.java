package cl.duoc.llanquihuetourapp.services;

import cl.duoc.llanquihuetourapp.model.GuiaTuristico;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
	 * @param fechaLimite
	 */
	public void buscarFechaHasta(String fechaLimite){
		try {
			for(GuiaTuristico guia: guias){
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				Date fechaLimit = formatter.parse(fechaLimite);
				if( guia.getFechaCliente().compareTo(fechaLimit) < 0 ){
					System.out.println(guia.toString());
				}
			}
		}catch(Exception e ){
			System.out.println(e.getMessage());
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
				sb.append("  | Agencia: ").append(guia.getNombreAgencia()).append("\n");
				indice++;
			}
		}
		System.out.println(sb.toString());
	}

}
