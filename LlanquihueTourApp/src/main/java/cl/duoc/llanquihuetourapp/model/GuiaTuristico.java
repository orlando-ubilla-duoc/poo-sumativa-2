package cl.duoc.llanquihuetourapp.model;

import cl.duoc.llanquihuetourapp.model.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuiaTuristico extends Persona {

	// Fecha en que se enrola al cliente.
	private Date fechaCliente;
	private String NombreAgencia;
	private List<String> NombreTours;

	public GuiaTuristico(String nombre, String email, String telefono, Date fecha, String agencia) {
		super(nombre, email, telefono);
		fechaCliente = fecha;
		NombreAgencia = agencia;
		NombreTours = new ArrayList<>();
	}

	public Date getFechaCliente() {
		return fechaCliente;
	}
	public void setFechaCliente(Date fechaCliente) {
		this.fechaCliente = fechaCliente;
	}

	public String getNombreAgencia(){
		return NombreAgencia;
	}
	public void setNombreAgencia( String nombreAgencia ){
		NombreAgencia = nombreAgencia;
	}

	public List<String> getNombreTours(){
		return NombreTours;
	}
	public void addNombreTour( String nombre){
		NombreTours.add(nombre);
	}

	@Override
	public String toString() {
		return "GuiaTuristico {" +
				"nombre=" + getNombre() + '\n' +
				", email=" + getEmail() + '\n' +
				", telefono=" + getTelefono() + '\n' +
				", direccion=" + getDireccion() + '\n' +
				", ciudad=" + getCiudad() + '\n' +
				", rut=" + getRut().getRut() + '\n' +
				", fechaCliente=" + fechaCliente + '\n' +
				", NombreAgencia=" + NombreAgencia + '\n' +
				'}';
	}
}
