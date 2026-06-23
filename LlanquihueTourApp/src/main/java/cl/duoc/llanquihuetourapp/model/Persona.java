package cl.duoc.llanquihuetourapp.model;

import cl.duoc.llanquihuetourapp.excepciones.RutInvalidoException;
import cl.duoc.llanquihuetourapp.model.Rut;

/**
 * Clase que representa a una persona con sus datos personales, incluyendo un RUT validado.
 */
public class Persona {

	private String nombre;
	private String email;
	private String telefono;
	private String direccion;
	private String ciudad;
	private Rut rut;

	/**
	 * Constructor que recibe los datos personales de la persona, incluyendo un RUT validado.
	 * @param nombre El nombre completo de la persona.
	 * @param email El correo electrónico de la persona.
	 * @param telefono El número de teléfono de la persona.
	 * @param direccion La dirección de la persona.
	 * @param ciudad La ciudad de la persona.
	 * @param rut El RUT de la persona, que debe ser válido.
	 * @throws RutInvalidoException Si el RUT proporcionado no es válido.
	 */
	public Persona(String nombre, String email, String telefono, Rut rut) {
		this.nombre   = nombre;
		this.email    = email;
		this.telefono = telefono;
		this.rut      = rut;
	}
	public Persona(String nombre, String email, String telefono) {
		try {
			this.nombre    = nombre;
			this.email     = email;
			this.telefono  = telefono;
			this.rut       = new Rut("1000000-9");
			this.direccion = "";
			this.ciudad    = "";
		} catch ( RutInvalidoException e) {
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rut getRut() {
		return rut;
	}

	public void setRut(Rut rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}