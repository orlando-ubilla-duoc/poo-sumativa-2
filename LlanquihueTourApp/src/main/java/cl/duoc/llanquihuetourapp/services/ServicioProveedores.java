package cl.duoc.llanquihuetourapp.services;

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
			System.out.println("Total de registros encontrados: "+conta);
		}
	}

	public void muestraListado(){
		for(Proveedor prov: proveedores){
			System.out.println(prov.toString());
		}
	}

}
