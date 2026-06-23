package cl.duoc.llanquihuetourapp.model;

//import cl.duoc.llanquihuetourapp.model.Persona;
//import cl.duoc.llanquihuetourapp.model.Rut;
public class Operador extends Persona {

	private String zona;
	private String giroComercial;
	private double precioServicio;

	public Operador(String nombre, String email, String telefono, String zona, String giroComercial, double precio) {
		super(nombre, email, telefono);
		this.zona = zona;
		this.giroComercial = giroComercial;
		this.precioServicio = precio;
	}

	public void setZona(String zona){
		zona = zona;
	}
	public String getZona(){
		return zona;
	}

	public void setGiroComercial( String giroComercial ){
		this.giroComercial = giroComercial;
	}
	public String getGiroComercial(){
		return giroComercial;
	}

	public void setPrecioServicio( double precioServicio ){
		this.precioServicio = precioServicio;
	}
	public double getPrecioServicio(){
		return precioServicio;
	}

	@Override
	public String toString() {
		return "Operador {" +
				"nombre=" + getNombre() + '\n' +
				", email=" + getEmail() + '\n' +
				", telefono=" + getTelefono() + '\n' +
				", direccion=" + getDireccion() + '\n' +
				", ciudad=" + getCiudad() + '\n' +
				", rut=" + getRut().getRut() + '\n' +
				", zona=" + zona + '\n' +
				", giroComercial=" + giroComercial + '\n' +
				", precioServicio=" + precioServicio + '\n' +
				'}';
	}
}
