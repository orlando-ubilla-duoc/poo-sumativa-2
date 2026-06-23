package cl.duoc.llanquihuetourapp.services;

import cl.duoc.llanquihuetourapp.model.Operador;
import cl.duoc.llanquihuetourapp.model.Proveedor;
import java.util.ArrayList;
public class ServicioProveedores {

	private ArrayList<Proveedor> proveedores;

	public ServicioProveedores(){
		this.proveedores = new ArrayList<>();
	}
	public ServicioProveedores( ArrayList<Proveedor> listado){
		this.proveedores = listado;
	}

	/**
	 * Filtra listado e imprime por pantalla registro encontrado.
	 * @param categoria
	 */
	public void buscarPorCategoria(String categoria){
		int conta = 0;
		for(Proveedor prov: proveedores){
			if( prov.getTipoProductos().equalsIgnoreCase(categoria)){
				System.out.println(prov.toString());
				conta++;
			}
		}
		System.out.println("Total de registros encontrados: "+conta);
	}

	public void muestraListado(){
		int indice = 1;
		StringBuilder sb = new StringBuilder();
		if( proveedores.size()>0){
			for( Proveedor prov : proveedores){
				String txt1 = indice+".- ";
				sb.append(txt1).append(prov.getNombre());
				sb.append("  | Email: ").append(prov.getEmail());
				sb.append("  | Zona: ").append(prov.getRutEmpresa().getRut());
				//sb.append("  | Giro: ").append(prov.getGiroComercial());
				sb.append("  | Tipo-producto: ").append(prov.getTipoProductos()).append("\n");
				indice++;
			}
		}
		System.out.println(sb.toString());
	}

}
