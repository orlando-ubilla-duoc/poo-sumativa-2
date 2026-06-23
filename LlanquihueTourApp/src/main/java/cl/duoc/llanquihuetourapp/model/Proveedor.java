package cl.duoc.llanquihuetourapp.model;

public class Proveedor extends Persona {
	private String giroComercial;
	private Rut rutEmpresa;
	private String tipoProductos;

	public Proveedor(String nombre, String email, String telefono, Rut rutEmpresa, String giroComercial, String tipoProductos) {
		super(nombre, email, telefono);
		this.rutEmpresa = rutEmpresa;
		this.giroComercial = giroComercial;
		this.tipoProductos = tipoProductos;
	}

	public Rut getRutEmpresa(){
		return rutEmpresa;
	}
	public void setRutEmpresa( Rut rutEmpresa ){
		this.rutEmpresa = rutEmpresa;
	}

	public String getTipoProductos(){
		return tipoProductos;
	}
	public void setTipoProductos( String tipoProductos ){
		this.tipoProductos = tipoProductos;
	}

	public String getGiroComercial(){
		return giroComercial;
	}
	public void setGiroComercial( String giroComercial ){
		this.giroComercial = giroComercial;
	}

	@Override
	public String toString() {
		return "Proveedor {" +
				"nombre=" + getNombre() + '\n' +
				", email=" + getEmail() + '\n' +
				", telefono=" + getTelefono() + '\n' +
				", direccion=" + getDireccion() + '\n' +
				", ciudad=" + getCiudad() + '\n' +
				", rut Persona=" + getRut().getRut() + '\n' +
				", rut Empresa=" + rutEmpresa.getRut() + '\n' +
				", giroComercial=" + giroComercial + '\n' +
				", tipoProductos=" + tipoProductos + '\n' +
				'}';
	}

}
